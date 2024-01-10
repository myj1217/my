import React, { useCallback, useState } from "react";
import styled from "styled-components";
import BookList from "./BookList";
import BasketList from "./BasketList";

const BookSearchBlock = styled.div`
  .noshow {
    display: none;
  }
`;

const BookSetting = ({ category, books }) => {
  const [baskets, setBaskets] = useState([]);
  const clones = books;

  const onInsert = useCallback(
    (isbn13) => {
      const addBaskets = clones.filter((clone) => clone.doc.isbn13 === isbn13);
      setBaskets(baskets.concat(addBaskets));
      alert("해당 도서가 북카트에 추가되었습니다.");
    },
    [baskets, clones]
  );

  const onRemove = useCallback(
    (isbn13) => {
      setBaskets(baskets.filter((basket) => basket.doc.isbn13 !== isbn13));
    },
    [baskets]
  );

  const onBorrow = useCallback((isbn13) => {
    setBaskets((baskets) =>
      baskets.filter((basket) => basket.doc.isbn13 !== isbn13)
    );
    alert("해당 도서의 대출신청이 완료되었습니다.");
  }, []);

  return (
    <BookSearchBlock>
      <div className={category !== "bookBskt" ? "show" : "noshow"}>
        <BookList category={category} books={books} onInsert={onInsert} />
      </div>
      <div className={category === "bookBskt" ? "show" : "noshow"}>
        <BasketList
          category={category}
          baskets={baskets}
          onRemove={onRemove}
          onBorrow={onBorrow}
        />
      </div>
    </BookSearchBlock>
  );
};

export default BookSetting;
