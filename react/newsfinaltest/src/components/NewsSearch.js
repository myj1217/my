import React, { useCallback, useRef, useState } from "react";
import NewsList from "./NewsList";
import styled from "styled-components";

const NewsSearchBlock = styled.div`
  .noshow {
    display: none;
  }
`;

const NewsSearch = ({ category, books }) => {
  const [blkts, setBlkts] = useState(books);
  console.log(books);
  console.log(blkts);

  // 장바구니
  const nextId = useRef(0);
  const onInsert = useCallback(
    (books) => {
      console.log(books);
      // const blkt = books.concat("id: nextId.current");
      const blkt = {
        ...books,
        id: nextId.current,
      };
      setBlkts(blkts.concat(blkt));
      // console.log(blkts);
      nextId.current += 1;
    },
    [blkts]
  );

  return (
    <NewsSearchBlock>
      <div className={category !== "bookBlkt" ? "show" : "noshow"}>
        <NewsList category={category} books={books} onInsert={onInsert} />
      </div>
      {/* <div className={category === "bookBlkt" ? "show" : "noshow"}>
        <NewsList category={category} blkts={blkts} onInsert={onInsert} />
      </div> */}
    </NewsSearchBlock>
  );
};

export default NewsSearch;
