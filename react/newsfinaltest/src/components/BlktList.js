import NewsItem from "./NewsItem";
import styled from "styled-components";

const BlktsListBlock = styled.div`
  box-sizing: border-box;
  padding-bottom: 3rem;
  width: 768px;
  margin: 0 auto;
  margin-top: 2rem;
  @media screen and (max-width: 768px) {
    width: 100%;
    padding-left: 1rem;
    padding-right: 1rem;
  }
  .nolist {
    display: none;
  }
`;

const BlktList = ({ category, blkts, onInsert }) => {
  return (
    <BlktsListBlock>
      {blkts.map((blkt, index) => (
        <NewsItem
          book={blkt}
          key={blkt.doc.isbn13}
          onInsert={onInsert}
          index={index}
        />
      ))}
    </BlktsListBlock>
  );
};
export default BlktList;
