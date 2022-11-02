// covid.js

//이벤트 넣는 곳
window.onload = function () {
    // request url.
    let url =
        'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=F%2B6Yp772jJVMcrgR3LIn%2FvYKLwr0Hty%2FsIIP6G9jmppldRZD6tPwme%2FfLLaIBbCDyyx9xtOSnIwpxiobOBaeWw%3D%3D';

    fetch(url)
        .then(result => result.json()) // json -> object
        .then(showList)
        .catch(error => console.log(error));

    document.querySelector('#findBtn').addEventListener('click', findCenterList);
}
let titles = {
    id: '센터ID',
    centerName: '센터명',
    phoneNumber: '연락처',
    lat: '위도',
    lng: '경도'
};

let data;

// 실행하고싶은 기능 넣는 곳
function showList(result) { // 젤먼저 실행
    // 타이틀 생성
    makeHead(); // 호출

    // body 영역 생성. 데이터 초기화
    console.log(data); // 정상적으로 값 가져오는지 출력 확인
    data = result.data;

    makeOption(data);

    let selectedCity = data.filter(center => center.sido == '서울특별시');
    makeList(selectedCity);

}

function makeOption(ary = []) {
    // select 태그 생성
    let sidoAry = []; // ['서울특별시','대전광역시,'인천광역시','경기도'...] 중복된 값 제외
    data.forEach(center => {
        // data에 있는 센터정보와 sidoAry에 있는 센터정보 비교
        // sidoAry에 값이 있으면 no, sidoAry에 값이 없으면 추가
        if (sidoAry.indexOf(center.sido) == -1) { // indexOf는 찾는 문자열이 없으면 -1을 리턴
            sidoAry.push(center.sido);
        }
    });
    let cityList = document.getElementById('city');
    sidoAry.forEach(sido => { // 옵션태그, 밸류지정, 텍스트값 만들어서 #city값 아래에 append
        let option = document.createElement('option');
        option.value = sido;
        option.textContent = sido;

        cityList.append(option);
    });
}

function findCenterList() {
    let searchKey = document.querySelector('#city').value;
    let searchAry = data.filter(center => center.sido == searchKey);
    makeList(searchAry); // 찾고자 하는 값을 searchAry담아줌
}

function makeList(ary = []) {
    // 화면에 tr이 있으면 tr 삭제
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove());
    let list = document.getElementById('list');

    ary.forEach(center => {
        list.append(makeTr(center));
    });
    //
    document.querySelectorAll('#list>tr').forEach((tr, idx) => {
        let td = document.createElement('td');
        td.textContent = idx + 1;
        tr.prepend(td); // append():마지막위치에 추가. prepend(): 처음위치에 추가
    });

}

function makeTr(row = {}) { // row는 center값 하나 들어오는것
    let tr = document.createElement('tr');
    tr.setAttribute('lng', row.lng);
    tr.setAttribute('lat', row.lat);
    tr.setAttribute('fName', row.facilityName);
    tr.addEventListener('click', openInfoWindow);
    //td 생성
    for (let field in titles) {
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]);
        td.appendChild(txt);
        tr.appendChild(td);
    }
    return tr;
}

function openInfoWindow(e) { // event라는 속성이 자동으로 들어감
    console.log(e.target.parentElement); //tr lng, lat
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let facilityName = e.target.parentElement.getAttribute('fName');

    window.location.href = 'infoWindow.html?x=' + lng + '&y=' + lat + '&fName=' + facilityName;

}

function makeHead() {
    // 타이틀.
    let tr = document.createElement('tr');
    let th = document.createElement('th');
    th.textContent = '순번';
    tr.appendChild(th);
    for (let title in titles) {
        let th = document.createElement('th');
        let txt = document.createTextNode(titles[title]); // titles가 가지고 있는 title들을 돌면서 값을 가져오겠다
        th.appendChild(txt);
        tr.appendChild(th);
    }
    document.getElementById('title').append(tr); // 만든 tr을 thead에 붙이는 과정
}