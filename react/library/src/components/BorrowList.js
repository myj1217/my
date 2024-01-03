import BorrowListItem from "./BorrowListItem";
import "./BorrowList.scss";

const BorrowList = ({ machines }) => {
  return (
    <div className="BorrowList">
      {machines.map((machine) => (
        <BorrowListItem machine={machine} key={machine.id} />
      ))}
    </div>
  );
};

export default BorrowList;
