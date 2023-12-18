document.addEventListener('DOMContentLoaded', function(){
    //폼 버튼 이벤트 리스너 추가  
    document.getElementsByName('reset')[0].addEventListener('click', function(){resetForm();}); // 리셋
    // name이 reset인 즉, '내용 지우기' 버튼에 클릭이 발생하면 아래 있는 resetForm() 함수 수행
    document.getElementsByName('save')[0].addEventListener('click', function(){saveItem();}); // 저장
    // name이 save인 즉, '등록' 버튼에 클릭이 발생하면 바로 아래 있는 saveItem() 함수 수행
}); 


/* 할일 저장 */
function saveItem(){
    if(validateItemForm()){ // 폼 필드 체크 완료되었으면
        let form = document.getElementById('newitem');
        // id가 newitem인 즉, 할일 폼 안에 작성한 내용을 변수 form에 저장
        let elem = document.createElement('div');
        // <div> 태그를 추가하기 위한 변수 elem
        elem.innerHTML = form.text.trim();
        // <div> 태그 안에 텍스트 내용 집어넣음
        elem.firstChild.classList.add('newitem');
        // elem 으로 만들어지는 <div> 태그의 클래스명 'newitem' 추가
        document.querySelector('.todo .content').append(elem.firstChild);
        // 클래스명이 todo인 모든 하위 중 클래스명이 content 인 것에 elem의 내용 추가 

        let date = new Date();  // 현재 날짜를 변수 date에 저장

        document.querySelector('.newitem .todo').textContent = document.getElementsByName('todo')[0].value;
        // 
        document.querySelector('.newitem .date').textContent = 
            date.getFullYear() + '-' + (date.getUTCMonth() + 1).fillZero(2) + '-' + date.getDate().fillZero(2) + ', ';
        document.querySelector('.newitem .priority').textContent = 
            '중요도 ' + document.querySelector('input[name="priority"]:checked').value;
        document.querySelector('.newitem .moveitem').addEventListener('click',function(e){
            moveItem(e.target);
        });

        document.querySelector('.newitem').classList.remove('newitem');

        resetForm(); // 할일 목록에 등록 후 폼 초기화
    }
}

/* 진행단계 이동 */
function moveItem(elem){
    let section = elem.parentNode.parentNode.parentNode;
    // elem의 현재 위치는 section - div(todo) - div(content) - elem
    // 따라서, 부모의 부모의 부모는 section의 내용을 변수 section에 저장
    let item = elem.parentNode;
    // elem의 부모 즉, div(content)의 내용을 변수 item에 저장
    if(section.classList.contains('doing')){
    // section의 클래스 중에 doing 이 포함되어 있다면 ~
        elem.remove();  // elem을 제거하라
    }
    let ditem = item.parentNode.removeChild(item);
    // ?
    document.querySelector('.'+section.nextElementSibling.className+' .content').append(ditem);
    // nextElementSibling : 형제 모두
    // section의 모든 자식들의 모든 하위에 있는 content에게 적용하라
    // 무엇을? ditem을 추가하라
}

/* 양식 초기화 */
function resetForm(){
    document.getElementsByName('todo')[0].value = '';
    let radios = document.getElementsByName('priority');
    radios.forEach(function(radio){
        radio.checked = false;
    });
}

/* 폼 입력 체크 */
function validateItemForm(){
    let todo = validateItemField('todo','할일','input');
    let priority = validateItemField('priority','중요도','radio');
    if(todo == '' || priority == ''){
        return false;
    }else{
        return true;
    }
}

/* 개별 필드 입력 체크 */
function validateItemField(fieldname, label, fieldtype){
    let val = '';
    switch(fieldtype){
        case 'input':
            val = document.getElementsByName(fieldname)[0].value;
            if(val == ''){
                alert(label+' 을/를 입력해 주십시오.');
                document.getElementsByName(fieldname)[0].focus();
            }
            break;
        case 'radio':
            if(document.querySelector('input[name="'+fieldname+'"]:checked') != null){
                val = document.querySelector('input[name="'+fieldname+'"]:checked').value;
            }
            if(val == ''){
                alert(label+' 를 선택해 주십시오.');
            }
            break;
    }
    return val;
}

//프로토타입으로 숫자 메써드로 구현
Number.prototype.fillZero = function(width){
    let n = String(this);//문자열 변환
    return n.length >= width ? n:new Array(width-n.length+1).join('0')+n;//남는 길이만큼 0으로 채움
}


// 특이사항
// 1. todo, data, priority, moveitem을 item이라는 class로 묶고
//    그 묶은 것을 id가 newitem이라는 script로 묶어버린 점
//    전체적으로 지휘하기 편해보이는 느낌