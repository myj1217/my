import React, { useCallback, useState } from "react";
import NewsSearch from "./components/NewsSearch";
import Categories from "./components/Categories";

const App = () => {
  const [category, setCategory] = useState("search");
  const onSelect = useCallback((category) => setCategory(category), []);
  return (
    <div>
      <Categories category={category} onSelect={onSelect} />
      <NewsSearch />
    </div>
  );
};

export default App;
