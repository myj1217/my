import React, { useState } from "react";
import NewsList from "./NewsList";

const NewsSearch = () => {
  const [search, setSearch] = useState("");
  const onChange = (e) => {
    setSearch(e.target.value);
  };
  const onClick = () => {
    alert(`'${search}'로 검색한 검색결과입니다!`);
    setSearch("");
  };
  const onKeyPress = (e) => {
    if (e.key === "Enter") {
      onClick();
    }
  };
  return (
    <div>
      <input
        type="text"
        name="bookname"
        value={search}
        placeholder="책제목을 입력하세요."
        onChange={onChange}
        onKeyPress={onKeyPress}
      />
      <button onClick={onClick}>검색</button>
      <NewsList search={search} />
    </div>
  );
};

export default NewsSearch;
