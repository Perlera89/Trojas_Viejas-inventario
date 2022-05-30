use trojas_viejas_db;

/*Tipo de proveedores*/

/*Proveedores*/
call sp_i_providers('Agroferreteria El Halcon', '7412-8956', 'afeh@gmail.com', 'Chalatenango', 1);
call sp_i_providers('Ferreteria San Antonio', '7569-7845', 'afsa@gmail.com', 'Chalatenango', 1);
call sp_i_providers('Mini Super Gabriela', '7569-8956', 'ms@gmail.com', 'Ojos de Agua', 1);
call sp_i_providers('Super El Baratillo', '4123-8956', 'seb@gmail.com', 'Chalatenango', 1);
call sp_i_providers('FONAVIPO', '7569-8956', 'f@gmail.com', 'San Salvador', 2);
call sp_i_providers('Mini Super Gabriela', '7569-8956', 'ms@gmail.com', 'Ojos de Agua', 1);
call sp_i_providers('Mini Super Gabriela', '7569-8956', 'ms@gmail.com', 'Ojos de Agua', 1);
call sp_i_providers('Mini Super Gabriela', '7569-8956', 'ms@gmail.com', 'Ojos de Agua', 1);
call sp_i_providers('Mini Super Gabriela', '7569-8956', 'ms@gmail.com', 'Ojos de Agua', 1);


/*articulos*/
call sp_i_items('Camisa lisa 1 1/2', 'Sin descripcion', 10, 2,2);
call sp_i_items('Camisa lisa 1/2', 'Sin descripcion', 20, 2,3);
call sp_i_items('Tuvo 1 1/2', 'Sin descripcion', 10, 2,3);
call sp_i_items('Camisa lisa 1 1/2', 'Sin descripcion', 20, 2,2);
call sp_i_items('Codo 1/2', 'Sin descripcion', 20, 2,2);
call sp_i_items('Tubo 1/2', 'Sin descripcion', 10, 2,3);
call sp_i_items('Pala', 'Sin descripcion', 10, 1,1);

/*usuarios*/
call sp_i_users('Sonia', '47589');
call sp_i_users('Kemberly', '1245');
call sp_i_users('Carlos', '7581');
call sp_i_users('Manu', '3333');

/*facturas*/
call sp_i_invoices(58.36, '2022-02-24', '', 1);
call sp_i_invoices(45, '2022-05-25', '', 4);
call sp_i_invoices(10.56, '2022-07-25', '', 6);
call sp_i_invoices(15.68, '2022-08-25', '', 8);
call sp_i_invoices(78.4, '2022-09-25', '', 2);
call sp_i_invoices(58.96, '2022-12-25', '', 5);

/*detalles de facturas*/
call sp_i_invoice_details(20, 0.8, 4, 2);
call sp_i_invoice_details(10, 0.35, 6, 2);
call sp_i_invoice_details(20, 1, 5, 2);
call sp_i_invoice_details(7, 0.75, 3, 1);
call sp_i_invoice_details(13, 1.75, 5, 1);
call sp_i_invoice_details(32, 0.8, 4, 3);
call sp_i_invoice_details(24, 1, 1, 1);

/*registros de entrada/salida*/
call sp_i_activity_registers(2, 20, '-13', 'Reparar tuberias rotas en la comunidad el Jicaro', 1);
call sp_i_activity_registers(2, 7, '-7', 'Reparar tuberias rotas en la comunidad las lomas', 1);
call sp_i_activity_registers(2, 32, '-16', 'Reparar tuberias', 6);
call sp_i_activity_registers(2, 10, '-5', 'Reparar tuberias rotas en la comunidad el las minas', 2);
call sp_i_activity_registers(2, 16, '-13', 'Reparar tuberias rotas en la comunidad el Jicaro', 6);
call sp_i_activity_registers(2, 20, '-9', 'Reparar tuberias', 3);
call sp_i_activity_registers(1, 5, '+5', 'Reparar tuberias rotas en la comunidad las lomas', 2);
call sp_i_activity_registers(2, 13, '-13', 'Reparar tuberias rotas', 5);
call sp_i_activity_registers(1, 3, '+5', 'Reparar tuberias rotas en la comunidad las minas', 6);
