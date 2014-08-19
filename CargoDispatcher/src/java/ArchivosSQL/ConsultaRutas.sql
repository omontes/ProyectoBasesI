SELECT R.`idRutaEnvio`,R.nombre,D.pto_llegada,D.pto_salida,R.tiempo_dias,R.costo,R.maximocontenedor
FROM rutaenvio AS R, direccionruta AS D;