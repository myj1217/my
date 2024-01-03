import { useState } from "react";
import "./App.css";
import Header from "./Header";
import TodoList from "./components/TodoList";
import TodoTemplate from "./components/TodoTemplate";
import Map from "./components/map";
import BorrowTemplate from "./components/BorrowTemplate";
import BorrowList from "./components/BorrowList";

function App() {
  const [todos, setTodos] = useState([
    {
      id: 1,
      title: "성북정보도서관",
      address: "서울특별시 성북구 화랑로 18자길 13",
      tel: "02-962-1081",
      checked: true,
    },
    {
      id: 2,
      title: "아리랑도서관",
      address: "서울특별시 성북구 아리랑로 82",
      tel: "02-3291-4990",
      checked: true,
    },
    {
      id: 3,
      title: "해오름도서관",
      address: "서울특별시 성북구 성북로 4길 52",
      tel: "02-6925-7002",
      checked: false,
    },
    {
      id: 4,
      title: "성북길빛도서관",
      address: "서울특별시 성북구 숭인로 8길 52",
      tel: "02-6949-0031",
      checked: false,
    },
  ]);
  const [machines, setMachines] = useState([
    {
      id: 1,
      title: "성북정보도서관",
      address: "서울특별시 성북구 화랑로 18자길 13",
      tel: "02-962-1081",
      checked: true,
    },
    {
      id: 2,
      title: "아리랑도서관",
      address: "서울특별시 성북구 아리랑로 82",
      tel: "02-3291-4990",
      checked: true,
    },
    {
      id: 3,
      title: "해오름도서관",
      address: "서울특별시 성북구 성북로 4길 52",
      tel: "02-6925-7002",
      checked: false,
    },
    {
      id: 4,
      title: "성북길빛도서관",
      address: "서울특별시 성북구 숭인로 8길 52",
      tel: "02-6949-0031",
      checked: false,
    },
  ]);
  return (
    <div>
      <Header />
      <Map />
      <TodoTemplate>
        <TodoList todos={todos} />
      </TodoTemplate>
      <BorrowTemplate>
        <BorrowList machines={machines} />
      </BorrowTemplate>
    </div>
  );
}

export default App;
