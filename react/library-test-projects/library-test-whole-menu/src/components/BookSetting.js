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

  const onInsert = useCallback(
    (isbn13) => {
      const addBaskets = books.filter((book) => book.doc.isbn13 === isbn13);
      setBaskets((baskets) => baskets.concat(addBaskets));
      alert("해당 도서가 북카트에 추가되었습니다.");
    },
    [books]
  );

  const onRemove = useCallback((isbn13) => {
    setBaskets((baskets) =>
      baskets.filter((basket) => basket.doc.isbn13 !== isbn13)
    );
  }, []);

  const onRemoveChecked = useCallback((checked) => {
    setBaskets((baskets) =>
      baskets.filter((basket) => basket.doc.checked === false)
    );
  }, []);

  const onBorrow = useCallback((isbn13) => {
    setBaskets((baskets) =>
      baskets.filter((basket) => basket.doc.isbn13 !== isbn13)
    );
    alert("해당 도서의 대출신청이 완료되었습니다.");
  }, []);

  const onBorrowChecked = useCallback((checked) => {
    setBaskets((baskets) =>
      baskets.filter((basket) => basket.doc.checked === false)
    );
    alert("선택하신 도서의 대출신청이 완료되었습니다.");
  }, []);

  const onToggle = useCallback(
    (isbn13) => {
      setBaskets(
        baskets.map((basket) =>
          basket.doc.isbn13 === isbn13
            ? { doc: { ...basket.doc, checked: !basket.doc.checked } }
            : basket
        )
      );
    },
    [baskets]
  );

  const onToggleAll = useCallback(
    (checked) => {
      setBaskets(
        baskets.map((basket) =>
          basket.doc.checked === false
            ? { doc: { ...basket.doc, checked: true } }
            : basket
        )
      );
    },
    [baskets]
  );

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
          onToggle={onToggle}
          onBorrowChecked={onBorrowChecked}
          onRemoveChecked={onRemoveChecked}
          onToggleAll={onToggleAll}
        />
      </div>
    </BookSearchBlock>
  );
};

export default BookSetting;
