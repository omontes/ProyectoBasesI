 // The root URL for the RESTful services
var rootURL = "http://localhost:8080/CargoDispatcher/webresources";

// Retrieve Employees list when application starts 
getClientes();



function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: function(data){
                        $('#h1').append("Consulta Realizada");
			renderList(data);
		}
	});
}
function getClientes() {
    //console.log('getClientes');
    $.ajax({
        
        type: 'GET',
        url: rootURL + "/ruta/getMejoresRutas",
        dataType: "json",
        success: function(data) {
            $('#h1').append("Consulta Realizada");
            //renderClientes(data);
        }
    });
}
function renderList(data) {
        $('#h1').append(data[0].descripcion);
        //var list = JSON.parse(data);
	//$('#employeeList li').remove();
        //var i;
        //for(i = 0; i < arr.length; i++) {
        //    $('#employeeList').append('<li><a href="#" data-identity="' + list[0].Ssn + '">'+ list[1].Name+'</a></li>');
        //}
    }