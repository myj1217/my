import { useEffect, useState } from "react";
import NewsItem from "./NewsItem";
import styled from "styled-components";
import axios from "../../node_modules/axios/index";

//div의 스타일 주기 1 rem 16px
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
`;

const NewsList = ({ search }) => {
  const [articles, setArticles] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    // 시작하거나 업데이트할 때 쓰는 훅
    // async를 사용하는 함수 따로 선언
    const fetchData = async () => {
      // 페이지가 불러와질 때 비동기로 받야아한다.
      setLoading(true);
      try {
        // const query = search === "" ? "날씨가" : search;
        const response = await axios.get(
          `http://data4library.kr/api/srchBooks?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&title=${search}&exactMatch=true&pageNo=1&pageSize=10&format=json`
        );
        setArticles(response.data.response.docs);
        // 받아온 데이터를 업데이트하라
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fetchData();
  }, [search]);

  if (loading) {
    return <NewsListBlock>대기중...</NewsListBlock>;
  }
  if (!articles) {
    return null;
  }
  return (
    <NewsListBlock>
      {articles.map((article) => (
        <NewsItem key={article.doc.bookDtlUrl} article={article} />
      ))}
    </NewsListBlock>
  );
};
export default NewsList;
