// array1.js
fetch('data/MOCK_DATA.json')
    .then(result => result.json())
    .then(composeFnc) // callback함수
    .catch(error => console.error(error));

function composeFnc(result=[]){
    // 급여 5000 넘는 사람들만 filter 한 후에, 새로운 모임 만들기
    result.filter(row => row.salary > 5000)
          .map( row => {
            let team = { // object, 속성 하나씩 추가하거나 바로 넣기 가능
                t_id : row.id,
                t_name : row.first_name + '/' + row.last_name
            } 
            team.t_mail = row.email;
            team['t_dept'] = 'Account';
            return team;
          })
          .forEach(team => console.log(team));
}

// Array.map() => 데이터(row)를 받아서 새로운 형태의 데이터(row')로 받아줌
function mappingFnc(result=[]) {
    let newAry = result.map(row => {
        let newObj = {}; // new Object();
        newObj.user_id = row.id;
        newObj.user_name = row.first_name + '-' + row.last_name;
        newObj.info = row.email;

        return newObj;
    });

    newAry.forEach(obj => console.log(obj));
}

// Array.filter() => 매개함수의 반환값이 true인 요소들만 모아서 새로운 배열생성
function filterFnc(result = []) {
    result.filter((row, idx) => row.salary > 5000) // filter는 조건에 만족하는(return값이 true일 때만 반환) 새로운 배열을 생성해줌
        .forEach(row => console.log(row)); // 이렇게 쓰면 변수 따로 만들어줄 필요없음

    //oddAry.forEach(row => console.log(row));
}

// Array.forEach() => 최종처리하는 기능 구현
function showMain(result) { // 변수이름을 result라고 설정
     //console.log(result);
    result.forEach((row, idx) => { // row는 함수의 매개변수. row를 받아서 =>{} 실행
        console.log(row);
        //if (row.gender == 'Female'){ // row가 가진 속성인 gender가 female인 사람이라면
        if (idx % 2 == 0) { // 인덱스 값이 짝수인 애들만 출력하고 싶다    
            console.log(row.id, row.first_name, row.last_name);
        }
    });
}

function sum(a=0,b=0){ // 밑에 주석처리한 식을 안 쓰기 위해 미리 초기값을 0으로 설정
    // if(a){ //값이 하나만 들어왔을 때
    //     return a+0;
    // }
    // if(a&&b){ // 값이 둘 다 들어왔을 때
    //     return a+b;
    // }
    return a+b;
}
console.log(sum(10));