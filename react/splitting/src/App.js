import logo from "./logo.svg";
import "./App.css";
import React, { Suspense, useState } from "react";
// import notify from "./notify";

const SplitMe = React.lazy(() => import("./SplitMe"));

function App() {
  const [visible, setVisible] = useState(false);
  const onClick = () => {
    setVisible(true);
    //import("./notify").then((result) => result.default());
  }; // notify를 import할건데 비동기로 처리할거야
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p onClick={onClick}>Hello React!</p>
        {/* 느린걸 감지하면 보여라 */}
        <Suspense fallback={<div>loading...</div>}>
          {visible && <SplitMe />}
        </Suspense>
      </header>
    </div>
  );
}

export default App;
