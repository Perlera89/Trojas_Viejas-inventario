USE inventories;
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

/*---------------------FILTRO POR YEAR------------------------*/
DELIMITER $$
	CREATE PROCEDURE sp_filter_by_year_activity_registers(
		p_years INT
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
		WHERE YEAR(a.rgtr_date) = p_years
		ORDER BY rgtr_id;
    END$$
    
    /*------------FILTRO POR YEAR Y MES---------------*/
DELIMITER $$
	CREATE PROCEDURE sp_filter_by_year_and_month_activity_registers(
		p_years INT,
        p_month VARCHAR(20)
    )
    BEGIN
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
    
