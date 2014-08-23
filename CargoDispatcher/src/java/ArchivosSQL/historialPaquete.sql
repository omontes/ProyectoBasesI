SELECT E.`Descripcion` AS estado,H.`Fecha` AS fecha
FROM historialpaquete AS H, estadospaquete AS E
WHERE H.`idEstado`=E.`idEstadosPaquete` AND H.`idPaquete`=?
GROUP BY H.`Fecha` ASC;
