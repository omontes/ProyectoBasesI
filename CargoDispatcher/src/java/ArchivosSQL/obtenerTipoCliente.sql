SELECT C.tipo_cliente AS tipo
FROM cliente AS C,tipocliente AS T
WHERE C.tipo_cliente=T.`idTipoCliente` AND C.`idCliente`=?;

