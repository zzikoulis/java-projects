$(document).ready(function() {
    $('#btn').on('click', function() {
        fetchEmployeesFromJSON($('#searchInput').val().trim())
    })
})

function fetchTEmployeesFromJSON(lastname) {
    let xhr = new XMLHttpRequest()

    xhr.open('GET', `/employees-webapp-hibernate/employees?lastname=${lastname}`, true)

    xhr.timeout = 5000
    xhr.ontimeout = (e) => onAPIError()

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) 
        {
            if (xhr.status === 200) {
               
                handleResults(JSON.parse(xhr.responseText))
            } else {
                onAPIError()
            }
        }
    }
    
    xhr.send()
}


function handleResults(response) {
    let employeesList = response;
   
    if (jQuery.isEmptyObject(response)) {
    	$(".employees-list").html("No employee was found");
    } else {   
	    let output = "<tr><th>Id</th><th>Όνομα</th><th>Επώνυμο</th></tr>";
	
	    for (let employee of employeesList) {
	        output += "<tr><td>"
	        + employee.id
	        + "</td><td>"
	        + employee.firstname
	        + "</td><td>"
	        + employee.lastname
	        + "</td></tr>";
	    }
	
	    $(".employees-list").html(output);
    }
}


function onAPIError() {
    alert('API Error')
}