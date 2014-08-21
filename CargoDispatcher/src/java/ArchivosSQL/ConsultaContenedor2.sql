SELECT C.peso_actual, C.`idContenedor`, H.`Fecha`, D.pto_llegada
FROM contenedor as C
INNER JOIN rutaenvio as R ON C.`idRuta`=R.`idRutaEnvio`
INNER JOIN direccionruta as D ON R.`idRutaEnvio`=D.`idDireccionRuta`
INNER JOIN historialcontenedor as H ON C.`idContenedor`=H.`idContenedor` AND H.`idEstado`=1;
