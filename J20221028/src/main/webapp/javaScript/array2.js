// array2.js
fetch('./MemberListServlet') // 기본값은 get방식
    .then(result => result.json())
    .then(listShow)
    .catch(error => console.error(error));

function listShow(data = []){
    // 권한 admin인 사람들만 출력 
    // data.forEach(member => {
    //     if(member.resposibility == 'admin')
    //         console.log(member);
    // });

    // 권한 user인 사람들만 userGroup에 담기
    let userGroup = [];
    // filter 사용
    userGroup = data.filter(member => member.resposibility == 'user');
    //.forEach(userGroup => console.log(userGroup));
    // forEach 사용
    data.forEach(member =>{
        if(member.resposibility = 'user')
            userGroup.push(member); // 하나씩 추가할때 push, 제거할때 pop
    })
    
}