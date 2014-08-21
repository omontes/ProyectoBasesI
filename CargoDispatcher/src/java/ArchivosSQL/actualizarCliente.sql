UPDATE cliente AS C
SET C.numero_cuenta=?,C.nombre=?,C.telefono=?,C.`idRutaEnvio`=?
WHERE C.`idCliente`=?;
