import "./App.css";
import { Route, Routes } from "react-router-dom";
import BookPage from "./pages/BookPage";

const App = () => {
  return (
    <div className="font">
      <Routes>
        <Route path="/" element={<BookPage />} />
        <Route path="/:category" element={<BookPage />} />
      </Routes>
    </div>
  );
};

export default App;
