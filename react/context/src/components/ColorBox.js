import React, { useContext } from "react";
import ColorContext from "../contexts/color";

const ColorBox = () => {
  const { state } = useContext(ColorContext);
  return (
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
  );
};

export default ColorBox;
