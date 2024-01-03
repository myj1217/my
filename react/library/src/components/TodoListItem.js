import { MdLocationPin, MdPhone } from "react-icons/md";
import cn from "classnames";

const TodoListItem = ({ todo }) => {
  const { title, address, tel, checked } = todo;
  return (
    <div className="TodoListItem">
      <div className={cn("checkbox", { checked })}>
        <div className="text">
          {title}
          <MdLocationPin />
          <br />
          {address}
          <br />
          <MdPhone />
          {tel}
          <br />
          {checked
            ? "현재 해당 도서를 보유하고 있습니다."
            : "현재 해당 도서를 보유하고 있지 않습니다."}
        </div>
      </div>
      <div className="remove"></div>
    </div>
  );
};

export default TodoListItem;
