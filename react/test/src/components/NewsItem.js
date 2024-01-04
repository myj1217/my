import React from "react";
import styled from "styled-components";

const NewsItemBlock = styled.div`
  display: flex;

  .thumbnail {
    margin-right: 1rem;
    img {
      display: block;
      width: 160px;
      height: 100px;
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
  const { libName, address, homepage } = article;
  //   const { bookImageURL } = image;
  //   이미지가 가장 마지막에 불러와질 가능성 농후
  return (
    <NewsItemBlock>
      {/* NewsItemBlock이 div 태그가 됨 = 부모가 됨 */}
      <div className="thumbnail">
        <a href={homepage} target="_blank" rel="noopener noreferrer">
          {/* _blank : 새 창으로 열기 */}
          {/* noopener :  */}
          {/* noreferrer : 내 정보가 타사이트에도 전달 */}
        </a>
      </div>

      <div className="contents">
        <h2>
          <a href={homepage} target="_blank" rel="noopener noreferrer">
            {libName}
          </a>
        </h2>
        <p>{address}</p>
      </div>
    </NewsItemBlock>
  );
};

export default NewsItem;
