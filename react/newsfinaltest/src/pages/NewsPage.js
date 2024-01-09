import React, { useEffect, useState } from "react";
import Categories from "../components/Categories";
import { useParams } from "react-router-dom";
import NewsSearch from "../components/NewsSearch";
import axios from "axios";
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

const NewsListBlock = styled.div`
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

const NewsPage = () => {
  const params = useParams();
  const category = params.category || "srchBooks";

  const [books, setBooks] = useState("");
  const [loading, setLoading] = useState(false);
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

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        if (category === "srchBooks") {
          const response = await axios.get(
            `http://data4library.kr/api/${category}?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&title=${search}&exactMatch=true&pageNo=1&pageSize=10&format=json`
          );
          setBooks(response.data.response.docs);
        }
        if (category === "hotTrend") {
          const date = new Date();
          const yd = new Date(date.setDate(date.getDate() - 1));
          const mm =
            yd.getMonth() + 1 < 10
              ? `0${yd.getMonth() + 1}`
              : yd.getMonth() + 1;
          const dd = yd.getDate() < 10 ? `0${yd.getDate()}` : yd.getDate();
          const dateConvert = `${yd.getFullYear()}-${mm}-${dd}`;
          const response = await axios.get(
            `http://data4library.kr/api/${category}?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&searchDt=${dateConvert}&format=json`
          );
          setBooks(response.data.response.results[0].result.docs);
        }
        if (category === "libSrch") {
          const response = await axios.get(
            `http://data4library.kr/api/extends/${category}?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&format=json`
          );
          setBooks(response.data.response.libs);
          // console.log(response.data.response.libs[9].lib.newBooks);
        }
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fetchData();
  }, [search, category]);

  if (loading) {
    return <NewsListBlock>대기중...</NewsListBlock>;
  }
  if (!books) {
    return null;
  }

  return (
    <>
      <Categories />
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
      <NewsSearch category={category} books={books} />
    </>
  );
};

export default NewsPage;
