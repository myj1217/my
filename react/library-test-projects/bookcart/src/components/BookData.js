import styled from "styled-components";
import { useEffect, useState } from "react";
import axios from "axios";
import BookSetting from "./BookSetting";

const BookDataBlock = styled.div`
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

const BookData = ({ category, srchValue }) => {
  const [srchBooks, setSrchBooks] = useState("");
  const [hotTrends, setHotTrends] = useState("");
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const resSrch = await axios.get(
          `http://data4library.kr/api/srchBooks?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&title=${srchValue}&exactMatch=true&pageNo=1&pageSize=10&format=json`
        );
        console.log(srchBooks);
        const arraySrch = [];
        for (let i = 0; i <= 9; i++) {
          arraySrch.push({
            doc: {
              ...resSrch.data.response.docs[i].doc,
              checked: false,
            },
          });
        }
        setSrchBooks(arraySrch);

        const date = new Date();
        const yd = new Date(date.setDate(date.getDate() - 1));
        const mm =
          yd.getMonth() + 1 < 10 ? `0${yd.getMonth() + 1}` : yd.getMonth() + 1;
        const dd = yd.getDate() < 10 ? `0${yd.getDate()}` : yd.getDate();
        const dateConvert = `${yd.getFullYear()}-${mm}-${dd}`;
        const resHot = await axios.get(
          `http://data4library.kr/api/hotTrend?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&searchDt=${dateConvert}&format=json`
        );
        const arrayHot = [];
        for (let i = 0; i <= 4; i++) {
          arrayHot.push({
            doc: {
              ...resHot.data.response.results[0].result.docs[i].doc,
              checked: false,
            },
          });
        }
        setHotTrends(arrayHot);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fetchData();
  }, [srchValue, srchBooks]);

  if (loading) {
    return <BookDataBlock>대기중...</BookDataBlock>;
  }
  if (!srchBooks) {
    return null;
  }

  return (
    <BookSetting category={category} books={srchBooks} hotBooks={hotTrends} />
  );
};

export default BookData;
