import "./BorrowTemplate.scss";

const BorrowTemplate = ({ children }) => {
  return (
    <div className="TodoTemplate">
      <div className="app-title">무인대출기 현황</div>
      <div className="content">{children}</div>
    </div>
  );
};

export default BorrowTemplate;
