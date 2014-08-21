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
        data: clienteToJSON()
    });
}

function deleteCliente(idCliente) {
    console.log('deleteCliente');
    $.ajax({
        type: 'DELETE',
        url: rootURL + 'cliente/' + idCliente
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

// POST un cliente
function postRuta() {
    console.log('postRuta');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "ruta",
        dataType: "json",
        data: rutaToJSON()
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

// POST un cliente
function postContenedor() {
    console.log('postContenedor');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "contenedor",
        dataType: "json",
        data: contenedorToJSON()
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
        out += "<td><p><button class=\"btn btn-danger btn-xs\" data-title=\"Delete\" data-toggle=\"modal\" data-target=\"#delete\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-trash\"></span></button></p></td>";
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
        out += "<td id=\"campo-tiempo\">" + data[i].tiempo + "</td>";
        out += "<td id=\"campo-costo\">" + data[i].costo + "</td>";
        out += "<td id=\"campo-contenedores\">" + data[i].maximocontenedor + "</td>";
        out += "<td><p><button class=\"btn btn-primary btn-xs rut-edit\" data-title=\"Edit-ruta\" data-toggle=\"modal\" data-target=\"#edit-ruta\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-pencil\"></span></button></p></td>";
        out += "<td><p><button class=\"btn btn-danger btn-xs\" data-title=\"Delete\" data-toggle=\"modal\" data-target=\"#delete\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-trash\"></span></button></p></td>";
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
        out += "<td><p><button class=\"btn btn-danger btn-xs\" data-title=\"Delete\" data-toggle=\"modal\" data-target=\"#delete\" data-placement=\"top\" rel=\"tooltip\"><span class=\"glyphicon glyphicon-trash\"></span></button></p></td>";
out += "</tr>";
    }
    $("#con-table-body").html(out);
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
        "tiempo": $("#edit-ruta #tiempo").val(),
        "costo": $("#edit-ruta #costo").val(),
        "maximocontenedor": $("#edit-ruta #contenedores").val()
        });
}

function contenedorToJSON() {
    return JSON.stringify({
        "idContenedor": $("#edit-contenedor #numero").val(),
        "idRuta": $("#edit-contenedor #ruta").val(),
        "peso_max": $("#edit-contenedor #peso").val(),
        });
}