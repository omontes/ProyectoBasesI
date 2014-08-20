SELECT R.`idRutaEnvio`,R.nombre,D.pto_llegada,D.pto_salida,R.tiempo_dias AS tiempo,R.costo,R.maximocontenedor
FROM rutaenvio AS R, direccionruta AS D
WHERE R.direccion_ruta=D.`idDireccionRuta`;