import React from "react";
import { ColorConsumer } from "../contexts/color";

const ColorBox = () => {
  return (
    <ColorConsumer>
      {/* 값을 사용할 것이다 */}
      {({ state }) => (
        // 괄호 안의 값을 전부 전달받을 것이다.
        <>
          <div
            style={{
              width: "64px",
              height: "64px",
              background: state.color,
              // value는 ColorContext.Provider 로부터 튀어나온다.
              // 따라서, value를 사용하기 위해서는 ColorContext 부분으로 가보면
              // 그 값은 state 안에 color 안에 있다. 다 써줘야 된다.
            }}
          />
          <div
            style={{
              width: "32px",
              height: "32px",
              background: state.subcolor,
            }}
          />
        </>
        // div 태그의 속성
      )}
    </ColorConsumer>
  );
};

export default ColorBox;
