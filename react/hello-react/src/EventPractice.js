// 함수형

import React, { useState } from 'react';

const EventPractice = () => {
  const [username, setUsername] = useState('');
  // useState라는 hook을 사용한다.
  // 2번째임을 알려주기 위해 set을 사용한다.
  const [message, setMessage] = useState('');
  const onChangeUsername = (e) => setUsername(e.target.value);
  // 값을 입력할 때마다 setter가 움직여라.
  const onChangeMessage = (e) => setMessage(e.target.value);

  const onClick = () => {
    alert(username + ': ' + message);
    setUsername('');
    setMessage('');
  };
  const onKeyPress = (e) => {
    if (e.key === 'Enter') {
      onClick();
    }
  };
  return (
    <div>
      <h1>이벤트 연습</h1>
      <input
        type="text"
        name="username"
        placeholder="유저명"
        value={username}
        onChange={onChangeUsername}
      />
      <input
        type="text"
        name="message"
        placeholder="아무거나 입력해보세요"
        value={message}
        onChange={onChangeMessage}
        onKeyPress={onKeyPress}
      />
      <button onClick={onClick}>확인</button>
    </div>
  );
};

export default EventPractice;
