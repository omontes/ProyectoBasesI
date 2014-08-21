SELECT P.`idPaquete`, P.descripcion, E.`Descripcion` AS EstadoActual
FROM cliente AS C, paquete AS P, historialpaquete AS H, estadospaquete AS E
WHERE C.`idCliente`=P.`idCliente` AND H.`idPaquete`=P.`idPaquete` AND H.`idEstado`=E.`idEstadosPaquete` AND C.nombre=?
AND H.`Fecha` = (SELECT  MAX(historialpaquete.`Fecha`) FROM historialpaquete WHERE historialpaquete.`idPaquete`=H.`idPaquete`);


