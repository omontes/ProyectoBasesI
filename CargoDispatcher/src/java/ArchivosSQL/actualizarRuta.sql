UPDATE rutaenvio AS R
SET R.tiempo_dias=?,R.costo=?,R.nombre=?,R.maximocontenedor=?
WHERE R.`idRutaEnvio`=?;

