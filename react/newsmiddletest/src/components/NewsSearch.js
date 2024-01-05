import React, { useState } from "react";
import NewsList from "./NewsList";
import styled from "styled-components";

const NewsSearchBlock = styled.div`
  .searchbar {
    font-family: "GmarketSansMedium";
    border: 1px solid black;
    position: relative;
    max-width: 500px;
    margin: 100px auto;
    input {
      outline: 0;
      border: 0;
      display: block;
      width: 100%;
      padding: 20px;
      padding-right: 60px;
      box-sizing: border-box;
      font-weight: bold;
      font-size: 2rem;
    }
    button {
      position: absolute;
      top: 50%;
      right: 10px;
      transform: translateY(-50%);
    }
  }
  .nosearchbar {
    display: none;
  }
`;

const NewsSearch = ({ category }) => {
  const [search, setSearch] = useState("");
  const onChange = (e) => {
    setSearch(e.target.value);
  };
  const onClick = () => {
    setSearch("");
  };
  const onKeyPress = (e) => {
    if (e.key === "Enter") {
      onClick();
    }
  };
  return (
    <>
      <NewsSearchBlock>
        <div className={category === "srchBooks" ? "searchbar" : "nosearchbar"}>
          <input
            type="text"
            name="bookname"
            value={search}
            placeholder="책제목을 입력하세요."
            onChange={onChange}
            onKeyPress={onKeyPress}
          />
          <button onClick={onClick}>지우기</button>
        </div>
      </NewsSearchBlock>
      <NewsList search={search} category={category} />
    </>
  );
};

export default NewsSearch;
