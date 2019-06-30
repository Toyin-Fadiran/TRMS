/**
 * 
 */

function getForms() {
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			let forms = xhr.responseText;
			console.log(forms);
			document.getElementById("form-list").innerHTML = forms;
		}
	}
	
	xhr.open("GET", "/TRMS/supervisor", true);
	
	xhr.send();
	
}

function getFormById() {
	let formName = document.getElementById("form-id-input").value;
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			let form = JSON.parse(xhr.responseText);
			//let form = (xhr.responseText);
			console.log(form);
			displayForm(form);
		}
	}
	
	xhr.open("GET", "/TRMS/supervisor/" + formName, true);
	
	xhr.send();
}

function displayForm (form) {
	let formString = "ReimburseId: " + form.reimbursementId + "<br>" +
		"EmployeeId: " + form.employeeID + "<br>" +
		"Start Date: " + form.startdate + "<br>" +
        "End Date: " + form.enddate + "<br>" +
        "Address Location: " + form.address + "<br>" +
		"Events: " + form.events + "<br>" +
		"Description: " + form.description+"<br>" +
        "Work Justify: " + form.work_justify + "<br>" +
        "Status: " + form.status + "<br>" +
		"Course Cost: " + form.course_cost + "<br>" +
        "Grading Format: " + form.grading_format + "<br>" +
        "form time" + form.form_time

	document.getElementById("my-form").innerHTML = formString;
}

function postAnimal() {

	let name = document.getElementById("name").value;
	let breed = document.getElementById("breed").value;
	let age = document.getElementById("age").value;

	let animal = new Animal(name, breed, age);

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {

		if (xhr.readyState === 4 && xhr.status === 200) {
			document.getElementById("result").innerHTML = xhr.responseText;
			getMyPets();
		}

	}

	xhr.open("POST", "/ServletExample/animal/", true);

	xhr.send(JSON.stringify(animal));

}

let Animal = function(name, breed, age) {
	this.name = name;
	this.breed = breed;
	this.age = age;
}

let Form = function(reimbursementId, employeeID, 
    startdate, enddate, form_time, address, description,
    course_cost, status, grading_format, events, work_justify  ) {
            this.reimbursementId = reimbursementId;
            this.employeeID = employeeID;
            this.startdate = startdate;
            this.enddate = enddate;
            this.form_time = form_time;
            this.address_location = address;
            this.description = description;
            this.course_cost = course_cost;
            this.status = status;
            this.grading_format = grading_format;
            this.events = events;
            this.work_justify = work_justify;

    }


window.onload = function () {
	
	getForms();
	 document.getElementById("get-form").addEventListener("click", getFormById);
	// document.getElementById("updatestatus").addEventListener("click", postAnimal);
}