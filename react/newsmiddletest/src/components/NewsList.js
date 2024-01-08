import { useEffect, useState } from "react";
import NewsItem from "./NewsItem";
import styled from "styled-components";
import axios from "../../node_modules/axios/index";

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

const NewsList = ({ search, category }) => {
  const [articles, setArticles] = useState(null);
  const [loading, setLoading] = useState(false);
  // const [lists, setLists] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        if (category === "srchBooks") {
          const response = await axios.get(
            `http://data4library.kr/api/${category}?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&title=${search}&exactMatch=true&pageNo=1&pageSize=10&format=json`
          );
          setArticles(response.data.response.docs);
          // setLists(response.data.response.docs);
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
          setArticles(response.data.response.results[0].result.docs);
          // setLists(response.data.response.results[0].result.docs);
        }
        if (category === "libSrch") {
          const response = await axios.get(
            `http://data4library.kr/api/extends/${category}?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&format=json`
          );
          setArticles(response.data.response.libs);
          console.log(response.data.response.libs[9].lib.newBooks);
          // setLists(response.data.response.libs.lib);
        }
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fetchData();
  }, [search, category]);

  // const nextId = useRef(4);
  // const onInsert = useCallback(
  //   (articles) => {
  //     const data = {
  //       id: nextId.current,
  //       bookname: articles.doc,
  //       authors: articles.doc,
  //       bookDtlUrl: articles.doc,
  //       bookImageURL: articles.doc,
  //       publisher: articles.doc,
  //       isbn13: articles.doc,
  //       publication_year: articles.doc,
  //     };
  //     setLists(lists.concat(data));
  //     console.log(lists);
  //     nextId.current += 1;
  //   },
  //   [lists]
  // );
  if (loading) {
    return <NewsListBlock>대기중...</NewsListBlock>;
  }
  if (!articles) {
    return null;
  }
  return (
    <NewsListBlock>
      <div className={category !== "bookBlkt" ? "list" : "nolist"}>
        {articles.map((article, index) => (
          <NewsItem
            key={article.doc.isbn13}
            article={article}
            index={index}
            // onInsert={onInsert}
          />
        ))}
      </div>
      {/* <div className={category === "bookBlkt" ? "list" : "nolist"}>
        {data.map((list, index) => (
          <NewsItem
            key={list.doc.isbn13}
            article={data}
            index={index}
          />
        ))}
      </div> */}
    </NewsListBlock>
  );
};
export default NewsList;
