use trojas_viejas_db;

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
		
