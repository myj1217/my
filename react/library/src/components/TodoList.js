import TodoListItem from "./TodoListItem";
import "./TodoList.scss";

const TodoList = ({ todos }) => {
  return (
    <div className="TodoList">
      {todos.map((todo) => (
        <TodoListItem todo={todo} key={todo.id} />
        // 반복되는 값들은 인덱스로 인지시키면 안된다. - 키로 받음
      ))}
    </div>
  );
};

export default TodoList;
