SELECT P.`idPaquete`, P.descripcion, E.`Descripcion` AS EstadoActual
FROM cliente AS C, clientepaquete AS CP, paquete AS P, historialpaquete AS H, estadospaquete AS E
WHERE C.`idCliente`=CP.`idCliente` AND CP.`idPaquete`=P.`idPaquete` AND H.`idPaquete`=P.`idPaquete` AND H.`idEstado`=E.`idEstadosPaquete` 
AND H.`Fecha` = (SELECT  MAX(historialpaquete.`Fecha`) FROM historialpaquete WHERE H.`idPaquete`=P.`idPaquete`);