import { produce } from "immer";
import React, { useRef, useCallback, useState } from "react";

const App = () => {
  const nextId = useRef(1);
  // 1. 지역변수 <- 여기선 이거
  // 2. DOM을 가리키기 위한 hook
  const [form, setForm] = useState({ name: "", username: "" });
  const [data, setData] = useState({
    array: [],
    uselessValue: null,
  });

  // input 수정을 위한 함수
  const onChange = useCallback((e) => {
    const { name, value } = e.target;
    setForm(
      produce((draft) => {
        draft[name] = value;
      })
    ); // setForm 이 있으므로 form을 지워도 상관없다.
  }, []);

  // form 등록을 위한 함수
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      // 새로고침을 방지하는
      const info = {
        id: nextId.current,
        name: form.name,
        username: form.username,
      };
      // current 쓰는 이유 : useRef를 쓰므로

      // array 에 새 항목 등록
      setData(
        produce((draft) => {
          draft.array.push(info);
        })
        // data는 originalstate로 써도 됨 - 원래 값이니까
      );

      // form 초기화
      setForm({ name: "", username: "" });
      nextId.current += 1;
    },
    [form.name, form.username]
  );

  // 항목을 삭제하는 함수
  const onRemove = useCallback((id) => {
    setData(
      produce((draft) => {
        draft.array.splice(
          draft.array.findIndex((info) => info.id === id),
          1
        );
      })
    ); // data를 받고 draft로 넘긴다.
  }, []);

  return (
    <div>
      <form onSubmit={onSubmit}>
        <input
          name="username"
          placeholder="아이디"
          value={form.username}
          onChange={onChange}
        />
        <input
          name="name"
          placeholder="이름"
          value={form.name}
          onChange={onChange}
        />
        <button type="submit">등록</button>
      </form>
      <div>
        <ul>
          {data.array.map((info) => (
            <li key={info.id} onClick={() => onRemove(info.id)}>
              {info.username} ({info.name})
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default App;
