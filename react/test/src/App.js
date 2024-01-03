import React, { useState } from "react";
import axios from "../node_modules/axios/index";

const App = () => {
  const [data, setData] = useState(null);
  // 초기값 우선 비움
  // data는 api로부터 불러온 데이터를 저장
  const onClick = () => {
    axios // promise 베이스의 비동기 라이브러리
      .get(
        "http://data4library.kr/api/libSrch?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&pageNo=1&pageSize=10&format=json"
      )
      // api를 불러오는 데 성공할 경우 = resolve = then
      .then((response) => {
        setData(response.data);
      });
  };
  return (
    <div>
      <div>
        <button onClick={onClick}>불러오기</button>
      </div>
      {/* data가 true면 실행하라 */}
      {data && (
        <textarea
          rows={7}
          value={JSON.stringify(data, null, 2)}
          // json 타입의 문자를 받아와서 문자열로 변환
          // json 문자열로 변환할 값 , null = 모든 속성 포함하겠다 , 스페이스(공백) 개수
          readOnly={true}
        />
      )}
    </div>
  );
};

export default App;
