SELECT C.nombre,C.telefono,C.`idRutaEnvio`,C.puntos,T.`Descripcion` AS tipo, C.numero_cuenta
FROM cliente AS C, tipocliente AS T
WHERE C.tipo_cliente=T.`idTipoCliente`;