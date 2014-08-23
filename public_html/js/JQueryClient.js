// The root URL for the RESTful services
var rootURL = "http://localhost:8080/CargoDispatcher/webresources/";
//var rootURL = "http://192.168.2.6:8080/CargoDispatcher/webresources/";




// GET todos los clientes
function getClientes() {
    console.log('getClientes');
    $.ajax({
        type: 'GET',
        url: rootURL + "cliente/getClientes",
        dataType: "json",
        success: function(data) {
            renderClientes(data);
        }
    });
}

// POST un cliente
function postCliente() {
    console.log('postCliente');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "cliente",
        dataType: "json",
        data: clienteToJSON(),
        success: function() {
            getClientes();
        }
    });
}

// UPDATE un cliente
function updateCliente() {
    console.log('updateCliente');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "cliente/update",
        dataType: "json",
        data: clienteToJSON(),
        success: function() {
            getClientes();
        }
    });
}

// DELETE un cliente
function deleteCliente() {
    console.log('deleteCliente');
    $.ajax({
        type: 'DELETE',
        url: rootURL + 'cliente/' + $("#delete-value").val(),
        success: function() {
            getClientes();
        }
    });

}

// GET todas las rutas
function getRutas() {
    console.log('getRutas');
    $.ajax({
        type: 'GET',
        url: rootURL + "ruta/getRutas",
        dataType: "json",
        success: function(data) {
            renderRutas(data);
        }
    });
}

// POST una ruta
function postRuta() {
    console.log('postRuta');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "ruta",
        dataType: "json",
        data: rutaToJSON(),
        success: function() {
            getRutas();
        }
    });
}

// UPDATE una ruta
function updateRuta() {
    console.log('updateRuta');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "ruta/update",
        dataType: "json",
        data: rutaToJSON(),
        success: function() {
            getRutas();
        }
    });
}

// DELETE una ruta
function deleteRuta() {
    console.log('deleteRuta');
    $.ajax({
        type: 'DELETE',
        url: rootURL + 'ruta/' + $("#delete-value").val()
    });
}

// GET todos los contenedores
function getContenedores() {
    console.log('getContenedores');
    $.ajax({
        type: 'GET',
        url: rootURL + "contenedor/getContenedores",
        dataType: "json",
        success: function(data) {
            renderContenedores(data);
        }
    });
}

// POST un contenedor
function postContenedor() {
    console.log('postContenedor');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "contenedor",
        dataType: "json",
        data: contenedorToJSON(),
        success: function() {
            getContenedores();
        }
    });
}

// UPDATE un contenedor
function updateContenedor() {
    console.log('updateContenedor');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "contenedor/update",
        dataType: "json",
        data: contenedorToJSON(),
        success: function() {
            getContenedores();
        }
    });
}

// DELETE un contenedor
function deleteContenedor() {
    console.log('deleteContenedor');
    $.ajax({
        type: 'DELETE',
        url: rootURL + 'contenedor/' + $("#delete-value").val()
    });
}

// GET todos los paquetes en almacenaje
function getPaquetesEmpleado() {
    console.log('getPaquetesEmpleado');
    $.ajax({
        type: 'GET',
        url: rootURL + "paquete/getPaquetesEmpleado",
        dataType: "json",
        success: function(data) {
            renderPaquetesEmpleado(data);
        }
    });
}

function desalmacenarPaquete() {
    console.log('desalmacenarPaquete');
    $.ajax({
        type: 'GET',
        url: rootURL + "paquete/desalmacenar/" + $("#update-value").val(),
        dataType: "json",
        success: function() {
            getPaquetesEmpleado();
        }
    });
}

function desembalarPaquete() {
    console.log('desembalarPaquete');
    $.ajax({
        type: 'GET',
        url: rootURL + "paquete/desembalar/" + $("#update-value").val(),
        dataType: "json",
        success: function() {
            getPaquetesEmpleado();
        }
    });
}

// POST un paquete
function postPaquete() {
    console.log('postPaquete');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "paquete",
        dataType: "json",
        data: paqueteToJSON(),
        success: function() {
            getClientes();
        }
    });
}

// GET todos los paquetes de un cliente
function getPaquetesCliente() {
    console.log('getPaquetesCliente');
    $.ajax({
        type: 'GET',
        url: rootURL + "cliente/getPaquetes/" + $("#cedula-cliente").val(),
        dataType: "json",
        success: function(data) {
            $("#tabla-paquetes").show();
            renderPaquetesCliente(data);
        }
    });
}

function getFacturaPaquete() {
    console.log('getFacturaPaquete');
    $.ajax({
        type: 'GET',
        url: rootURL + "factura/getFacturaPaquete/" + $("#paquete-value").val(),
        dataType: "json",
        success: function(data) {
            renderFacturaPaquete(data);
        }
    });
}

function getTrackingPaquete() {
    console.log('getTrackingPaquete');
    $.ajax({
        type: 'GET',
        url: rootURL + "tracking/getTrackingPaquete/" + $("#paquete-value").val(),
        dataType: "json",
        success: function(data) {
            renderTrackingPaquete(data);
        }
    });
}

function getMejoresClientes() {
    console.log('getMejoresClientes');
    $.ajax({
        type: 'GET',
        url: rootURL + "cliente/getMejoresClientes/",
        dataType: "json",
        success: function(data) {
            renderMejoresClientes(data);
        }
    });
}

function getPeoresClientes() {
    console.log('getPeoresClientes');
    $.ajax({
        type: 'GET',
        url: rootURL + "cliente/getPeoresClientes/",
        dataType: "json",
        success: function(data) {
            renderPeoresClientes(data);
        }
    });
}

function getMejoresRutas() {
    console.log('getMejoresRutas');
    $.ajax({
        type: 'GET',
        url: rootURL + "ruta/getMejoresRutas/",
        dataType: "json",
        success: function(data) {
            renderMejoresRutas(data);
        }
    });
}

function getPeoresRutas() {
    console.log('getPeoresRutas');
    $.ajax({
        type: 'GET',
        url: rootURL + "ruta/getPeoresRutas/",
        dataType: "json",
        success: function(data) {
            renderPeoresRutas(data);
        }
    });
}
function renderClientes(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<tr>";
        out += "<td id=\"campo-cedula\">" + data[i].idCliente + "</td>";
        out += "<td id=\"campo-cuenta\">" + data[i].numero_cuenta + "</td>";
        out += "<td id=\"campo-nombre\">" + data[i].nombre + "</td>";
        out += "<td id=\"campo-telefono\">" + data[i].telefono + "</td>";
        out += "<td id=\"campo-ruta\">" + data[i].idRutaEnvio + "</td>";
        out += "<td id=\"campo-puntos\">" + data[i].puntos + "</td>";
        out += "<td id=\"campo-tipo\">" + data[i].tipo + "</td>";
        out += "<td><p><button class=\"btn btn-primary btn-xs cli-edit\" data-title=\"Edit-cliente\" data-toggle=\"modal\" data-target=\"#edit-cliente\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-pencil\"></span></button></p></td>";
        out += "<td><p><button class=\"btn btn-danger btn-xs cli-delete\" data-title=\"Delete-cliente\" data-toggle=\"modal\" data-target=\"#delete-cliente\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-trash\"></span></button></p></td>";
        out += "</tr>";
    }
    $("#cli-table-body").html(out);
}


function renderRutas(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<tr>";
        out += "<td id=\"campo-numero\">" + data[i].idRutaEnvio + "</td>";
        out += "<td id=\"campo-nombre\">" + data[i].nombre + "</td>";
        out += "<td id=\"campo-salida\">" + data[i].pto_salida + "</td>";
        out += "<td id=\"campo-llegada\">" + data[i].pto_llegada + "</td>";
        out += "<td id=\"campo-tiempo\">" + data[i].tiempo_dias + "</td>";
        out += "<td id=\"campo-costo\">" + data[i].costo + "</td>";
        out += "<td id=\"campo-contenedores\">" + data[i].maximocontenedor + "</td>";
        out += "<td><p><button class=\"btn btn-primary btn-xs rut-edit\" data-title=\"Edit-ruta\" data-toggle=\"modal\" data-target=\"#edit-ruta\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-pencil\"></span></button></p></td>";
        out += "<td><p><button class=\"btn btn-danger btn-xs rut-delete\" data-title=\"Delete-ruta\" data-toggle=\"modal\" data-target=\"#delete-ruta\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-trash\"></span></button></p></td>";
        out += "</tr>";
    }
    $("#rut-table-body").html(out);
}


function renderContenedores(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<tr>";
        out += "<td id=\"campo-numero\">" + data[i].idContenedor + "</td>";
        out += "<td id=\"campo-ruta\">" + data[i].idRuta + "</td>";
        out += "<td id=\"campo-peso\">" + data[i].peso_max + "</td>";
        out += "<td><p><button class=\"btn btn-primary btn-xs con-edit\" data-title=\"Edit-contenedor\" data-toggle=\"modal\" data-target=\"#edit-contenedor\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-pencil\"></span></button></p></td>";
        out += "<td><p><button class=\"btn btn-danger btn-xs con-delete\" data-title=\"Delete-contenedor\" data-toggle=\"modal\" data-target=\"#delete-contenedor\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-trash\"></span></button></p></td>";
        out += "</tr>";
    }
    $("#con-table-body").html(out);
}

function renderPaquetesEmpleado(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<tr>";
        out += "<td id=\"campo-numero\">" + data[i].idPaquete + "</td>";
        out += "<td id=\"campo-peso\">" + data[i].peso + "</td>";
        out += "<td id=\"campo-descripcion\">" + data[i].descripcion + "</td>";
        out += "<td id=\"campo-valor\">" + data[i].valor + "</td>";
        out += "<td id=\"campo-tipo\">" + data[i].categoria + "</td>";
        out += "<td id=\"campo-cliente\">" + data[i].idCliente + "</td>";
        if (data[i].estado === 2) {
            out += "<td><p><button class=\"btn btn-primary btn-xs desalmacenar\" data-title=\"Desalmacenar\" ><span class=\"glyphicon glyphicon-plane\"></span></button></p></td>";
            out += "<td></td>";
        }
        if (data[i].estado === 5) {
            out += "<td></td>";
            out += "<td><p><button class=\"btn btn-primary btn-xs desembalar\" data-title=\"Desembalar\" ><span class=\"glyphicon glyphicon-gift\"></span></button></p></td>";
        }
    }
    $("#paq-table-body").html(out);
}

function renderPaquetesCliente(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<tr>";
        out += "<td class=\"campo-numero\" data-title=\"Factura-paquete\" data-toggle=\"modal\" data-target=\"#factura-paquete\">" + data[i].idPaquete + "</td>";
        out += "<td>" + data[i].descripcion + "</td>";
        out += "<td class=\"campo-estado\" data-title=\"Tracking-paquete\" data-toggle=\"modal\" data-target=\"#tracking-paquete\">" + data[i].estadoActual + "</td>";
    }
    $("#paq-table-body").html(out);
}

function renderFacturaPaquete(data) {
    $("#factura-paquete #numero-paquete").html("Orden# " + $("#paquete-value").val());
    $("#factura-flete").html("$0,00");
    $("#factura-almacenaje").html("$0,00");
    $("#subtotal1").html("$0,00");
    $("#factura-impuesto").html("$0,00");
    $("#subtotal2").html("$0,00");
    $("#total").html("$0,00");
    $("#factura-flete").html("$" + data[0].flete);
    $("#factura-almacenaje").html("$" + data[0].almacenaje);
    $("#subtotal1").html("$" + (data[0].flete + data[0].almacenaje));
    $("#factura-impuesto").html("$" + data[0].impuesto);
    $("#subtotal2").html("$" + data[0].impuesto);
    $("#total").html("$" + (data[0].flete + data[0].almacenaje + data[0].impuesto));
}


function renderTrackingPaquete(data) {
    $("#tracking-paquete #numero-paquete").html("Orden# " + $("#paquete-value").val());
    $("#estado1").html("no disponible");
    $("#estado2").html("no disponible");
    $("#estado3").html("no disponible");
    $("#estado4").html("no disponible");
    $("#estado5").html("no disponible");
    var i;
    for (i = 0; i < data.length; i++) {
        if(data[i].estado==="Ordenado")$("#estado1").html(data[i].fecha);
        if(data[i].estado==="Almacenado")$("#estado2").html(data[i].fecha);
        if(data[i].estado==="Transito")$("#estado3").html(data[i].fecha);
        if(data[i].estado==="Listo")$("#estado4").html(data[i].fecha);
        if(data[i].estado==="Entregado")$("#estado5").html(data[i].fecha);
    }
}

function renderMejoresClientes(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<li class=\"list-group-item\">" + data[i].nombre + "</li>";
    }
    $("#lista-mejores-clientes").html(out);
}

function renderPeoresClientes(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<li class=\"list-group-item\">" + data[i].nombre + "</li>";
    }
    $("#lista-peores-clientes").html(out);
}

function renderMejoresRutas(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<li class=\"list-group-item\">" + data[i].nombre + " ( " + data[i].pto_salida + " - " + data[i].pto_llegada + " ) </li>";
    }
    $("#lista-mejores-rutas").html(out);
}

function renderPeoresRutas(data) {
    var i;
    var out = "";
    for (i = 0; i < data.length; i++) {
        out += "<li class=\"list-group-item\">" + data[i].nombre + " ( " + data[i].pto_salida + " - " + data[i].pto_llegada + " ) </li>";
    }
    $("#lista-peores-rutas").html(out);
}

function clienteToJSON() {
    return JSON.stringify({
        "idCliente": $("#edit-cliente #cedula").val(),
        "numero_cuenta": $("#edit-cliente #cuenta").val(),
        "nombre": $("#edit-cliente #nombre").val(),
        "telefono": $("#edit-cliente #telefono").val(),
        "idRutaEnvio": $("#edit-cliente #ruta").val(),
        "puntos": $("#edit-cliente #puntos").val(),
        "tipo": $("#edit-cliente #tipo").val()
    });
}

function rutaToJSON() {
    return JSON.stringify({
        "idRutaEnvio": $("#edit-ruta #numero").val(),
        "nombre": $("#edit-ruta #nombre").val(),
        "pto_salida": $("#edit-ruta #salida").val(),
        "pto_llegada": $("#edit-ruta #llegada").val(),
        "tiempo_dias": $("#edit-ruta #tiempo").val(),
        "costo": $("#edit-ruta #costo").val(),
        "maximocontenedor": $("#edit-ruta #contenedores").val()
    });
}

function contenedorToJSON() {
    return JSON.stringify({
        "idContenedor": $("#edit-contenedor #numero").val(),
        "idRuta": $("#edit-contenedor #ruta").val(),
        "peso_max": $("#edit-contenedor #peso").val()
    });
}

function paqueteToJSON() {
    return JSON.stringify({
        "idPaquete": $("#edit-paquete #numero").val(),
        "peso": $("#edit-paquete #peso").val(),
        "descripcion": $("#edit-paquete #descripcion").val(),
        "valor": $("#edit-paquete #valor").val(),
        "categoria": $("#edit-paquete #tipo").val(),
        "idCliente": $("#edit-paquete #cliente").val(),
    });
}
