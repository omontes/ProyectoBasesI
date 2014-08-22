SELECT C.idRutaEnvio
FROM Cliente AS C, Paquete AS P
WHERE C.idCliente=P.`idCliente` AND P.`idPaquete`='14';
