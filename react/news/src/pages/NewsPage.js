import React from 'react';
import Categories from '../components/Categories';
import NewsList from '../components/NewsList';
import { useParams } from '../../node_modules/react-router-dom/dist/index';

const NewsPage = () => {
  const params = useParams();
  const category = params.category || 'all';
  // || : 왼쪽이 아니면 오른쪽을 담는다.
  // ex) business를 담아서
  return (
    <>
      {/* fragment : react에서 div 역할 */}
      <Categories />
      <NewsList category={category} />
      {/* 담은 것을 여기서 쏴줌 */}
    </>
  );
};

export default NewsPage;
