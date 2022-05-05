use trojas_viejas_db;


/*----------------------------------MOSTRAR------------------------------------------------------*/
DELIMITER $$
CREATE PROCEDURE sp_s_inventories()
BEGIN
	SELECT 
			a.inventory_invc_dtl_id_fk `inventory_id`,
            b.dtl_amount,
			c.item_name,
            a.inventory_stock,
            b.dtl_price_per_unit,
            c.item_minimun_amount,
            (c.item_cat+0)`item_cat`,
            (c.item_tp+0)`item_tp`,
            d.invc_buy_date
    FROM inventories AS a
    INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
    INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
    INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
    
    ORDER BY dtl_id;
    
END$$

/*---------------BUSCAR POR ITEM/CATEGORIA/TIPO----------------------------*/
DELIMITER $$
CREATE PROCEDURE sp_find_inventories(
	search_string varchar(50)
)
BEGIN
	SELECT 
			a.inventory_invc_dtl_id_fk `inventory_id`,
            b.dtl_amount,
			c.item_name,
            a.inventory_stock,
            b.dtl_price_per_unit,
            c.item_minimun_amount,
            (c.item_cat+0)`item_cat`,
            (c.item_tp+0)`item_tp`,
            d.invc_buy_date
    FROM inventories AS a
		INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
		INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
		INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
    WHERE
		  c.item_name LIKE concat('%',search_string,'%') OR
		  c.item_cat LIKE concat('%',search_string,'%') OR
		  c.item_tp LIKE concat('%',search_string,'%') 
    ORDER BY dtl_id;
END$$

/*---------------buscar los articulos bajo el limite establecido---------------------*/
DELIMITER $$
CREATE PROCEDURE sp_find_items_down_limit()
BEGIN
	SELECT 
			a.inventory_invc_dtl_id_fk `inventory_id`,
            b.dtl_amount,
			c.item_name,
            a.inventory_stock,
            b.dtl_price_per_unit,
            c.item_minimun_amount,
            (c.item_cat+0)`item_cat`,
            (c.item_tp+0)`item_tp`,
            d.invc_buy_date
    FROM inventories AS a
		INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
		INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
		INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
    WHERE
		a.inventory_stock <=  c.item_minimun_amount  
    ORDER BY dtl_id;
END$$


/*----------------------TRIGGERS------------*/

/*------------------INSERTAR---------------------------------------------------------------*/
DELIMITER $$
CREATE TRIGGER tg_i_inventories 
	AFTER INSERT 
	ON invoice_details
	FOR EACH ROW
BEGIN
	INSERT INTO inventories (
		`inventory_stock`, 
		`inventory_invc_dtl_id_fk`) 
	VALUES (
		NEW.dtl_amount, 
		NEW.dtl_id
	);

END$$

/*--------ACTULIZAR EXISTENCIAS ACTUALES SI LA CANTIDAD ORIGINAL DE COMPRA SE MODIFICA---*/
DELIMITER $$
CREATE TRIGGER tg_u_inventories 
	AFTER UPDATE 
	ON invoice_details
	FOR EACH ROW
BEGIN
		DECLARE _cantidad INT;
			/*Verificando si el nuevo  valor de las existencias es menor o mayor a actual*/
		IF (OLD.dtl_amount > NEW.dtl_amount)
			THEN SET _cantidad = - OLD.dtl_amount + NEW.dtl_amount;
		ELSEIF (OLD.dtl_amount < NEW.dtl_amount)
			THEN SET _cantidad =  - OLD.dtl_amount + NEW.dtl_amount;
		END IF;
			
		UPDATE inventories SET
			`inventory_stock` = `inventory_stock` + _cantidad, 
			`inventory_invc_dtl_id_fk`= NEW.dtl_id
		WHERE (`inventory_invc_dtl_id_fk`=NEW.dtl_id);
END$$

/*----------ACTUALIZAR LAS EXISTENCIAS CUANDO SE REGISTRE UNA ENTRADA/SALIDA*/
DELIMITER $$
CREATE TRIGGER tg_u_from_act_rgtr_inventories
	AFTER INSERT 
    ON activity_registers 
	FOR EACH ROW
BEGIN
	UPDATE inventories SET
		`inventory_stock`=`inventory_stock` + CAST(NEW.rgtr_amount AS DOUBLE)
	WHERE (NEW.rgtr_dtl_id_fk=`inventory_invc_dtl_id_fk`);
END$$

