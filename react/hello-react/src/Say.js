import React, { useState } from 'react';

const Say = () => {
  const [message, setMessage] = useState('');
  // 초기값, Ctrl + Space 로 위에 import 선언
  // setMessage : setter를 이용하여 선언하겠다.
  const onClickEnter = () => setMessage('Hello~');
  const onClickLeave = () => setMessage('~bye bye');
  const [color, setColor] = useState('black');
  return (
    <div>
      <button onClick={onClickEnter}>입장</button>
      <button onClick={onClickLeave}>퇴장</button>
      <h1 style={{ color }}>{message}</h1>
      <button style={{ color: 'red' }} onClick={() => setColor('red')}>
        red
      </button>
      <button style={{ color: 'green' }} onClick={() => setColor('green')}>
        green
      </button>
      <button style={{ color: 'blue' }} onClick={() => setColor('blue')}>
        blue
      </button>
    </div>
  );
};

export default Say;
