import ColorBox from "./components/ColorBox";
import SelectColors from "./components/SelectColors";
import { ColorProvider } from "./contexts/color";

function App() {
  return (
    <ColorProvider>
      {/* color 에 red 를 공급할 것이다. */}
      {/* Provider를 사용할 때는 반드시 value를 입력해야 한다. */}
      <div>
        <SelectColors />
        <ColorBox />
      </div>
    </ColorProvider>
  );
}

export default App;
