import TodoListItem from './TodoListItem';
import './TodoList.scss';
import React, { useCallback } from 'react';
import { List } from 'react-virtualized';

// TodoList는 그저 TodoListItem들을 보여주기 위한 공간일 뿐이다.
// 통으로 전달할 때는 todos로 받음
const TodoList = ({ todos, onRemove, onToggle }) => {
  const rowRenderer = useCallback(
    ({ index, key, style }) => {
      const todo = todos[index];
      return (
        <TodoListItem
          todo={todo}
          key={key}
          onRemove={onRemove}
          onToggle={onToggle}
          style={style}
        />
      );
    },
    [onRemove, onToggle, todos],
  );
  return (
    <List
      className="TodoList"
      width={512} // 전체 너비
      height={513} // 전체 높이
      rowCount={todos.length} // 항목 개수
      rowHeight={57} // 항목 높이
      rowRenderer={rowRenderer} // 항목을 렌더링할 때 쓰는 함수
      List={todos} // 배열 객체
      style={{ outLine: 'none' }} // List 컴포넌트에 기본적으로 적용되는 outline 스타일 제거
    />
  );
};

export default React.memo(TodoList);
