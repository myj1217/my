import { legacy_createStore } from "redux";

// dom 접근
const divToggle = document.querySelector(".toggle");
const counter = document.querySelector("h1");
const btnIncrease = document.querySelector("#increase");
const btnDecrease = document.querySelector("#decrease");

// 액션 객체 생성
const TOGGLE_SWITCH = "TOGGLE_SWITCH";
const INCREASE = "INCREASE";
const DECREASE = "DECREASE";

// 액션 객체 생성 함수
const toggleSwitch = () => ({ type: TOGGLE_SWITCH });
const increase = (difference) => ({ type: INCREASE, difference });
const decrease = () => ({ type: DECREASE });

// 리듀서 (reducer)
const initialState = {
  toggle: false,
  counter: 0,
};

// 작동 순서 : 2번째
function reducer(state = initialState, action) {
  switch (action.type) {
    case TOGGLE_SWITCH:
      return {
        ...state, // immer 로 대체 가능
        toggle: !state.toggle,
      };
    case INCREASE:
      return {
        ...state,
        counter: state.counter + action.difference,
      };
    case DECREASE:
      return {
        ...state,
        counter: state.counter - 1,
      };
    default:
      return state;
  }
}

// 스토어(store) 생성
const store = legacy_createStore(reducer);
// 내장함수도 갖고 있고 reducer도 갖고 있다.

const render = () => {
  const state = store.getState(); // 현재 상태를 조회
  // store 객체의

  if (state.toggle) {
    divToggle.classList.add("active");
  } else {
    divToggle.classList.remove("active");
  }

  counter.innerText = state.counter; // 그대로 반환해라
};

// render();

// subscribe 함수의 파라미터로는 함수 형태의 값을 전달해준다.
// 이렇게 전달된 함수는 추후 액션이 발생하여 상태가 업데이트 될 때마다 호출해준다.
store.subscribe(render); // 변화가 발생하면 호출

// 작동 순서 : 1번째
// 변경 이벤트
divToggle.onclick = () => {
  // divToggle에 클릭이 발생하면 ~
  // carmel case 적용안함
  // 적용하는 것 = react
  store.dispatch(toggleSwitch());
  // toggleSwitch를 부름으로 인해서
};
btnIncrease.onclick = () => {
  store.dispatch(increase(1));
};
btnDecrease.onclick = () => {
  store.dispatch(decrease());
};
