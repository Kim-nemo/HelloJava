// dom2.js

document.addEventListener('DOMContentLoaded', domLoadedFunc);

function domLoadedFunc(){
    let data = `[{"id":1,"first_name":"Jorrie","last_name":"Worsham","email":"jworsham0@wsj.com","gender":"Female","salary":8191},
                 {"id":2,"first_name":"Shela","last_name":"Lantuffe","email":"slantuffe1@elpais.com","gender":"Female","salary":5668},
                 {"id":3,"first_name":"Ellwood","last_name":"Saltrese","email":"esaltrese2@barnesandnoble.com","gender":"Male","salary":7488},
                 {"id":4,"first_name":"Jimmie","last_name":"Wiffen","email":"jwiffen3@51.la","gender":"Male","salary":4757}
                ]`;
    let obj = {}
    let result = JSON.parse(data); // json => object
    console.log(result);

    console.log(result[1].email);
    for(let i=0; i<result.length; i++){
        console.log(`firstName: ${result[i].first_name}, lastName: ${result[i]['last_name']}`);
    }
    
    // 확장for
    for (let obj of result){
        console.log(`id: ${obj.id}, email: ${obj['email']}`);
    }
    console.clear();
    // 배열일 경우 Array.forEach()
    result.forEach(function(value, index) {
        // if(value.salary > 6000)
        if(index < 2)
            console.log(value, index);
    });

    // 확장for
        // table 
    let table = document.createElement('table');
    let show = document.getElementById('show');
    show.appendChild(table);
        // thead
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
    for (let title of titles){
        let idTag = document.createElement('th');
        let idTxt = document.createTextNode(title); // ex) <th> 아이디</th>
        idTag.appendChild(idTxt);
        tr.appendChild(idTag);
    }
    //checkbox생성
    let td = document.createElement('th');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    checkbox.addEventListener('change', function(){
        let cks = document.querySelectorAll('#show input[type="checkbox"]');
        cks.forEach(function(check){
            check.checked = checkbox.checked;
        });
    })
    
    td.appendChild(checkbox);
    tr.appendChild(td);
    thead.appendChild(tr);
    table.appendChild(thead);
    
    // tbody
    let tbody = document.createElement('tbody');
    table.appendChild(tbody);
    let fields = ['id', 'first_name', 'email', 'gender', 'salary'];
    for (let obj of result) {
        
        let tr = makeTr(obj);
        tbody.appendChild(tr);
    } // end of for (let obj of result)

    // 추가 버튼에 이벤트 등록
    document.querySelector('button[type="button"]').addEventListener('click', function(){
        console.log('추가버튼');
        let id = document.getElementById('id').value;
        let fn = document.getElementById('fname').value;
        //let ln = document.getElementById('lname').value;
        let em = document.getElementById('email').value;
        let sa = document.getElementById('salary').value;
        let gn = document.getElementById('gender').value;
        let newRow = {
            id: id,
            first_name: fn,
            last_name: ln,
            email: em,
            salary: sa,
            gender: gn
        }
        document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));

    });

    // 수정버튼에 이벤트 등록.
    document.querySelectorAll('button[type="button"]')[1].addEventListener('click', updateFunc);
    
    function updateFunc(){
        let trs = document.querySelectorAll('#show>table>tbody>tr');

        for(let i=0; i<trs.length; i++){
            if(trs[i].children[0].textContent == document.getElementById('id').value){
                trs[i].children[4].textContent = document.getElementById('salary').value;
                trs[i].children[3].textContent = document.getElementById('gender').value;
                trs[i].children[2].textContent = document.getElementById('email').value;
                trs[i].children[1].textContent = document.getElementById('fname').value;
            }
        }
    }

    function makeTr(row){
        // 데이터 건수만큼 반복.
        let tr = document.createElement('tr');
        tr.addEventListener('click', showDetailFunc);
        tr.addEventListener('mouseout', function(){
            this.style.backgroundColor = null;
        });
        for (let field of fields) {
            // 항목만큼 반복
            let td = document.createElement('td');
            let txt = document.createTextNode(row[field]);
            td.appendChild(txt);
            tr.appendChild(td);
        }
        // 삭제버튼 <td><button>삭제</button></td>
        let td = document.createElement('td');
        let btn = document.createElement('button');
        btn.addEventListener('click', function(){
            console.log(this);
            this.parentElement.parentElement.remove(); // 버튼의 부모요소 가져오기
        });
        let txt = document.createTextNode('삭제');
        td.appendChild(btn);
        btn.appendChild(txt);
        tr.appendChild(td);
        

        // 체크박스
        td = document.createElement('td');
        td.style.textAlign='center';
        let check = document.createElement('input');
        check.addEventListener('change', function(){
            console.log(this.checked);
        })
        check.setAttribute('type','checkbox');
        td.appendChild(check);
        tr.appendChild(td);
        
        // 선택삭제
        document.querySelectorAll('button[type="button"]')[2].addEventListener('click', deleteFunc);
    
        function deleteFunc(){
        let trs = document.querySelectorAll('#show>table>tbody>tr');
        for(let i=0; i<trs.length; i++){
            if(trs[i].children[6].firstElementChild.checked){
                trs[i].remove();
                } 
            }
        }

        return tr;
    } // end of makeTr();

    function showDetailFunc(){
        this.style.backgroundColor = 'skyblue';
        console.log(this.children[2].textContent);
        document.getElementById('id').value = this.children[0].textContent;
        document.getElementById('fname').value = this.children[1].textContent;
        document.getElementById('email').value = this.children[2].textContent;
        document.getElementById('gender').value = this.children[3].textContent;
        document.getElementById('salary').value = this.children[4].textContent;
    }

} // end of domLoadedFunc();