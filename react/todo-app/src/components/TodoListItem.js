import {
  MdCheckBoxOutlineBlank,
  MdCheckBox,
  MdRemoveCircleOutline,
} from 'react-icons/md';
import cn from 'classnames';
import './TodoListItem.scss';
import React from 'react';

const TodoListItem = ({ todo, onRemove, onToggle }) => {
  const { id, text, checked } = todo;
  return (
    <div className="TodoListItem">
      <div className={cn('checkbox', { checked })} onClick={() => onToggle(id)}>
        {/* 위에 import한 cn이란 함수의 기능 중 하나 */}
        {/* checkbox라는 클래스를 항상 추가하고,
        checked라는 값이 true일 때는 checked라는 클래스를 추가하고,
        false일 때는 해당 클래스를 제거 */}
        {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
        {/* 그리고 checked가 true면 MdCheckBox를 반환하고 */}
        <div className="text">{text}</div>
      </div>
      <div className="remove" onClick={() => onRemove(id)}>
        {/* onRemove를 쓰려면 id가 필요하다(중요) */}
        <MdRemoveCircleOutline />
      </div>
    </div>
  );
};

export default React.memo(TodoListItem);
