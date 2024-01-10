import styled from "styled-components";
import cn from "classnames";
import {
  MdOutlineCheckBoxOutlineBlank,
  MdOutlineCheckBox,
} from "react-icons/md";

const BasketItemBlock = styled.div`
  display: flex;
  padding-top: 2rem;
  padding-bottom: 2rem;
  &:nth-child(even) {
    background: #f8f9fa;
  }
  .thumbnail {
    margin-right: 1rem;
    img {
      display: block;
      width: 120px;
      height: 160px;
      object-fit: cover;
    }
  }
  .index {
    display: block;
    width: 120px;
    height: 160px;
    p {
      font-size: 48px;
      text-align: center;
    }
  }
  .contents {
    h2 {
      width: 510px;
      margin: 0;
      a {
        color: black;
      }
    }
    p {
      margin: 0;
      line-height: 1.5;
      margin-top: 0.5rem;
      white-space: normal;
    }
    button {
      margin-right: 10px;
      padding: 5px 10px;
      margin-top: 0.5rem;
      white-space: normal;
      color: black;
    }
  }
  & + & {
    border-top: 1px solid #dee2e6;
  }
`;

const BasketItem = ({ basket, onRemove, onBorrow, onToggle }) => {
  const {
    bookname,
    authors,
    bookDtlUrl,
    bookImageURL,
    publisher,
    isbn13,
    publication_year,
    checked,
  } = basket.doc;
  return (
    <BasketItemBlock>
      <div
        className={cn("checkbox", { checked })}
        onClick={() => onToggle(isbn13)}
      >
        {checked ? <MdOutlineCheckBox /> : <MdOutlineCheckBoxOutlineBlank />}
      </div>
      {bookImageURL && (
        <div className="thumbnail">
          <a href={bookDtlUrl} target="_blank" rel="noopener noreferrer">
            <img src={bookImageURL} alt="thumbnail" />
          </a>
        </div>
      )}
      <div className="contents">
        <h2>
          <a href={bookDtlUrl} target="_blank" rel="noopener noreferrer">
            {bookname}
          </a>
        </h2>
        <p>{authors}</p>
        <p>
          출판: {publisher}, {publication_year}
        </p>
        <p>ISBN: {isbn13}</p>
        <button onClick={() => onBorrow(isbn13)}>대출신청</button>
        <button onClick={() => onRemove(isbn13)}>삭제</button>
      </div>
    </BasketItemBlock>
  );
};

export default BasketItem;
