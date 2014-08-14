SELECT P.`idPaquete`,P.descripcion
FROM cliente AS C, clientepaquete AS CP, paquete AS P
WHERE C.`idCliente`=CP.`idCliente` AND CP.`idPaquete`=P.`idPaquete`;
