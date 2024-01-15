import React, { useCallback, useState } from "react";
import Categories from "../components/Categories";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import NewsInsert from "../components/NewsInsert";

const NewsInsertBlock = styled.div`
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

const NewsPage = () => {
  const params = useParams();
  const category = params.category || "srchBooks";
  const [search, setSearch] = useState("");

  const onChange = useCallback((e) => {
    setSearch(e.target.value);
  }, []);

  const onSubmit = useCallback(
    (e) => {
      setSearch(search);
      e.preventDefault();
    },
    [search]
  );

  return (
    <>
      <Categories />
      <NewsInsertBlock>
        <form
          className={category === "srchBooks" ? "searchbar" : "nosearchbar"}
          onSubmit={onSubmit}
        >
          <input
            value={search}
            placeholder="책제목을 입력하세요."
            onChange={onChange}
          />
          <button type="submit">검색</button>
        </form>
      </NewsInsertBlock>
      <NewsInsert category={category} search={search} />
    </>
  );
};

export default NewsPage;
