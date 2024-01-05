import React from "react";
import NewsList from "./components/NewsList";
import NewsSearch from "./components/NewsSearch";

const App = () => {
  return (
    <div>
      <NewsSearch />
      <NewsList />
    </div>
  );
};

export default App;
