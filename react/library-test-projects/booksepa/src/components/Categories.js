import styled from "styled-components";
import { NavLink } from "react-router-dom";

const categories = [
  {
    name: "srchBooks",
    text: "도서검색",
  },
  {
    name: "hotTrend",
    text: "인기도서",
  },
  {
    name: "bookBskt",
    text: "북카트",
  },
];

const CategoriesBlock = styled.div`
  display: fixed;
  padding: 1rem;
  width: 300px;
  margin: 0 auto;
`;

const Category = styled(NavLink)`
  font-size: 1.125rem;
  cursor: pointer;
  white-space: pre;
  text-decoration: none;
  color: inherit;
  padding-bottom: 0.25rem;
  padding: 10px;

  &:hover {
    color: #495057;
  }

  &.active {
    font-weight: 600;
    border-bottom: 2px solid #22b8cf;
    color: #22b8cf;
    &:hover {
      color: #3bc9db;
    }
  }

  & + & {
    margin-left: 1rem;
  }
`;

const Categories = () => {
  return (
    <CategoriesBlock>
      {categories.map((c) => (
        <Category
          key={c.name}
          className={({ isActive }) => (isActive ? "active" : undefined)}
          to={c.name === "srchBooks" ? "/" : `/${c.name}`}
        >
          {c.text}
        </Category>
      ))}
    </CategoriesBlock>
  );
};

export default Categories;
