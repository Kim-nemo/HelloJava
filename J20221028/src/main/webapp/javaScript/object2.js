/**
 * 	object2.js
 */

document.addEventListener('DOMContentLoaded', function() {
	// document.getElementById('show').innerHTML = '<p>Hello, World</p>';
	let data = `[{"id":1,"first_name":"Jorrie","last_name":"Worsham","email":"jworsham0@wsj.com","gender":"Female","salary":8191},
{"id":2,"first_name":"Shela","last_name":"Lantuffe","email":"slantuffe1@elpais.com","gender":"Female","salary":5668},
{"id":3,"first_name":"Ellwood","last_name":"Saltrese","email":"esaltrese2@barnesandnoble.com","gender":"Male","salary":7488},
{"id":4,"first_name":"Jimmie","last_name":"Wiffen","email":"jwiffen3@51.la","gender":"Male","salary":4757},
{"id":5,"first_name":"Lizette","last_name":"Layne","email":"llayne4@oakley.com","gender":"Polygender","salary":1878},
{"id":6,"first_name":"Lyndsey","last_name":"Iwanicki","email":"liwanicki5@dell.com","gender":"Female","salary":7435},
{"id":7,"first_name":"Giselbert","last_name":"Pothergill","email":"gpothergill6@aol.com","gender":"Male","salary":5751},
{"id":8,"first_name":"Marice","last_name":"Casterton","email":"mcasterton7@tiny.cc","gender":"Female","salary":4803},
{"id":9,"first_name":"Fawn","last_name":"Zoppo","email":"fzoppo8@rambler.ru","gender":"Female","salary":5488},
{"id":10,"first_name":"Harvey","last_name":"Labusch","email":"hlabusch9@mac.com","gender":"Male","salary":6265}]`;

// json 타입 => javascript 오브젝트.

let result = JSON.parse(data);
console.log(result);

// for (String str : personList) {}
// <ul><li>obj</li><li>obj</li><li>obj</li><li>obj</li><li>obj</li></ul>
// <div id="show"></div>

const fields = ['id', 'first_name', 'email', 'salary'];
let trTag = document.createElement('table');

for (row of result){
	trTag.appendChild(makeTr(row));
}



function makeTr(obj){
	let tdTag = document.createElement('td');
	let str = '';
	for(fld of fields) {
		str += `${obj[fld]} `;
	}
	let txt = document.createTextNode(str);
	tdTag.appendChild(txt);
	
	return tdTag;
	
}

document.getElementById('show').appendChild(trTag);

/*
function makeList(obj) {
	let liTag = document.createElement('li');
	let str = '';
	for(field of fields){
		str += `${field}: ${obj[field]} `;
	}
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}
*/ 
});

