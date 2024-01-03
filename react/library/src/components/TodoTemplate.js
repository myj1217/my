import "./TodoTemplate.scss";

const TodoTemplate = ({ children }) => {
  return (
    <div className="TodoTemplate">
      <div className="app-title">도서관 목록</div>
      <div className="content">{children}</div>
    </div>
  );
};

export default TodoTemplate;
