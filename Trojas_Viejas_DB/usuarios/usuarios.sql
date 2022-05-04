use inventories;

/*Insertar*/
Delimiter $$
CREATE PROCEDURE sp_i_users(
	p_usr_name VARCHAR(50),
    p_usr_password VARCHAR(50)
)
BEGIN
	INSERT INTO users (
		`usr_name`, 
        `usr_password`
        )
    VALUES (
		p_usr_name, 
        sha1(p_usr_password) 
        );
END
$$

/*Actualizar*/
Delimiter $$
CREATE PROCEDURE sp_u_users(
	p_usr_id INT,
	p_usr_name VARCHAR(50),
    p_usr_password VARCHAR(50)
)
BEGIN
	UPDATE users
    SET `usr_name` = p_usr_name, 
		`usr_password` = sha1(p_usr_password)
        WHERE (`usr_id` = p_usr_id);
END
$$

/*Eliminar*/
Delimiter $$
CREATE PROCEDURE sp_d_users(
	p_usr_id INT
)
BEGIN
	DELETE FROM users WHERE (`usr_id` = p_usr_id);
END$$

/*Mostrar*/
Delimiter $$
CREATE PROCEDURE sp_s_users()
BEGIN
	SELECT * FROM users;
END$$

/*Otros*/
/*Encontrar un articulo*/
Delimiter $$
CREATE PROCEDURE sp_find_users(
	p_usr_name VARCHAR(50),
    p_usr_password VARCHAR(50)
)
BEGIN
	SELECT * FROM users AS a
		WHERE a.usr_name = p_usr_name AND a.usr_password = sha1(p_usr_password);
end$$
