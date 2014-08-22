SELECT P.`idPaquete`,P.peso,P.descripcion,P.valor,P.`idCliente`,CT.descripcion AS categoria,E.`Descripcion` AS estadoActual
FROM cliente AS C, paquete AS P, historialpaquete AS H, estadospaquete AS E, categoriapaquetes AS CT
WHERE C.`idCliente`=P.`idCliente` AND H.`idPaquete`=P.`idPaquete` AND H.`idEstado`=E.`idEstadosPaquete`
AND P.`idCategoria`=CT.`idCategoriaPaquetes` AND H.`idEstado` NOT IN (1,3,4) 
AND H.`Fecha` = (SELECT  MAX(historialpaquete.`Fecha`) FROM historialpaquete WHERE historialpaquete.`idPaquete`=H.`idPaquete`)
ORDER BY P.`idPaquete` ASC;