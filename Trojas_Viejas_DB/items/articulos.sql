USE trojas_viejas_db;

/*Insertar*/
Delimiter $$
CREATE PROCEDURE sp_i_items(
	p_item_name VARCHAR(50),
    p_item_description VARCHAR(255),
    p_item_minimun_amount INT,
    p_item_cat_index INT,
	p_item_tp_index INT
)
BEGIN
	INSERT INTO items (
		`item_name`, 
        `item_description`, 
        `item_minimun_amount`, 
        `item_cat`,
        `item_tp`
        )
    VALUES (
		p_item_name, 
        p_item_description, 
        p_item_minimun_amount, 
        p_item_cat_index,
        p_item_tp_index
        );
END
$$

/*Actualizar*/
Delimiter $$
CREATE PROCEDURE sp_u_items(
	p_item_id INT,
	p_item_name VARCHAR(50),
    p_item_description VARCHAR(255),
    p_item_minimun_amount INT,
    p_item_cat_index INT,
    p_item_tp_index INT
)
BEGIN
	UPDATE items
    SET `item_name` = p_item_name, 
		`item_description` = p_item_description, 
        `item_minimun_amount` = p_item_minimun_amount, 
        `item_cat` = p_item_cat_index,
        `item_tp` = p_item_tp_index 
        WHERE (`item_id` = p_item_id);
END$$

/*Eliminar*/
Delimiter $$
CREATE PROCEDURE sp_d_items(
	p_item_id int
)
BEGIN
	UPDATE items set item_state = 0 WHERE (`item_id` = p_item_id);
END$$

/*Mostrar*/
Delimiter $$
CREATE PROCEDURE sp_s_items()
BEGIN
	SELECT a.item_id,
			a.item_name,
            a.item_minimun_amount,
            a.item_description,
            (a.item_cat+0)`item_cat`,
            (a.item_tp+0)`item_tp` 
	FROM items AS a;
END$$

/*Otros*/
/*Encontrar un articulo*/
Delimiter $$
CREATE PROCEDURE sp_find_items(
	search_string VARCHAR (50),
    p_state INT
)
BEGIN
	IF(p_state = 0)
    THEN
		SELECT a.item_id,
				a.item_name,
				a.item_minimun_amount,
				a.item_description,
				(a.item_cat+0)'item_cat',
				(a.item_tp+0)'item_tp'
		FROM items AS a
		WHERE item_state = 0 AND
		(a.item_name LIKE concat('%',search_string,'%') OR
		a.item_cat LIKE concat('%',search_string,'%') OR 
		a.item_tp LIKE concat('%',search_string,'%')) ;    
    ELSEIF(p_state = 1)
    THEN
		SELECT a.item_id,
				a.item_name,
				a.item_minimun_amount,
				a.item_description,
				(a.item_cat+0)'item_cat',
				(a.item_tp+0)'item_tp'
		FROM items AS a
		WHERE item_state = 1 AND
		(a.item_name LIKE concat('%',search_string,'%') OR
		a.item_cat LIKE concat('%',search_string,'%') OR 
		a.item_tp LIKE concat('%',search_string,'%')) ;        
    END IF;

END$$


