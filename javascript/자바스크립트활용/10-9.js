document.addEventListener('DOMContentLoaded', function(){
    //폼 버튼 이벤트 리스너 추가  
    document.getElementsByName('reset')[0].addEventListener('click', function(){resetForm();}); // 리셋
    // name이 reset인 즉, '내용 지우기' 버튼에 클릭 이벤트가 발생하면 아래 있는 resetForm() 함수 수행
    document.getElementsByName('save')[0].addEventListener('click', function(){saveItem();}); // 저장
    // name이 save인 즉, '등록' 버튼에 클릭 이벤트가 발생하면 바로 아래 있는 saveItem() 함수 수행
}); 


/* 할일 저장 */
function saveItem(){
    if(validateItemForm()){ // 폼 필드 체크 완료되었으면
    // validateItemForm() 함수의 반환 값이 true (1)라면 ~
        let form = document.getElementById('newitem');
        // id가 newitem인 즉, 할일 폼 안에 작성한 내용을 변수 form에 저장
        let elem = document.createElement('div');
        // <div> 태그를 추가하기 위한 변수 elem 선언
        elem.innerHTML = form.text.trim();
        // form 내용의 양끝 공백을 제거한 문자열을 새롭게 반환하여 elem 즉, <div> 태그 안에 넣음
        elem.firstChild.classList.add('newitem');
        // elem 으로 만들어지는 <div> 태그의 클래스명 'newitem'을 첫번째 자식으로 즉, 가장 상위에 추가
        document.querySelector('.todo .content').append(elem.firstChild);
        // 클래스명이 todo인 모든 하위 중 클래스명이 content 인 노드에 elem의 첫번째 자식의 내용을 추가

        let date = new Date();  // 현재 날짜를 변수 date에 저장

        document.querySelector('.newitem .todo').textContent = document.getElementsByName('todo')[0].value;
        // textarea는 여러줄의 긴 문장을 입력할 수 있는 양식
        // 문서에 todo라는 이름을 가진 즉, textarea에 담긴 내용을 newitem 하위의 모든 todo에 텍스트 저장
        document.querySelector('.newitem .date').textContent = 
            date.getFullYear() + '-' + (date.getUTCMonth() + 1).fillZero(2) + '-' + date.getDate().fillZero(2) + ', ';
        // 'YYYY-MM-DD'의 형식으로 (만약 월 또는 일이 한자리수인 경우 앞에 0을 채움) newitem 하위의 모든 date에 텍스트 저장
        // ex) 2023-12-19
        document.querySelector('.newitem .priority').textContent = 
            '중요도 ' + document.querySelector('input[name="priority"]:checked').value;
        // name이 priority인 즉, radio 버튼이 활성화되어있는 value값을 newitem 하위 priority에 텍스트 저장
        // '중요도+value값'  ex) 중요도 1
        document.querySelector('.newitem .moveitem').addEventListener('click',function(e){
            moveItem(e.target);
        // newitem 하위의 모든 moveitem에 클릭이 발생할 때마다 매개변수 e를 받는 함수를 실행하는데
        // 그 함수의 내용은 moveItem 함수 즉, 요소를 이동시키는 함수를 실행
        });

        document.querySelector('.newitem').classList.remove('newitem');
        // newitem에 있는 내용을 삭제
        // why? moveItem 함수로 기존 내용을 다른 곳에 복제했기 때문에 기존 내용을 삭제해야
        // 옮긴 것처럼 연출할 수 있기 때문

        resetForm(); // 할일 목록에 등록 후 폼 초기화
    }
}

/* 진행단계 이동 */
function moveItem(elem){
    let section = elem.parentNode.parentNode.parentNode;
    // elem의 현재 위치는 section -> div(todo) -> div(content) -> elem
    // 따라서, elem의 부모의 부모의 부모인 section의 내용을 변수 section에 저장
    let item = elem.parentNode;
    // elem의 부모 즉, div(content)의 내용을 변수 item에 저장
    if(section.classList.contains('doing')){
    // classList.contains()는 선택한 요소에 클래스가 있는지 확인하고 boolean을 반환
    // section의 클래스 중에 doing 이 포함되어 있다면 ~
        elem.remove();  // elem을 제거하라
    }
    let ditem = item.parentNode.removeChild(item);
    // removeChild() : 삭제한 노드 참조 반환
    // 즉, 변수 ditem에 item 노드를 저장
    document.querySelector('.'+section.nextElementSibling.className+' .content').append(ditem);
    // nextElementSibling : 형제 모두
    // section의 모든 자식들의 모든 하위에 있는 content에게 적용하라
    // 무엇을? ditem을 추가하라
}

/* 양식 초기화 */
function resetForm(){
    document.getElementsByName('todo')[0].value = '';
    // 이름이 todo인 노드의 첫번째 배열에 공백을 넣음 - 초기화
    let radios = document.getElementsByName('priority');
    // 이름이 priority인 노드에 변수 radios에 배열로 저장
    radios.forEach(function(radio){
    // radios의 배열을 순회하면서 매개변수가 radio인 함수를 실행
        radio.checked = false;
        // priority에 체크되어있는 것들을 전부 false로 바꿈
        // 아무것도 체크가 되어있지 않는 초기 상태로 만듦
    });
}

/* 폼 입력 체크 */
function validateItemForm(){
    let todo = validateItemField('todo','할일','input');
    // validateItemField 함수는 바로 아래에 있음
    // todo, 할일, input을 넣은 validateItemField 함수에서 반환한 값을 변수 todo에 저장
    let priority = validateItemField('priority','중요도','radio');
    // priority, 중요도, radio를 넣은 validateItemField 함수에서 반환한 값을 변수 priority에 저장
    if(todo == '' || priority == ''){
    // todo 값과 priority 값 중 둘 중 하나라도 공백이 존재한다면 ~ (문제 있는 케이스)
        return false;  // false (0)를 반환
                        // 즉, 이 뜻은 saveitem() 함수를 수행하지 않음 = 저장을 안함
                        // why? 문제가 있으니까
    }else{
    // todo 값과 priority 값이 모두 존재한다면 ~ (정상적 케이스)
        return true;  // true (1)를 반환
                        // 후에 saveitem() 함수를 정상적으로 수행할 수 있음
    }
}

/* 개별 필드 입력 체크 */
function validateItemField(fieldname, label, fieldtype){
// 매개변수 fieldname, label, fieldtype을 받는 함수
    let val = '';  // 변수 val 선언 후 초기화
    switch(fieldtype){
        case 'input':  // fieldtype 이 input 이면 ~
            val = document.getElementsByName(fieldname)[0].value;
            // name이 fieldname값인 노드를 찾아서 val 에 저장
            if(val == ''){  // 아무 내용도 입력하지 않았다면
                alert(label+' 을/를 입력해 주십시오.');
                // 브라우저 알림을 출력
                // ex) 할일을 입력해주십시오
                document.getElementsByName(fieldname)[0].focus();
                // name이 fieldname값인 노드를 찾아서 마우스 깜빡깜빡
            }
            break; // switch문 탈출
        case 'radio':  // fieldtype 이 radio 이면 ~
            if(document.querySelector('input[name="'+fieldname+'"]:checked') != null){
            // name이 fieldname값인 노드에 null이 아니라면 즉, 한개라도 체크가 되어있다면
                val = document.querySelector('input[name="'+fieldname+'"]:checked').value;
                // 체크되어있는 그 값을 변수 val에 저장
            }
            if(val == ''){
            // 변수 val이 공백 즉, 아무것도 체크가 되어있지 않다면
                alert(label+' 를 선택해 주십시오.');
                // 브라우저 알림을 출력
                // ex) 중요도를 선택해주십시오
            }
            break; // switch문 탈출
    }
    return val;  // 변수 val값을 반환
}

//프로토타입으로 숫자 메써드로 구현

Number.prototype.fillZero = function(width){
// Number 객체의 상속을 받아 fillZero 의 함수를 생성하는데 가로값을 매개변수로 받겠다
    let n = String(this);//문자열 변환
    // n이라는 지역변수에다가 문자열로 반환한 this값을 대입한다
    return n.length >= width ? n:new Array(width-n.length+1).join('0')+n;//남는 길이만큼 0으로 채움
    // 반환하는데 삼항연산자의 조건식 부여됨
    // n의 개수보다 width 이상이면 n을 출력하고 Array(계산값)
    // 생성한 배열의 각 요소를 0을 추가해서 문자열로 결합
    // 배열로 만들었으니 join을 쓸 수 있음
}
// 005


// 특이사항
// 1. todo, data, priority, moveitem을 item이라는 class로 묶고
//    그 묶은 것을 id가 newitem이라는 script로 묶어버린 점
//    전체적으로 지휘하기 편해보이는 느낌


// 질문
// 1. script type="template" 이란 대체 뭘까?
// 반복적인 HTML 태그 부분을 template로 만들어두고
// 서버에서 온 데이터와 결합하여 화면에 추가하는 작업이라고 한다



// 번외. 개선사항
// 중요도를 입력받았으나 중요도를 활용하지 않았다는 느낌이 들었다
// 만약 개선한다면 중요도가 높은 순으로 나열하는 것이 좋지 않았을까