import TodoListItem from "./TodoListItem";
import "./TodoList.scss";

const TodoList = ({ libs }) => {
  return (
    <div className="TodoList">
      {libs.map((lib) => (
        <TodoListItem lib={lib} key={lib.id} />
      ))}
    </div>
  );
};

export default TodoList;
