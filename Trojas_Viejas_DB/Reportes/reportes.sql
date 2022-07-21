use trojas_viejas_db;

DELIMITER $$
CREATE PROCEDURE sp_r_inventories()
BEGIN
	SELECT #indice
			b.dtl_amount`No.`,
            b.dtl_amount`Comprado`,#Comprado
			c.item_name`Artículo`,#Nombre
            a.inventory_stock`Existencias`,#Existencias
            b.dtl_price_per_unit `C/U`,#C/U
            c.item_cat`Categoría`,#Categoría
            c.item_tp`Tipo`,#Tipo
            d.invc_buy_date`Fecha de compra`#Fecha de compra
    FROM inventories AS a
    INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
    INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
    INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
    WHERE (a.inventory_stock != 0)
    ORDER BY dtl_id;
END
$$

DELIMITER $$
CREATE PROCEDURE sp_r_items()
BEGIN
	SELECT	#indice
			a.item_name, #Artículo
            a.item_cat, #Categoría
            a.item_tp #Tipo
	FROM items AS a
    ORDER BY item_id;
END$$

DELIMITER $$
CREATE PROCEDURE sp_r_invoices(
    years INT
)
	BEGIN
		SELECT DISTINCT
		d.invc_id, #indice
		e.prov_name, #Proveedor
		SUM(b.dtl_amount) `dtl_amount`, #Artículos
		CONCAT('$',d.invc_total_amount), #Total
		d.invc_buy_date #Fecha de compra

	FROM
		inventories AS a 
		INNER JOIN invoice_details AS b ON a.inventory_invc_dtl_id_fk = b.dtl_id
		INNER JOIN items AS c ON b.dtl_item_id_fk = c.item_id
		INNER JOIN invoices AS d ON b.dtl_invc_id_fk = d.invc_id
		INNER JOIN providers AS e ON d.invc_prov_id_fk = e.prov_id
	WHERE
		YEAR(d.invc_buy_date) = years
	GROUP BY invc_id
	ORDER BY invc_id;
END$$


DELIMITER $$
CREATE PROCEDURE sp_r_activityRegisters(
	    p_month VARCHAR(20),
        p_years INT
    )
BEGIN
/*--------------------------YEAR----------------------------------*/
        IF((p_month = 'NULL'))
        THEN
		SET lc_time_names = 'es_SV';
		SELECT
			#indice
			a.rgtr_tp_action, #Acción
            d.item_name, #Artículo
            a.rgtr_current_stock, #Existencias
            a.rgtr_amount, #Retiro
            (a.rgtr_current_stock + a.rgtr_amount)`rgtr_new_stock`, #En Inventario
            a.rgtr_description, #Descripción
            CONCAT('$',c.dtl_price_per_unit)`dtl_price_per_unit`, #C/U
            d.item_cat, #Categoría
            d.item_tp, #Tipo
            e.invc_buy_date, #Fecha de compra
            a.rgtr_date #Fecha
            
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
			#indice
			a.rgtr_tp_action, #Acción
            d.item_name, #Artículo
            a.rgtr_current_stock, #Existencias
            a.rgtr_amount, #Retiro
            (a.rgtr_current_stock + a.rgtr_amount)`rgtr_new_stock`, #En Inventario
            a.rgtr_description, #Descripción
            CONCAT('$',c.dtl_price_per_unit)`dtl_price_per_unit`, #C/U
            d.item_cat, #Categoría
            d.item_tp, #Tipo
            e.invc_buy_date, #Fecha de compra
            a.rgtr_date #Fecha
            
        FROM activity_registers AS a
			INNER JOIN inventories AS b ON a.rgtr_dtl_id_fk = b.inventory_invc_dtl_id_fk
            INNER JOIN invoice_details AS c ON b.inventory_invc_dtl_id_fk = c.dtl_id
            INNER JOIN items AS d ON c.dtl_item_id_fk = d.item_id
			INNER JOIN invoices AS e ON c.dtl_invc_id_fk = e.invc_id 
		WHERE YEAR(a.rgtr_date) = p_years AND MONTHNAME(a.rgtr_date) = p_month
		ORDER BY rgtr_id;
        END IF;
    END
$$

DELIMITER $$
CREATE PROCEDURE sp_r_invoice_by_id(
        p_id_invoice INT
    )
BEGIN
		SET lc_time_names = 'es_SV';
		SELECT
			#indice
			a.rgtr_tp_action, #Acción
            d.item_name, #Artículo
            f.prov_name,
            CONCAT('$',e.invc_total_amount)`invc_total_amount`,
            a.rgtr_current_stock, #Existencias
            a.rgtr_amount, #Retiro
            (a.rgtr_current_stock + a.rgtr_amount)`rgtr_new_stock`, #En Inventario
            a.rgtr_description, #Descripción
            CONCAT('$',c.dtl_price_per_unit)`dtl_price_per_unit`, #C/U
            d.item_cat, #Categoría
            d.item_tp, #Tipo
            e.invc_buy_date, #Fecha de compra
            a.rgtr_date #Fecha
            
        FROM activity_registers AS a
			INNER JOIN inventories AS b ON a.rgtr_dtl_id_fk = b.inventory_invc_dtl_id_fk
            INNER JOIN invoice_details AS c ON b.inventory_invc_dtl_id_fk = c.dtl_id
            INNER JOIN items AS d ON c.dtl_item_id_fk = d.item_id
			INNER JOIN invoices AS e ON c.dtl_invc_id_fk = e.invc_id 
            INNER JOIN providers AS f ON e.invc_prov_id_fk = f.prov_id
		WHERE e.invc_id = p_id_invoice
		ORDER BY rgtr_id;
    END
$$

DELIMITER $$
CREATE PROCEDURE sp_r_invoice_image(
	p_idInvoice INT
)
BEGIN
SELECT a.invc_picture FROM invoices AS a WHERE invc_id = p_idInvoice;
END$$



