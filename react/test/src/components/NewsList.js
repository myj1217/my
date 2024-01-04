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

const NewsList = () => {
  const [articles, setArticles] = useState(null);
  //   const [images, setImages] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    // 시작하거나 업데이트할 때 쓰는 훅
    // async를 사용하는 함수 따로 선언
    const fetchData = async () => {
      // 페이지가 불러와질 때 비동기로 받야아한다.
      setLoading(true);
      try {
        const response = await axios.get(
          "http://data4library.kr/api/libSrchByBook?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&isbn=9788959897179&region=11&dtl_region=11080&format=json"
        );
        setArticles(response.data.articles);
        console.log(articles);
        // 받아온 데이터를 업데이트하라
        // const responses = await axios.get(
        //   "http://data4library.kr/api/usageAnalysisList?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&isbn13=9788952782069&format=json"
        // );
        // setImages(responses.data.images);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  //   useEffect(() => {
  //     // 시작하거나 업데이트할 때 쓰는 훅
  //     // async를 사용하는 함수 따로 선언
  //     const fetchDatas = async () => {
  //       // 페이지가 불러와질 때 비동기로 받야아한다.
  //       setLoading(true);
  //       try {
  //         const responses = await axios.get(
  //           "http://data4library.kr/api/srchDtlList?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&isbn13=9788959897179&format=json"
  //         );
  //         setImages(responses.data.images);
  //         console.log(images);
  //       } catch (e) {
  //         console.log(e);
  //       }
  //       setLoading(false);
  //     };
  //     fetchDatas();
  //   }, []);

  // 대기중일 때
  if (loading) {
    return <NewsListBlock>대기중...</NewsListBlock>;
  }
  if (!articles) {
    return null;
  }

  //   if (!images) {
  //     return null;
  //   }
  // articles 값이 유효할 때

  return (
    <NewsListBlock>
      {articles.map((article) => (
        <NewsItem key={article.homepage} article={article} />
      ))}
    </NewsListBlock>
  );
};
export default NewsList;
