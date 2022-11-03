// MyTodoList.js

let itemList = [];
let addBtn = document.querySelector('#add');
addBtn.addEventListener("click", addList);

function addList(){
    let item = document.querySelector('#item').value; // 입력값
    if(item != ''){
        itemList.push(item);
        document.querySelector('#item').value = '';
        document.querySelector('#item').focus();
        showList();
    }
}
function showList(){
    let list ="<ul>";
        for(let i=0; i<itemList.length; i++){
            list+= "<li>" + itemList[i] + "<span class='close' id=" + i + ">X</span></li>";
        }
        list += "</ul>";
            document.querySelector('#itemList').innerHTML = list;
        let remove = document.getElementsByClassName('close'); 
        for(let i=0; i<remove.length; i++){
            remove[i].addEventListener("click", removeList);  
        }
}
function removeList(){ 
    let id = this.getAttribute("id"); 
    itemList.splice(id,1); 
    showList(); 
}