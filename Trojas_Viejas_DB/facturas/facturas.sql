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
    ORDER BY invc_id; 
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
            ORDER BY invc_id;
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
			ORDER BY invc_id;
        END IF;
END$$
        
        
        
        
        
