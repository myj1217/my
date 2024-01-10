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
      console.log(baskets);
    },
    [baskets, clones]
  );

  const onRemove = useCallback(
    (isbn13) => {
      setBaskets(baskets.filter((basket) => basket.doc.isbn13 !== isbn13));
      console.log(baskets);
    },
    [baskets]
  );

  return (
    <BookSearchBlock>
      <div className={category !== "bookBskt" ? "show" : "noshow"}>
        <BookList category={category} books={books} onInsert={onInsert} />
      </div>
      <div className={category === "bookBskt" ? "show" : "noshow"}>
        <BasketList category={category} baskets={baskets} onRemove={onRemove} />
      </div>
    </BookSearchBlock>
  );
};

export default BookSetting;
