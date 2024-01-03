import { MdLocationPin, MdPhone } from "react-icons/md";
import cn from "classnames";

const BorrowListItem = ({ machine }) => {
  const { title, address, tel, checked } = machine;
  return (
    <div className="BorrowListItem">
      <div className={cn("checkbox", { checked })}>
        <div className="text">
          {title}
          <MdLocationPin />
          <br />
          {address}
          <br />
          <MdPhone />
          {tel}
        </div>
      </div>
      <div className="remove"></div>
    </div>
  );
};

export default BorrowListItem;
