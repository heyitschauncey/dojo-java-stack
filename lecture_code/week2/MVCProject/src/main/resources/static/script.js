var title = "";
var description = "";
var language = "";
var numberOfPages = 100;




fetch("http://localhost:8080/api/books") // fetch returns a promise
	.then(res => res.json()) // this also returns promise
	.then(data => {
		const tableBody = document.getElementById("tableBody");
	
		for (const book of data) {
			const row = document.createElement("tr");
			let html = `
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.description}</td>
				<td>${book.language}</td>
				<td>${book.numberOfPages}</td>
				<td>Temp</td>
			`
			row.innerHTML = html;
			tableBody.appendChild(row);
		}
	})

const setTitle = (event) => {
	title = event.target.value;
	console.log(title);
}

const setDescription = (event) => {
	description = event.target.value;
	console.log(description);
}

const setLanguage = (event) => {
	language = event.target.value;
	console.log(language);
}

const setNumberOfPages = (event) => {
	numberOfPages = event.target.value;
	console.log(numberOfPages);
}

const submitForm = () => {
	console.log("hello")
	const formBook = {
	    title: title,
		description: description,
		language: language,
		numberOfPages: numberOfPages
	  } 

	const options = {
	    method: 'POST',
	    body: JSON.stringify(formBook),
	    headers: {
	        'Content-Type': 'application/json'
	    }
	}

	// console.log(formBook)
	fetch("http://localhost:8080/api/books/create", options)
		.then(res => res.json())
		.then( (book) => { 
			if (book.error != undefined) {
				console.log(book.message);
			} else {
		   const tableBody = document.getElementById("tableBody");
		   const row = document.createElement("tr");
			  let html = `
				  <td>${book.id}</td>
				  <td>${book.title}</td>
				  <td>${book.description}</td>
				  <td>${book.language}</td>
				  <td>${book.numberOfPages}</td>
				  <td>Temp</td>
			  `
			  row.innerHTML = html;
			  tableBody.appendChild(row);
		}})
		.catch(err => err.json())
		.then(err => console.log(err))
}

