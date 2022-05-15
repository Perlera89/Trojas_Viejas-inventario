USE trojas_viejas_db;
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
	FROM providers AS a;
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
    a.prov_tp LIKE concat('%',search_string,'%');
END$$
