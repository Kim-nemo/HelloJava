/**
 *  dom3.js
 */

document.addEventListener('DOMContentLoaded', function(){

    document.querySelector('button').addEventListener('click', function(){
        // 아이디 조회해서 화면에서 삭제
        document.querySelectorAll('button[type="button"]')[0].addEventListener('click', delFunc());

        function delFunc(){
        let trs = document.querySelectorAll('table>tbody>tr');
            for(let i=0; i<trs.length; i++){
                if(trs[i].children[0].textContent == document.getElementById('id').value){
                    trs[i].remove();
                }
            }
        }
    });

    let tableObject = {
        id: 'hong',
        titles: ["아이디", "이름", "이메일","삭제"],
        data: [{id: 'user1', name: '홍길동', email: 'hong@email.com'}, 
               {id: 'user2', name: '김민서', email: 'kim@email.com'},
               {id: 'user3', name: '박항서', email: 'park@email.com'}],
        addData: function(row) {
            this.data.push(row);
        },
        makeTable: function(){
            let table = document.createElement('table');
            let thead = this.makeHead();
            let tbody = this.makeBody();
            table.append(thead, tbody);
            return table;
        },
        makeHead: function(){
            let thead = document.createElement('thead');
            let tr = document.createElement('tr');
            this.titles.forEach(function(title){
                let td = document.createElement('th');
                let txt = document.createTextNode(title);
                td.append(txt);
                tr.append(td);
            });
            thead.append(tr);
            return thead;
        },
        makeBody: function(){
            let tbody = document.createElement('tbody');
            this.data.forEach(val => {
                let tr = document.createElement('tr');
                tbody.append(tr);
                for (let field in val) {
                    let td = document.createElement('td');
                    let txt = document.createTextNode(val[field]);
                    td.append(txt);
                    tr.append(td);
                }

                // 삭제버튼. 클릭하면 한 건 삭제
                let td = document.createElement('td');
                let btn = document.createElement('button');
                btn.addEventListener('click', function(){
                    this.parentElement.parentElement.remove();
                });
                let txt = document.createTextNode('삭제✂');
                td.appendChild(btn);
                btn.appendChild(txt);
                tr.appendChild(td);
            });
            return tbody;
        },
        init: function(){
            let id = 'kim';
            console.log('init call.' + id);
            document.getElementsByTagName('body')[0].append(this.makeTable());
        }
    }
    // 데이터 추가
    tableObject.addData({id: 'user4', name: '황선홍', email: 'hwang@email.com'});

    tableObject.init(); //화면에 그려주는 것

}) // end of DOMContentLoaded.

