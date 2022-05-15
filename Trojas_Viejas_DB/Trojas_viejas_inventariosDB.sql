
Delimiter $$
DROP DATABASE IF EXISTS trojas_viejas_db;
$$

Delimiter $$
CREATE DATABASE trojas_viejas_db;
$$

Delimiter $$
USE trojas_viejas_db;
$$


/*CREANDO LAS TABLAS*/
Delimiter $$

/*--------------------------ENTIDADES DEBILES-------------------------*/
/*Articulos*/
CREATE TABLE items(
	item_id INT NOT NULL AUTO_INCREMENT,
    item_name VARCHAR(50) NOT NULL,
    item_description VARCHAR(255),
    item_minimun_amount INT,
    item_cat ENUM('HERRAMIENTAS','ACCESORIOS'),
	item_tp ENUM('GENÉRICO','PVC','GALVANIZADO'),
    PRIMARY KEY(item_id)
);


/*proveedores*/
CREATE TABLE providers(
	prov_id INT NOT NULL AUTO_INCREMENT,
	prov_name VARCHAR(50) NOT NULL,
    prov_num_phone VARCHAR(20),
    prov_email VARCHAR(50),
    prov_direction VARCHAR(255) NOT NULL,
    prov_tp ENUM('COMERCIAL','DONANTE') NOT NULL,
    PRIMARY KEY(prov_id)
    
);

/*usuarios*/
CREATE TABLE users(
	usr_id INT NOT NULL AUTO_INCREMENT,
    usr_name VARCHAR(50) NOT NULL UNIQUE,
    usr_password VARCHAR(255) NOT NULL,
    usr_verify_pass VARCHAR(255) NOT NULL,
    PRIMARY KEY (usr_id)
);$$

Delimiter $$
/*------------------------- ENTIDADES DEBILES---------------------------- */


/*facturas*/
CREATE TABLE invoices(
	invc_id INT NOT NULL AUTO_INCREMENT,
    invc_total_amount DECIMAL(10,4) NOT NULL,
    invc_buy_date DATE NOT NULL,
    invc_picture LONGBLOB,
    invc_prov_id_fk INT NOT NULL,
    FOREIGN KEY (invc_prov_id_fk) REFERENCES providers(prov_id),
    PRIMARY KEY(invc_id)
);


/*Detalles de facturas*/
CREATE TABLE invoice_details(
	dtl_id INT NOT NULL AUTO_INCREMENT,
    dtl_amount INT NOT NULL,
    dtl_price_per_unit DECIMAL(10,4) NOT NULL,
    dtl_invc_id_fk INT NOT NULL,
    dtl_item_id_fk INT NOT NULL,
    FOREIGN KEY (dtl_invc_id_fk) REFERENCES invoices(invc_id)
    ON DELETE CASCADE,
    FOREIGN KEY (dtl_item_id_fk) REFERENCES items(item_id),
    PRIMARY KEY(dtl_id)
);


/*inventories*/
CREATE TABLE inventories(
    inventory_stock INT NOT NULL,
    inventory_invc_dtl_id_fk INT NOT NULL,
    FOREIGN KEY (inventory_invc_dtl_id_fk) REFERENCES invoice_details(dtl_id)
    ON DELETE CASCADE,
	PRIMARY KEY(inventory_invc_dtl_id_fk)
);


/*registro de actividades*/
CREATE TABLE activity_registers(
	rgtr_id INT NOT NULL AUTO_INCREMENT,
    rgtr_amount VARCHAR(10) NOT NULL,
    rgtr_current_stock INT,
    rgtr_description VARCHAR(255),
    rgtr_date DATE NOT NULL,
    rgtr_tp_action ENUM('ENTRADA','SALIDA') NOT NULL,
    rgtr_dtl_id_fk INT NOT NULL,
    FOREIGN KEY (rgtr_dtl_id_fk) REFERENCES inventories(inventory_invc_dtl_id_fk)
	ON DELETE CASCADE,
    PRIMARY KEY(rgtr_id)
);$$



