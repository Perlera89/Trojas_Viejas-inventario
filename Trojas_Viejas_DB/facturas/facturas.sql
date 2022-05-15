use trojas_viejas_db;

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
	SELECT a.invc_id, b.prov_name, a.invc_total_amount, a.invc_buy_date, a.invc_picture FROM invoices AS a
    INNER JOIN providers AS b ON a.invc_prov_id_fk = b.prov_id; 
END$$

/*Otros*/
/*Filtar las facturas por año*/
Delimiter $$
CREATE PROCEDURE sp_filter_by_year_invoices(
	search_string INT
)
BEGIN
	SELECT a.invc_id, b.prov_name, a.invc_total_amount, a.invc_buy_date, a.invc_picture FROM invoices AS a
		INNER JOIN providers AS b ON a.invc_prov_id_fk = b.prov_id
    WHERE 
    YEAR(a.invc_buy_date) = search_string;
END$$

/*Filtar las facturas por año*/
Delimiter $$
CREATE PROCEDURE sp_find_months_in_year_invoices(
	search_string INT
)
BEGIN
	SET lc_time_names = 'es_SV';
	SELECT DISTINCT monthname(a.invc_buy_date), MONTH(a.invc_buy_date) FROM invoices AS a
    WHERE YEAR(a.invc_buy_date) = search_string
    ORDER BY MONTH(a.invc_buy_date);
END$$

/*Filtar las facturas por mes y año*/
Delimiter $$
CREATE PROCEDURE sp_filter_by_year_and_month_invoices(
	years INT,
    months VARCHAR(20)
)
BEGIN
	SET lc_time_names = 'es_SV';
	SELECT a.invc_id, b.prov_name, a.invc_total_amount, a.invc_buy_date, a.invc_picture FROM invoices AS a
		INNER JOIN providers AS b ON a.invc_prov_id_fk = b.prov_id
    WHERE 
    YEAR(a.invc_buy_date) = years AND monthname(a.invc_buy_date) = months;
END$$

