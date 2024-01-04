import React, { useState } from "react";
import NewsList from "./NewsList";

const NewsSearch = () => {
  const [search, setSearch] = useState("");
  const onChange = (e) => {
    setSearch(e.target.value);
  };
  return (
    <div>
      <input type="text" value={search} onChange={onChange} />
      <NewsList search={search} />
    </div>
  );
};

export default NewsSearch;
