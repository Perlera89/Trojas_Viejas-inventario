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
Delimiter $$
CREATE PROCEDURE sp_s_user(
	p_usr_name VARCHAR(50),
    p_usr_password VARCHAR(255)
)
BEGIN
	SELECT usr_id, usr_name, usr_password 
    FROM users 
    WHERE usr_name = p_usr_name AND usr_password = p_usr_password  LIMIT 1;
END$$
