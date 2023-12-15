function checkUsername() {
    let elMsg = document.getElementById('feedback');
    if (elUsername.value.length < 5) {
        elMsg.textContent = '이름은 다섯글자 이상으로 입력하세요.';
    } else {
        elMsg.textContent = '';
    }
}
let elUsername = document.getElementById('username');

elUsername.addEventListener('blur', checkUsername, false);
// 1. 이벤트 종류  2. 함수 이름  3. 이벤트 흐름 
// blur : focus가 벗어났을 때