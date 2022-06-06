use trojas_viejas_db;

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
			WHERE YEAR(b.invc_buy_date) = p_year
            GROUP BY b.invc_id; 
		ELSEIF(p_month != 'NULL')
		THEN
			SELECT 
					COUNT(DISTINCT b.invc_id)`amount_purshases`,
					SUM(a.dtl_amount)`amount_items`,
					b.invc_total_amount`value`
			FROM invoice_details AS a
				INNER JOIN invoices AS b ON a.dtl_invc_id_fk = b.invc_id
			WHERE YEAR(b.invc_buy_date) = p_year AND MONTH(b.invc_buy_date) = CAST(p_month AS REAL)
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
			INNER JOIN invoices AS b ON a.dtl_invc_id_fk = b.invc_id;
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

    
    
    
