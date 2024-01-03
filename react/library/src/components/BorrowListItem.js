import cn from "classnames";

const BorrowListItem = ({ machine }) => {
  const { title, checked } = machine;
  return (
    <div className="BorrowListItem">
      <div className={cn("checkbox", { checked })}>
        <div className="text">{title}</div>
        <div className="state">{checked ? "예약가능" : "예약불가"}</div>
      </div>
    </div>
  );
};

export default BorrowListItem;
