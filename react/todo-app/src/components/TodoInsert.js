import { MdAdd } from 'react-icons/md';
import './TodoInsert.scss';
import { useCallback, useState } from 'react';

// 입력을 할 때 입력을 강제로 할때 = event
const TodoInsert = ({ onInsert }) => {
  const [value, setValue] = useState('');
  // 초기값은 비어져있는 공백
  const onChange = useCallback((e) => {
    setValue(e.target.value);
    // 재사용하기 때문에 callback 함수로 감쌌음
    // 같은 내용 리렌더링 하지 않음 -> 엄청난 최적화로 이어짐
  }, []);
  const onSubmit = useCallback(
    (e) => {
      onInsert(value);
      setValue(''); // value를 받고 초기화
      e.preventDefault();
      // 기본동작 취소
      // 원래 초기화하는 기능이 있는데
      // 기능을 그대로두면 우리가 입력한 값이
      // 등록이 안되고 초기화가 되므로
      // 억제시켜놔야함
    },
    [onInsert, value],
    // 변경이 있으면 다시 읽어들여라
  );
  return (
    // input과 button을 제대로 쓰기 위해서는 form으로 감싸야 한다.
    // 전송하는 기능만 있을뿐 실제 일은 form이 다 한다.
    <form className="TodoInsert" onSubmit={onSubmit}>
      {/* onSubmit 자체에 enter키를 인식하는 기능이 있다 */}
      {/* 즉, keydown 귀찮게 안써도 된다. */}
      <input
        placeholder="할 일을 입력하세요"
        value={value}
        onChange={onChange}
      />
      <button type="submit">
        <MdAdd />
      </button>
    </form>
  );
};

export default TodoInsert;
