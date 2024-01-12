import React from "react";
import Categories from "../components/Categories";
import { useParams } from "react-router-dom";
import NewsSearch from "../components/NewsSearch";

const NewsPage = () => {
  const params = useParams();
  const category = params.category || "srchBooks";
  return (
    <>
      <Categories />
      <NewsSearch category={category} />
    </>
  );
};

export default NewsPage;
