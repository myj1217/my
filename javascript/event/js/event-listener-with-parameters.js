let elUsername = document.getElementById('username');
let elMsg = document.getElementById('feedback');

function checkUsername(minLength) {
    if (elUsername.value.length < minLength) {
        elMsg.innerHTML = '이름은 ' + minLength + ' 글자 이상이어야 합니다';
    } else {
        elMsg.innerHTML = '';
    }
}

elUsername.addEventListener('blur', function() {
    checkUsername(5);
}, false);