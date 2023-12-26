import React from "react";
import { NavLink, Outlet } from "react-router-dom";

const Articles = () => {
  return (
    <div>
      {/* 부모는 하나여야함 */}
      <Outlet />
      {/* Outlet으로 감쌀수 있는건 자식이라서 */}
      <ul>
        <ArticleItem id={1} />
        <ArticleItem id={2} />
        <ArticleItem id={3} />
        {/* 게시판을 id별로 하나씩 등록 */}
      </ul>
    </div>
  );
};
const ArticleItem = ({ id }) => {
  //새로운 컴포넌트 선언
  const activeStyle = {
    // 선택시 적용될 스타일 선언
    color: "green",
    fontSize: 21,
  };
  return (
    <li>
      <NavLink //NavLink 이용에서 목록에 스타일 설정할것
        to={`/articles/${id}`} //해당 주소랑 맞으면
        style={({ isActive }) => (isActive ? activeStyle : undefined)} //activeStyle을 사용하라 현재 선택된 목록에 직접 스타일을 줘서 지금
        //어디를 보고있는지 알려주는중
      >
        게시글{id}
        {/* 게시글+현재 게시글 id */}
      </NavLink>
    </li>
  );
};
export default Articles;
