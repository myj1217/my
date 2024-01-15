import React, { useCallback, useState } from "react";
import styled from "styled-components";
import BookList from "./BookList";
import BasketList from "./BasketList";

const BookSearchBlock = styled.div`
  .noshow {
    display: none;
  }
`;

const createChecked = (value, title) => {
  console.log(title);
  const array = [];
  const range = title === "srchBooks" ? 9 : 4;
  // if (title === "srchBooks") {
  //   const range = 9;
  // } else {
  //   const range = 4;
  // }
  console.log(range);
  for (let i = 0; i <= 9; i++) {
    array.push({
      doc: {
        ...value[i].doc,
        checked: false,
      },
    });
  }
  return array;
};

const BookSetting = ({ category, books }) => {
  const [baskets, setBaskets] = useState([]);
  const [clones, setClones] = useState(createChecked(books, category));
  console.log(books);
  console.log(clones);

  const onInsert = useCallback(
    (isbn13) => {
      const addBaskets = clones.filter((clone) => clone.doc.isbn13 === isbn13);
      setBaskets((baskets) => baskets.concat(addBaskets));
      alert("해당 도서가 북카트에 추가되었습니다.");
    },
    [clones]
  );

  const onRemove = useCallback((isbn13) => {
    setBaskets((baskets) =>
      baskets.filter((basket) => basket.doc.isbn13 !== isbn13)
    );
  }, []);

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
