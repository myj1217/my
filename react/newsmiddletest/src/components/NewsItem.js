import React from "react";
import styled from "styled-components";

const NewsItemBlock = styled.div`
  display: flex;

  .thumbnail {
    margin-right: 1rem;
    img {
      display: block;
      width: 120px;
      height: 160px;
      object-fit: cover;
    }
  }
  .contents {
    h2 {
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
  }
  & + & {
    margin-top: 3rem;
  }
`;

const NewsItem = ({ article }) => {
  const {
    bookname,
    authors,
    bookDtlUrl,
    bookImageURL,
    publisher,
    isbn13,
    publication_year,
  } = article.doc;
  //   이미지가 가장 마지막에 불러와질 가능성 농후
  return (
    <NewsItemBlock>
      {/* NewsItemBlock이 div 태그가 됨 = 부모가 됨 */}
      {bookImageURL && (
        // 그래서 이미지가 기준이 됨. 이미지가 불려왔다면 ~
        <div className="thumbnail">
          <a href={bookDtlUrl} target="_blank" rel="noopener noreferrer">
            {/* _blank : 새 창으로 열기 */}
            {/* noopener :  */}
            {/* noreferrer : 내 정보가 타사이트에도 전달 */}
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
        <p>출판사: {publisher}</p>
        <p>출판연월: {publication_year}</p>
        <p>ISBN: {isbn13}</p>
      </div>
    </NewsItemBlock>
  );
};

export default NewsItem;
