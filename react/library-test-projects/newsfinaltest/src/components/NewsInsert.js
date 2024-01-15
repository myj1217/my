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
<<<<<<< Updated upstream:react/library-test-projects/newsfinaltest/src/components/NewsInsert.js
  .nolist {
=======
  .noshowmap, .noshowlist {
>>>>>>> Stashed changes:react/newsmiddletest/src/components/NewsList.js
    display: none;
  }
`;

<<<<<<< Updated upstream:react/library-test-projects/newsfinaltest/src/components/NewsInsert.js
const NewsInsert = ({ category, search }) => {
  const [books, setBooks] = useState("");
=======
const { kakao } = window;

const NewsList = ({ search, category }) => {
  const [articles, setArticles] = useState(null);
>>>>>>> Stashed changes:react/newsmiddletest/src/components/NewsList.js
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
        if (category === "arndLib") {
            const markerdata = [
              {
                title: "성북정보도서관",
                lat: 37.6050025,
                lng: 127.0507423,
              },
              {
                title: "아리랑도서관",
                lat: 37.5998924,
                lng: 127.0139225,
              },
              {
                title: "해오름도서관",
                lat: 37.5940488,
                lng: 127.0105522,
              },
              {
                title: "성북길빛도서관",
                lat: 37.6098358,
                lng: 127.0263263,
              },
            ];
            let container = document.getElementById("map");
            let options = {
              center: new kakao.maps.LatLng(37.6000025, 127.0307423),
              level: 7,
            };
        
            //map
            const maps = new kakao.maps.Map(container, options);
        
            markerdata.forEach((el) => {
              // 마커를 생성합니다
              new kakao.maps.Marker({
                //마커가 표시 될 지도
                map: maps,
                //마커가 표시 될 위치
                position: new kakao.maps.LatLng(el.lat, el.lng),
                //마커에 hover시 나타날 title
                title: el.title,
              });
            });
          
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
<<<<<<< Updated upstream:react/library-test-projects/newsfinaltest/src/components/NewsInsert.js

  return <NewsSearch category={category} books={books} />;
=======
  return (
    <div>
    <NewsListBlock>
    
    <div className={category === "arndLib" ? "noshowlist" : "showlist"}>
      {articles.map((article) => (
        <NewsItem key={article.doc.isbn13} article={article} />
      ))}</div>
      <div className={category === "arndLib" ? "showmap" : "noshowmap"}
    id="map"
    style={{
      width: "80%",
      height: "450px",
      marginLeft: "auto",
      marginRight: "auto",
    }}></div>
    </NewsListBlock>
  </div>
  );
>>>>>>> Stashed changes:react/newsmiddletest/src/components/NewsList.js
};

export default NewsInsert;
