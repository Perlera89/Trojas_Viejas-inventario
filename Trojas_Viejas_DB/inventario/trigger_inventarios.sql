USE trojas_viejas_db;

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

/*DROP TRIGGER tg_u_from_act_rgtr_inventories;*/
