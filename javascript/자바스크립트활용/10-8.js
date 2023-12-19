document.addEventListener('DOMContentLoaded', function(){ 
// DOM 내용만 읽고 시작
	document.querySelector(".mobile-menu").addEventListener("click", function(e){
		// 처음 선택된 class 명이 mobile-menu 인 것에 대해 click 이벤트가 발생하면 매개변수 e를 받는 함수를 실행
		if ( document.querySelector('.menuwrap').classList.contains('on') ){
		// document 내에 'menuwrap'이라는 이름을 가진 클래스를 갖고 있다면 ~
		// 즉, 메뉴가 열려있다면 ~ (-> 메뉴를 닫는다)
		    //메뉴닫힘
			document.querySelector('.menuwrap').classList.remove('on');
			// 클래스명이 menuwrap 인 노드의 클래스 중 on 클래스 삭제
			document.querySelector('.mobile-menu i').classList.remove('fa-times');
			// 클래스명이 menuwrap 인 노드의 모든 하위에 있는 i에 대해 fa-times 클래스 삭제
			document.querySelector('.mobile-menu i').classList.add('fa-bars');
			// 클래스명이 menuwrap 인 노드의 모든 하위에 있는 i에 대해 fa-bars 클래스 추가
			// 즉, fa-times 자리에 fa-bars가 온다는 느낌

		    //페이지 스크롤 락 해제
		    document.querySelector('#dimmed').remove();
			// id가 dimmed 인 노드 삭제


		} else {
		// 그렇지 않다면 ~ 즉, 메뉴가 닫혀있다면 ~ (-> 메뉴를 연다)
		    //메뉴펼침
			document.querySelector('.menuwrap').classList.add('on');
			// 클래스명이 menuwrap 인 노드의 클래스 중에 on 클래스 추가
			document.querySelector('.mobile-menu i').classList.remove('fa-bars');
			// 클래스명이 menuwrap 인 노드의 모든 하위에 있는 i에 대해 fa-bars 클래스 삭제
			document.querySelector('.mobile-menu i').classList.add('fa-times');
			// 클래스명이 menuwrap 인 노드의 모든 하위에 있는 i에 대해 fa-times 클래스 추가
			// 즉, fa-bars 자리에 fa-times가 온다는 느낌

		    //페이지 스크롤 락 레이어 추가
		    let div = document.createElement('div');  // div 태그를 넣기 위한 변수 div 선언
		    div.id = 'dimmed'; // 변수 div 의 id 를 'dimmed'로 함 (속성 추가 개념)
		    document.body.append(div); // body안에 바로 위에서 선언한 div를 추가한다

		    //페이지 스크롤 락  모바일 이벤트 차단
		    document.querySelector('#dimmed').addEventListener('scroll touchmove touchend mousewheel', function(e){
			// scroll : 스크롤바를 드래그하거나 키보드(up, down)를 사용하거나 마우스 휠을 사용해서 웹페이지를 스크롤할 때 발생
			// touchmove : 디바이스 화면에 손가락이 닿은 상태에서 손가락을 움직이면 발생하는 이벤트
			// touchend : 디바이스 화면에 손가락이 닿은 상태에서 손가락을 떼어내면 발생하는 이벤트
			// mousewheel
			// 처음 발견한 id명이 dimmed인 노드를 대상으로 나열된 4가지 이벤트가 발생하면 함수를 실행하라
				e.preventDefault();  // 모든 기본 동작을 취소시킴
				e.stopPropagation();  // 버블링 또는 캡쳐링 취소시킴
				return false;  // false를 반환
		    });     
		}
	});	
})

// 메뉴 버튼을 클릭하게 되면 일어나는 변화
// 1. class 명이 'menuwrap' 인 div 태그의 class 명이 'menuwrap on' 으로 변경된다
// 2. id 가 'dimmed' 인 div 태그가 body에 추가된다
// 3. 버튼의 i태그?가 fas fa-bars 가 fas fa-times 로 변경된다

// on 이라는 것이 메뉴가 꺼져있는지 켜져있는지 구분하는 수단으로 쓰임


// 질문
// 1. 여기서 말하는 페이지 스크롤 락의 의미를 모르겠다.

// 페이지 스크롤 락에 대한 내 생각은 메뉴가 꺼내져있을 때 스크롤 기능을 억제한다는 뜻으로 받아들여서
// height: 8000px 를 주었더니 스크롤 기능은 정상적으로 작동이 되었다.
// 페이지 스크롤 락이라는게 스크롤에 상관없이 저 메뉴가 보인다는 뜻으로 해석하면 되는지 궁금하다.

