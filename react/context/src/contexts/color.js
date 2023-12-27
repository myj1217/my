import { createContext, useState } from "react";

// createContext를 이용하여 조회하는 것을 만들거임.
const ColorContext = createContext({
  state: { color: "black", subcolor: "red" },
  // black과 red를 넣어 state라는 객체를 만듦.
  action: {
    setColor: () => {},
    setSubcolor: () => {},
  }, // 함수가 2개 들어가 있는 action
});

const ColorProvider = ({ children }) => {
  const [color, setColor] = useState("black");
  const [subcolor, setSubcolor] = useState("red");

  // 호출하면 변경해서 저장할 것이다.
  const value = {
    state: { color, subcolor },
    // 변수값 (상태)
    actions: { setColor, setSubcolor },
  };
  return (
    <ColorContext.Provider value={value}>{children}</ColorContext.Provider>
  ); // ColorContext에게 공급할 것이다. = 수정할 것이다.
  // value를 갖고 와서 children을 출력할 것이다.
};

// const ColorConsumer = ColorContext.Concumer와 같은 의미
const { Consumer: ColorConsumer } = ColorContext;
// ColorContext를 조회할건데

// colorProvider와 colorConsumer 내보내기
export { ColorProvider, ColorConsumer };
// 밖에 내보냈으니 밖에서 가져다 쓰면 됨

export default ColorContext;
