import { useSearchParams } from "react-router-dom";

const About = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const detail = searchParams.get("detail");
  // get을 이용하여 detail의 키값을 갖고와서 저장
  const mode = searchParams.get("mode");

  const onToggleDetail = () => {
    setSearchParams({ mode, detail: detail === "true" ? false : true });
  }; // 이 함수를 호출했을 때 부정처리하라

  const onIncreaseMode = () => {
    const nextMode = mode === null ? 1 : parseInt(mode) + 1;
    setSearchParams({ mode: nextMode, detail });
  }; // parseInt : 숫자로 변경하는 메서드

  return (
    <div>
      <h1>소개합니다</h1>
      <p>리액트 라우터를 사용해보는 프로젝트입니다.</p>
      <p>detail :{detail}</p>
      <p>mode :{mode}</p>
      <button onClick={onToggleDetail}>Toggle detail</button>
      <button onClick={onIncreaseMode}>mode +1</button>
    </div>
  );
};

export default About;
