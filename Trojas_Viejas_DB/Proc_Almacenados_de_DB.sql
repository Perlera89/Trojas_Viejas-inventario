USE trojas_viejas_db;

/*======================usuarios=================================================================================================================================

use trojas_viejas_db;

/*Insertar*/
Delimiter $$
CREATE PROCEDURE sp_i_user(
	p_usr_name VARCHAR(45),
    p_usr_password VARCHAR(45),
    p_usr_verify_pass VARCHAR(45),
    p_usr_verify_code VARCHAR(45)
)
BEGIN

	INSERT INTO users(
    `usr_name`, 
    `usr_password`, 
    `usr_verify_pass`,
    `usr_verify_code`
    ) 
    VALUES(
    p_usr_name,
    sha1(p_usr_password),
    sha1(p_usr_verify_pass),
    p_usr_verify_code
    );
END
$$

/*Actualizar*/
Delimiter $$
CREATE PROCEDURE sp_u_user(
	p_usr_id int,
	p_usr_name VARCHAR(45),
    p_usr_password VARCHAR(45),
    p_usr_verify_pass VARCHAR(45)
)
BEGIN
	UPDATE users
    SET `usr_name` = p_usr_name, 
		`usr_password` = sha1(p_usr_password),
        `usr_verify_pass` = sha1(p_usr_password)
        WHERE `usr_id` = usr_id AND `usr_verify_pass` = sha1(p_usr_verify_pass);
END
$$

/*mostrar*/
Delimiter $$
CREATE PROCEDURE sp_s_users()
BEGIN
	SELECT * FROM users;
END$$

/*Otros*/
Delimiter $$
CREATE PROCEDURE sp_s_user(
	p_usr_name VARCHAR(45),
    usr_verify_pass VARCHAR(255)
)
BEGIN
	SELECT usr_id, usr_name, usr_password 
    FROM users 
    WHERE usr_name = p_usr_name AND usr_verify_pass = usr_verify_pass AND usr_status = 'Verified'  LIMIT 1;
END$$

Delimiter $$
CREATE PROCEDURE sp_s_check_duplicate_user(
	p_usr_name VARCHAR(45)
)
BEGIN
	SELECT usr_id FROM users WHERE usr_name=p_usr_name AND usr_status='Verified' LIMIT 1;
END$$

Delimiter $$
CREATE PROCEDURE sp_u_done_verify(
	p_usr_id INT
)
BEGIN
	UPDATE users SET usr_verify_pass='', usr_status='Verified' WHERE usr_id=p_usr_id LIMIT 1;
END$$

Delimiter $$
CREATE PROCEDURE sp_s_verify_code_user(
    p_usr_verify_code VARCHAR(45)
)
BEGIN
	SELECT usr_id 
    FROM users 
    WHERE usr_verify_code = p_usr_verify_code  LIMIT 1;
END$$


/*==========================proveedores==============================================================================================================*/
/*
PROVEEDORES --------------------------------------------------------------------------------------------------
*/
/*Insertar*/
Delimiter $$
CREATE PROCEDURE sp_i_providers(
	p_prov_name VARCHAR(50),
    p_prov_num_phone VARCHAR(20),
    p_prov_email VARCHAR(50),
    p_prov_direction VARCHAR(255),
    p_prov_tp_index INT
)
BEGIN
	INSERT INTO providers (
		`prov_name`, 
        `prov_num_phone`, 
        `prov_email`, 
        `prov_direction`,
        `prov_tp`
        )
    VALUES (
		p_prov_name, 
        p_prov_num_phone, 
        p_prov_email, 
        p_prov_direction,
        p_prov_tp_index
        );
END $$

/*Actualizar*/
Delimiter $$
CREATE PROCEDURE sp_u_providers(
	p_prov_id INT,
	p_prov_name VARCHAR(50),
    p_prov_num_phone VARCHAR(20),
    p_prov_email VARCHAR(50),
    p_prov_direction VARCHAR(255),
	p_prov_tp_index INT
)
BEGIN
	UPDATE providers
    SET `prov_name` = p_prov_name, 
		`prov_num_phone` = p_prov_num_phone, 
        `prov_email` = p_prov_email, 
        `prov_direction` = p_prov_direction,
        `prov_tp` = p_prov_tp_index
        WHERE (`prov_id` = p_prov_id);
END
$$

/*Eliminar*/
Delimiter $$
CREATE PROCEDURE sp_d_providers(
	p_prov_id INT
)
BEGIN
	DELETE FROM providers WHERE (`prov_id` = p_prov_id);
END$$

/*Mostrar*/
Delimiter $$
CREATE PROCEDURE sp_s_providers()
BEGIN
	SELECT a.prov_id, 
			a.prov_name, 
            a.prov_num_phone, 
            a.prov_email, 
            a.prov_direction, 
            (a.prov_tp+0)`prov_tp`
	FROM providers AS a
	ORDER BY prov_id;
END$$

/*Otros*/
/*Encontrar un proveedor*/
Delimiter $$
CREATE PROCEDURE sp_find_providers(
	search_string VARCHAR (50)
)
BEGIN
	SELECT a.prov_id,
			a.prov_name,
            a.prov_num_phone,
			a.prov_email,
            a.prov_direction,
            (a.prov_tp+0)`prov_tp`
	FROM providers AS a
    WHERE 
    a.prov_name LIKE concat('%',search_string,'%') OR
    a.prov_tp LIKE concat('%',search_string,'%')
    ORDER BY prov_id;
END$$

/*=========================items==========================================================================================================================*/

/*Insertar*/
Delimiter $$
CREATE PROCEDURE sp_i_items(
	p_item_name VARCHAR(50),
    p_item_description VARCHAR(255),
    p_item_minimun_amount INT,
    p_item_cat_index INT,
	p_item_tp_index INT
)
BEGIN
	INSERT INTO items (
		`item_name`, 
        `item_description`, 
        `item_minimun_amount`, 
        `item_cat`,
        `item_tp`
        )
    VALUES (
		p_item_name, 
        p_item_description, 
        p_item_minimun_amount, 
        p_item_cat_index,
        p_item_tp_index
        );
END
$$

/*Actualizar*/
Delimiter $$
CREATE PROCEDURE sp_u_items(
	p_item_id INT,
	p_item_name VARCHAR(50),
    p_item_description VARCHAR(255),
    p_item_minimun_amount INT,
    p_item_cat_index INT,
    p_item_tp_index INT
)
BEGIN
	UPDATE items
    SET `item_name` = p_item_name, 
		`item_description` = p_item_description, 
        `item_minimun_amount` = p_item_minimun_amount, 
        `item_cat` = p_item_cat_index,
        `item_tp` = p_item_tp_index 
        WHERE (`item_id` = p_item_id);
END$$

/*Eliminar*/
Delimiter $$
CREATE PROCEDURE sp_d_items(
	 p_item_id INT
)
BEGIN
	DELETE FROM items WHERE (`item_id` = p_item_id);
END$$

/*Mostrar*/
Delimiter $$
CREATE PROCEDURE sp_s_items()
BEGIN
	SELECT a.item_id,
			a.item_name,
            a.item_minimun_amount,
            a.item_description,
            (a.item_cat+0)`item_cat`,
            (a.item_tp+0)`item_tp` 
	FROM items AS a;
END$$

/*Otros*/
/*Encontrar un articulo*/
Delimiter $$
CREATE PROCEDURE sp_find_items(
	search_string VARCHAR (50)
)
BEGIN
	SELECT a.item_id,
			a.item_name,
            a.item_minimun_amount,
            a.item_description,
            (a.item_cat+0)'item_cat',
            (a.item_tp+0)'item_tp'
	FROM items AS a
    WHERE 
    a.item_name LIKE concat('%',search_string,'%') OR
    a.item_cat LIKE concat('%',search_string,'%') OR 
    a.item_tp LIKE concat('%',search_string,'%') ;
END$$


/*====================================facturas======================================================================*/

/*
FACTURAS------------------------------------------------------------------------------------------------------
*/
/*Insertar*/
Delimiter $$
CREATE PROCEDURE sp_i_invoices(
	p_invc_total_amount DECIMAL(10,4),
    p_invc_buy_date DATE,
    p_invc_picture LONGBLOB,
    p_invc_prov_id_fk INT
)
BEGIN
	INSERT INTO invoices(
		`invc_total_amount`,
		`invc_buy_date`,
		`invc_picture`,
		`invc_prov_id_fk`
        )
	VALUES(
		p_invc_total_amount,
		p_invc_buy_date,
		p_invc_picture,
		p_invc_prov_id_fk
    );
END$$

/*Actualizar*/
Delimiter $$
CREATE PROCEDURE sp_u_invoices(
	p_invc_id INT,
	P_invc_total_amount DECIMAL(10,4),
    P_invc_buy_date DATE,
    p_invc_picture LONGBLOB,
    p_invc_prov_id_fk INT
)
BEGIN
	UPDATE invoices
    SET
		`invc_total_amount` = p_invc_total_amount,
		`invc_buy_date` = p_invc_buy_date,
		`invc_picture` = p_invc_picture,
		`invc_prov_id_fk` = p_invc_prov_id_fk
        WHERE(`invc_id` = p_invc_id);
END$$

/*Eliminar*/
Delimiter $$
CREATE PROCEDURE sp_d_invoices(
	p_invc_id INT
)
BEGIN
	DELETE FROM invoices
	WHERE(`invc_id` = p_invc_id);
END$$

/*Mostrar*/
Delimiter $$
CREATE PROCEDURE sp_s_invoices()
BEGIN
	SELECT 
			DISTINCT d.invc_id,
            e.prov_name,
            d.invc_total_amount,
            d.invc_buy_date,
            d.invc_picture,
            SUM(b.dtl_amount)`dtl_amount`,
            SUM(a.inventory_stock)`inventory_stock`
    FROM inventories AS a
    INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
    INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
    INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
    INNER JOIN providers AS e ON d.invc_prov_id_fk = e.prov_id
    
    GROUP BY invc_id
    ORDER BY invc_id DESC;
END$$

/*Otros*/

/*Filtar las facturas por year y mes y año*/
Delimiter $$
CREATE PROCEDURE sp_filter_invoices(
	p_month VARCHAR(20),
    years INT
)
BEGIN
		IF(p_month = 'NULL')
		THEN
			SET lc_time_names = 'es_SV';
			SELECT 
					DISTINCT d.invc_id,
					e.prov_name,
					d.invc_total_amount,
					d.invc_buy_date,
					d.invc_picture,
					SUM(b.dtl_amount)`dtl_amount`,
					SUM(a.inventory_stock)`inventory_stock`
			FROM inventories AS a
				INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
				INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
				INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
				INNER JOIN providers AS e ON d.invc_prov_id_fk = e.prov_id
			WHERE 
			YEAR(d.invc_buy_date) = years
            GROUP BY invc_id
            ORDER BY invc_id DESC;
		ELSEIF(p_month != 'NULL')
		THEN
			SET lc_time_names = 'es_SV';
			SELECT 
					DISTINCT d.invc_id,
					e.prov_name,
					d.invc_total_amount,
					d.invc_buy_date,
					d.invc_picture,
					SUM(b.dtl_amount)`dtl_amount`,
					SUM(a.inventory_stock)`inventory_stock`
			FROM inventories AS a
				INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
				INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
				INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
				INNER JOIN providers AS e ON d.invc_prov_id_fk = e.prov_id
			WHERE 
			YEAR(d.invc_buy_date) = years AND monthname(d.invc_buy_date) = p_month
            GROUP BY invc_id
			ORDER BY invc_id DESC;
        END IF;
END$$
        


/*===========================detalles de facturas=================================================================*/


/*CRUD*/
/*GUARDAR*/
DELIMITER $$
CREATE PROCEDURE sp_i_invoice_details(
	p_dtl_amount INT,
    p_dtl_price_per_unit DECIMAL(10,4),
    p_dtl_item_id_fk INT,
    p_dtl_invc_id_fk INT
)
BEGIN
	INSERT INTO invoice_details(
		`dtl_amount`,
        `dtl_price_per_unit`,
        `dtl_item_id_fk`,
		`dtl_invc_id_fk`) 
	VALUES (
		p_dtl_amount,
        p_dtl_price_per_unit,
        p_dtl_item_id_fk,
        p_dtl_invc_id_fk);
END$$


/*ACTUALIZAR*/
DELIMITER $$
CREATE PROCEDURE sp_u_invoice_details(
	p_dtl_id INT,
	p_dtl_amount INT,
    p_dtl_price_per_unit DECIMAL(10,4),
    p_dtl_item_id_fk INT,
    p_dtl_invc_id_fk INT
)
BEGIN
	UPDATE invoice_details SET
		`dtl_amount` = p_dtl_amount,
        `dtl_price_per_unit` = p_dtl_price_per_unit,
        `dtl_invc_id_fk` = p_dtl_invc_id_fk,
        `dtl_item_id_fk` = p_dtl_item_id_fk 
	WHERE (`dtl_id`= p_dtl_id);
END$$


/*ELIMINAR*/
DELIMITER $$
CREATE PROCEDURE sp_d_invoice_details(
	p_dtl_id INT
)
BEGIN
	DELETE FROM invoice_details
	WHERE (`dtl_id`= p_dtl_id);
END$$


/*MOSTRAR*/
DELIMITER $$
CREATE PROCEDURE sp_s_invoice_details(
	p_dtl_id INT
)
BEGIN
	SELECT a.dtl_id,
			a.dtl_amount,
			c.item_name,
			a.dtl_price_per_unit,
			(a.dtl_amount*a.dtl_price_per_unit)`dtl_subtotaL`,
			a.dtl_invc_id_fk
	 FROM invoice_details AS a
			INNER JOIN invoices AS b ON a.dtl_invc_id_fk = b.invc_id
			INNER JOIN items AS c ON a.dtl_item_id_fk = c.item_id
			
			WHERE a.dtl_invc_id_fk = p_dtl_id;
END$$

/*==================================inventario================================================*/


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

/*====================================registros de actividad==============================================*/

/*-------------------GUARDAR----------------------------------*/
DELIMITER $$
CREATE PROCEDURE sp_i_activity_registers(
	p_rgtr_tp_action_index INT,
    p_rgtr_current_stock INT,
    p_rgtr_amount VARCHAR(10),
    p_rgtr_description VARCHAR(255),
    p_rgtr_dtl_id_fk INT
)
BEGIN
	INSERT INTO activity_registers(
		`rgtr_amount`,
        `rgtr_current_stock`,
        `rgtr_description`,
        `rgtr_date`,
        `rgtr_tp_action`,
        `rgtr_dtl_id_fk`)
	VALUES(
		p_rgtr_amount,
        p_rgtr_current_stock,
        p_rgtr_description,
        CAST(NOW() AS date),
        p_rgtr_tp_action_index,
        p_rgtr_dtl_id_fk
    );
END$$

/*-------------------ACTUALIZAR----------------------------------*/
DELIMITER $$
CREATE PROCEDURE sp_u_activity_registers(
	p_rgtr_id INT,
    p_rgtr_description VARCHAR(255)
)
BEGIN
	UPDATE activity_registers
		SET
        `rgtr_description` = p_rgtr_description
        WHERE(rgtr_id = p_rgtr_id);
END$$

/*-----------------------MOSTRAR-----------------------------*/
DELIMITER $$
	CREATE PROCEDURE sp_s_activity_registers()
    BEGIN
		SELECT
			a.rgtr_id,
            (a.rgtr_tp_action +0)`rgtr_tp_action`,
            d.item_name,
            /*c.dtl_amount,*/
            a.rgtr_current_stock,
            a.rgtr_amount,
            (a.rgtr_current_stock + a.rgtr_amount)`rgtr_new_stock`,
            a.rgtr_description,
            c.dtl_price_per_unit,
            (d.item_cat+0)`item_cat`,
            (d.item_tp+0)`item_tp`,
            e.invc_buy_date,
            a.rgtr_date
            
        FROM activity_registers AS a
			INNER JOIN inventories AS b ON a.rgtr_dtl_id_fk = b.inventory_invc_dtl_id_fk
            INNER JOIN invoice_details AS c ON b.inventory_invc_dtl_id_fk = c.dtl_id
            INNER JOIN items AS d ON c.dtl_item_id_fk = d.item_id
			INNER JOIN invoices AS e ON c.dtl_invc_id_fk = e.invc_id 
		ORDER BY rgtr_id;
    END$$

    
    /*------------FILTRO POR YEAR Y MES---------------*/
DELIMITER $$
	CREATE PROCEDURE sp_filter_by_activity_registers(
	    p_month VARCHAR(20),
        p_years INT
    )
    BEGIN
/*--------------------------YEAR----------------------------------*/
        IF((p_month = 'NULL'))
        THEN
		SET lc_time_names = 'es_SV';
		SELECT
			a.rgtr_id,
			(a.rgtr_tp_action +0)`rgtr_tp_action`,
            d.item_name,
            /*c.dtl_amount,*/
            a.rgtr_current_stock,
            a.rgtr_amount,
            (a.rgtr_current_stock + a.rgtr_amount)`rgtr_new_stock`,
            a.rgtr_description,
            c.dtl_price_per_unit,
            (d.item_cat+0)`item_cat`,
            (d.item_tp+0)`item_tp`,
            e.invc_buy_date,
            a.rgtr_date
            
        FROM activity_registers AS a
			INNER JOIN inventories AS b ON a.rgtr_dtl_id_fk = b.inventory_invc_dtl_id_fk
            INNER JOIN invoice_details AS c ON b.inventory_invc_dtl_id_fk = c.dtl_id
            INNER JOIN items AS d ON c.dtl_item_id_fk = d.item_id
			INNER JOIN invoices AS e ON c.dtl_invc_id_fk = e.invc_id 
		WHERE YEAR(a.rgtr_date) = p_years 
		ORDER BY rgtr_id;

/*----------------YEAR AND MONTH----------------------------------------------------------------*/
        ELSEIF(p_month!='NULL')
        THEN
		SET lc_time_names = 'es_SV';
		SELECT
			a.rgtr_id,
			(a.rgtr_tp_action +0)`rgtr_tp_action`,
            d.item_name,
            /*c.dtl_amount,*/
            a.rgtr_current_stock,
            a.rgtr_amount,
            (a.rgtr_current_stock + a.rgtr_amount)`rgtr_new_stock`,
            a.rgtr_description,
            c.dtl_price_per_unit,
            (d.item_cat+0)`item_cat`,
            (d.item_tp+0)`item_tp`,
            e.invc_buy_date,
            a.rgtr_date
            
        FROM activity_registers AS a
			INNER JOIN inventories AS b ON a.rgtr_dtl_id_fk = b.inventory_invc_dtl_id_fk
            INNER JOIN invoice_details AS c ON b.inventory_invc_dtl_id_fk = c.dtl_id
            INNER JOIN items AS d ON c.dtl_item_id_fk = d.item_id
			INNER JOIN invoices AS e ON c.dtl_invc_id_fk = e.invc_id 
		WHERE YEAR(a.rgtr_date) = p_years AND MONTHNAME(a.rgtr_date) = p_month
		ORDER BY rgtr_id;
        END IF;
    END$$
    
   /*------------FILTRO POR FACTURA---------------*/
DELIMITER $$
	CREATE PROCEDURE sp_filter_by_invoices_activity_registers(
		p_invoices_id INT
    )
    BEGIN
		SELECT
			a.rgtr_id,
			(a.rgtr_tp_action +0)`rgtr_tp_action`,
            d.item_name,
            /*c.dtl_amount,*/
            a.rgtr_current_stock,
            a.rgtr_amount,
            (a.rgtr_current_stock + a.rgtr_amount)`rgtr_new_stock`,
            a.rgtr_description,
            c.dtl_price_per_unit,
            (d.item_cat+0)`item_cat`,
            (d.item_tp+0)`item_tp`,
            e.invc_buy_date,
            a.rgtr_date
            
        FROM activity_registers AS a
			INNER JOIN inventories AS b ON a.rgtr_dtl_id_fk = b.inventory_invc_dtl_id_fk
            INNER JOIN invoice_details AS c ON b.inventory_invc_dtl_id_fk = c.dtl_id
            INNER JOIN items AS d ON c.dtl_item_id_fk = d.item_id
			INNER JOIN invoices AS e ON c.dtl_invc_id_fk = e.invc_id 
		WHERE c.dtl_invc_id_fk = p_invoices_id
		ORDER BY rgtr_id;
    END$$
    
    /*===================dashboard===========================*/
    DELIMITER $$
	CREATE PROCEDURE sp_report_purchases(
		p_month VARCHAR(20),
		p_year INT
    )
BEGIN
		IF(p_month = 'NULL')
		THEN
			SELECT 
					COUNT(DISTINCT b.invc_id)`amount_purshases`,
					SUM(a.dtl_amount)`amount_items`,
					b.invc_total_amount`value`
			FROM invoice_details AS a
				INNER JOIN invoices AS b ON a.dtl_invc_id_fk = b.invc_id
                INNER JOIN providers AS c ON b.invc_prov_id_fk = c.prov_id
			WHERE YEAR(b.invc_buy_date) = p_year 
				AND (c.prov_tp+0) = 1
            GROUP BY b.invc_id; 
		ELSEIF(p_month != 'NULL')
		THEN
			SELECT 
					COUNT(DISTINCT b.invc_id)`amount_purshases`,
					SUM(a.dtl_amount)`amount_items`,
					b.invc_total_amount`value`
			FROM invoice_details AS a
				INNER JOIN invoices AS b ON a.dtl_invc_id_fk = b.invc_id
                INNER JOIN providers AS c ON b.invc_prov_id_fk = c.prov_id
			WHERE YEAR(b.invc_buy_date) = p_year 
				AND MONTH(b.invc_buy_date) = CAST(p_month AS REAL)
                AND (c.prov_tp+0) = 1
            GROUP BY b.invc_id; 
		END IF;
END$$


/*años en los que hay facturas*/
    
    DELIMITER $$
	CREATE PROCEDURE sp_years_in_invoices(
    )
    BEGIN
		SELECT 
			DISTINCT YEAR(b.invc_buy_date)`years_with_invoices`
		FROM invoice_details AS a
			INNER JOIN invoices AS b ON a.dtl_invc_id_fk = b.invc_id
            INNER JOIN providers AS c ON b.invc_prov_id_fk = c.prov_id
            WHERE (c.prov_tp+0) = 1;
    END$$
    
    
/*reporte de las entradas y salidas para los graficas*/
        DELIMITER $$
	CREATE PROCEDURE sp_report_registers_by_month(
		p_month int,
        p_year int,
        p_action enum('ENTRADA','SALIDA')
    )
BEGIN
		SELECT
            DISTINCT a.rgtr_tp_action`tp_action`,
            COUNT(a.rgtr_tp_action)`amount_action`,
            ABS(SUM(a.rgtr_amount))`amount`
        FROM activity_registers AS a
			WHERE 
				(YEAR(a.rgtr_date) = p_year AND MONTH(a.rgtr_date) = p_month)
                AND a.rgtr_tp_action = p_action
		GROUP BY tp_action;
    END$$
