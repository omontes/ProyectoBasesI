 // The root URL for the RESTful services
var rootURL = "http://localhost:8080/CargoDispatcher/webresources/generic/getRutas";

// Retrieve Employees list when application starts 
findAll();



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

function renderList(data) {
        $('#h1').append(data[0].nombre);
        //var list = JSON.parse(data);
	//$('#employeeList li').remove();
        //var i;
        //for(i = 0; i < arr.length; i++) {
        //    $('#employeeList').append('<li><a href="#" data-identity="' + list[0].Ssn + '">'+ list[1].Name+'</a></li>');
        //}
    }