SELECT DR.`idDireccionRuta` AS idRuta
FROM direccionruta AS DR
WHERE DR.pto_llegada=? AND DR.pto_salida=?;
