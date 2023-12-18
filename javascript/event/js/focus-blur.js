function checkUsername() {
    let username = el.value;
    if (username.length < 5) {
        elMsg.className = 'warning';
        elMsg.textContent = '이름이 너무 짧습니다';
    } else {
        elMsg.textContent = '';
    }
}
function tipUsername() {
    elMsg.className = 'tip';
    elMsg.innerHTML = '이름은 다섯 글자 이상이어야 합니다';
}
let el = document.getElementById('username');
let elMsg = document.getElementById('feedback');

el.addEventListener('focus', tipUsername, false);
el.addEventListener('blur', checkUsername, false);