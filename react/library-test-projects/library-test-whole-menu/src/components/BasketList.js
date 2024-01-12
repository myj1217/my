import BasketItem from "./BasketItem";
import styled from "styled-components";

const BasketListBlock = styled.div`
  box-sizing: border-box;
  padding-bottom: 3rem;
  width: 768px;
  margin: 0 auto;
  margin-top: 2rem;
  .title {
    .checkbox {
      display: flex;
      padding-top: 2rem;
      padding-bottom: 2rem;
      .chad {
        padding: 0 20px;
        cursor: pointer;
        display: flex;
        align-items: center;
        justify-content: center;
        svg {
          font-size: 1.5rem;
        }
      }
      &.checked {
        svg {
          color: #0877e7;
        }
      }
    }
    button {
      margin-right: 10px;
      padding: 5px 10px;
      margin-top: 0.5rem;
      white-space: normal;
      color: black;
    }
  }
  @media screen and (max-width: 768px) {
    width: 100%;
    padding-left: 1rem;
    padding-right: 1rem;
  }
  .nolist {
    display: none;
  }
`;

const BasketList = ({
  category,
  baskets,
  onRemove,
  onBorrow,
  onToggle,
  onBorrowChecked,
  onRemoveChecked,
  onToggleAll,
}) => {
  return (
    <BasketListBlock>
      <div className="title">
        <div className={cn("checkbox", { checked })}>
          <div className="chad" onClick={() => onToggleAll(checked)}>
            {checked ? (
              <MdOutlineCheckBox />
            ) : (
              <MdOutlineCheckBoxOutlineBlank />
            )}
          </div>
        </div>
        <button onClick={() => onBorrowChecked(checked)}>대출신청</button>
        <button onClick={() => onRemoveChecked(checked)}>삭제</button>
      </div>
      {baskets.map((basket) => (
        <BasketItem
          basket={basket}
          key={basket.doc.isbn13}
          onRemove={onRemove}
          onBorrow={onBorrow}
          onToggle={onToggle}
        />
      ))}
    </BasketListBlock>
  );
};
export default BasketList;
