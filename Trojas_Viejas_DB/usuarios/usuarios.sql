use trojas_viejas_db;

/*Insertar*/
Delimiter $$
CREATE PROCEDURE sp_i_user(
	p_usr_name VARCHAR(45),
    p_usr_password VARCHAR(45),
    p_usr_verify_pass VARCHAR(45),
    p_usr_verify_code VARCHAR(45)
)
BEGIN

	INSERT INTO users(
    `usr_name`, 
    `usr_password`, 
    `usr_verify_pass`,
    `usr_verify_code`
    ) 
    VALUES(
    p_usr_name,
    sha1(p_usr_password),
    sha1(p_usr_verify_pass),
    p_usr_verify_code
    );
END
$$

/*Actualizar*/
Delimiter $$
CREATE PROCEDURE sp_u_user(
	p_usr_id int,
	p_usr_name VARCHAR(45),
    p_usr_password VARCHAR(45),
    p_usr_verify_pass VARCHAR(45)
)
BEGIN
	UPDATE users
    SET `usr_name` = p_usr_name, 
		`usr_password` = sha1(p_usr_password),
        `usr_verify_pass` = sha1(p_usr_password)
        WHERE `usr_id` = usr_id AND `usr_verify_pass` = sha1(p_usr_verify_pass);
END
$$

/*mostrar*/
Delimiter $$
CREATE PROCEDURE sp_s_users()
BEGIN
	SELECT * FROM users;
END$$

/*Otros*/
Delimiter $$
CREATE PROCEDURE sp_s_user(
	p_usr_name VARCHAR(45),
    usr_verify_pass VARCHAR(255)
)
BEGIN
	SELECT usr_id, usr_name, usr_password 
    FROM users 
    WHERE usr_name = p_usr_name AND usr_verify_pass = usr_verify_pass AND usr_status = 'Verified'  LIMIT 1;
END$$

Delimiter $$
CREATE PROCEDURE sp_s_check_duplicate_user(
	p_usr_name VARCHAR(45)
)
BEGIN
	SELECT usr_id FROM users WHERE usr_name=p_usr_name AND usr_status='Verified' LIMIT 1;
END$$

Delimiter $$
CREATE PROCEDURE sp_u_done_verify(
	p_usr_id INT
)
BEGIN
	UPDATE users SET usr_verify_pass='', usr_status='Verified' WHERE usr_id=p_usr_id LIMIT 1;
END$$

Delimiter $$
CREATE PROCEDURE sp_s_verify_code_user(
    p_usr_verify_code VARCHAR(45)
)
BEGIN
	SELECT usr_id 
    FROM users 
    WHERE usr_verify_code = p_usr_verify_code  LIMIT 1;
END$$
