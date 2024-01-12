import React, { useCallback, useState } from "react";
import Categories from "../components/Categories";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import BookData from "../components/BookData";

const BookPageBlock = styled.div`
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

const BookPage = () => {
  const params = useParams();
  const category = params.category || "srchBooks";

  const [srchValue, setSrchValue] = useState("");

  const onChange = useCallback((e) => {
    setSrchValue(e.target.value);
  }, []);

  const onClick = useCallback((e) => {
    setSrchValue("");
  }, []);

  const onSubmit = useCallback(
    (e) => {
      setSrchValue(srchValue);
      e.preventDefault();
    },
    [srchValue]
  );

  return (
    <>
      <Categories />
      <BookPageBlock>
        <form
          className={category === "srchBooks" ? "searchbar" : "nosearchbar"}
          onSubmit={onSubmit}
        >
          <input
            value={srchValue}
            placeholder="책제목을 입력하세요."
            onChange={onChange}
          />
          <button type="submit" onClick={onClick}>
            초기화
          </button>
        </form>
      </BookPageBlock>
      <BookData category={category} srchValue={srchValue} />
    </>
  );
};

export default BookPage;
