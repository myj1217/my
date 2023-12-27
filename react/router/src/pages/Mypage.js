import { Navigate } from "react-router-dom";

const Mypage = () => {
  const isLoggedIn = false; // 기본값이 로그인을 안했다
  if (!isLoggedIn) {
    // false 이면 ~
    return <Navigate to="/login" replace={true} />;
  } // replace true : 이 페이지는 기록에 남기지 않는다.
  return <div>마이페이지</div>;
};

export default Mypage;
