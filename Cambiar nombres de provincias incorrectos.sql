/*INSERT INTO ruta (InvoiceNumber, DeptorNumber, cmp_name, Descripcion, AmountTC, Transaccion, Observacion, Estatus, DATE, Seccion, DueDate, Fecha)
SELECT InvoiceNumber, DeptorNumber, cmp_name, Descripcion, AmountTC, Transaccion, Observacion, Estatus, DATE, Seccion, DueDate, Fecha
FROM facturas WHERE InvoiceNumber = "1039302";*/

/*DELETE FROM ruta*/

/*CREATE USER 'gabrielmur'@'host' IDENTIFIED BY '';*/
/*GRANT SELECT, INSERT, UPDATE, DELETE ON RFIDDB.* TO 'gabrielmur'@'host';
FLUSH PRIVILEGES;
*/
INSERT INTO activos (rfid, producto, usuario, estado, hora_sali, hora_entra, permiso)
SELECT
    SUBSTRING(MD5(RAND()) FROM 1 FOR 8),
    FLOOR(RAND() * 139) + 1,
    FLOOR(RAND() * 52) + 1,
    IF(RAND() > 0.5, 1, 0),  -- Generar estado aleatorio: 0 o 1
    IF(RAND() > 0.5,
       FROM_UNIXTIME(UNIX_TIMESTAMP('2023-06-21 15:25:48') + FLOOR(RAND() * (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP('2023-06-21 15:25:48')))),
       FROM_UNIXTIME(UNIX_TIMESTAMP('2023-06-21 15:25:48') + FLOOR(RAND() * (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP('2023-06-21 15:25:48'))))),
    IF(RAND() > 0.5,
       FROM_UNIXTIME(UNIX_TIMESTAMP('2023-06-21 15:25:48') + FLOOR(RAND() * (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP('2023-06-21 15:25:48')))),
       FROM_UNIXTIME(UNIX_TIMESTAMP('2023-06-21 15:25:48') + FLOOR(RAND() * (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP('2023-06-21 15:25:48'))))),
    1