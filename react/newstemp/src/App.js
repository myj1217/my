import React, { useState } from "react";
import axios from "../node_modules/axios/index";

const App = () => {
  const [data, setData] = useState(null);
  const onClick = async () => {
    try {
      const date = new Date();
      const yd = new Date(date.setDate(date.getDate() - 1));
      console.log(yd);
      const response = await axios.get(
        "http://data4library.kr/api/hotTrend?authKey=b85ec318ffca5a5f63a9fcf1e0a6cc95f00eda54e322fdb26fafe700420c33c5&searchDt=2024-01-04&format=json"
      );
      setData(response.data);
      console.log(response.data.response.results[0].result.docs);
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <div>
      <div>
        <button onClick={onClick}>불러오기</button>
      </div>
      {data && (
        <textarea
          rows={7}
          value={JSON.stringify(data, null, 2)}
          readOnly={true}
        />
      )}
    </div>
  );
};

export default App;
