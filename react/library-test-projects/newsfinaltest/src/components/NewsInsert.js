import styled from "styled-components";
import { useEffect, useState } from "react";
import axios from "axios";
import NewsSearch from "./NewsSearch";

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

const NewsInsert = ({ category, search }) => {
  const [books, setBooks] = useState("");
  const [loading, setLoading] = useState(false);

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

  return <NewsSearch category={category} books={books} />;
};

export default NewsInsert;
