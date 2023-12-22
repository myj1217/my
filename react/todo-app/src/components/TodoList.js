import TodoListItem from './TodoListItem';
import './TodoList.scss';

// TodoList는 그저 TodoListItem들을 보여주기 위한 공간일 뿐이다.
// 통으로 전달할 때는 todos로 받음
const TodoList = ({ todos, onRemove, onToggle }) => {
  return (
    <div className="TodoList">
      {/* 요소 하나하나는 todo로 받음 */}
      {todos.map((todo) => (
        <TodoListItem
          todo={todo}
          key={todo.id}
          onRemove={onRemove}
          onToggle={onToggle}
        />
        // 반복되는 값들은 인덱스로 인지시키면 안된다. - 키로 받음
      ))}
    </div>
  );
};

export default TodoList;
