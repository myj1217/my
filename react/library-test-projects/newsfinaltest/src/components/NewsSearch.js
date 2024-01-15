import React, { useCallback, useState } from "react";
import NewsList from "./NewsList";
import styled from "styled-components";
import BlktList from "./BlktList";

const NewsSearchBlock = styled.div`
  .noshow {
    display: none;
  }
`;

const NewsSearch = ({ category, books }) => {
  const [blkts, setBlkts] = useState([]);
  const clones = books;

  const onInsert = useCallback(
    (isbn13) => {
      const addBlkts = clones.filter((clone) => clone.doc.isbn13 === isbn13);
      setBlkts(blkts.concat(addBlkts));
      console.log(blkts);
    },
    [blkts, clones]
  );

  const onRemove = useCallback(
    (isbn13) => {
      setBlkts(blkts.filter((blkt) => blkt.doc.isbn13 !== isbn13));
      console.log(blkts);
    },
    [blkts]
  );

  return (
    <NewsSearchBlock>
      <div className={category !== "bookBlkt" ? "show" : "noshow"}>
        <NewsList category={category} books={books} onInsert={onInsert} />
      </div>
      <div className={category === "bookBlkt" ? "show" : "noshow"}>
        <BlktList category={category} blkts={blkts} onRemove={onRemove} />
      </div>
    </NewsSearchBlock>
  );
};

export default NewsSearch;
