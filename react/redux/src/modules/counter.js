import { createAction, handleActions } from "redux-actions";

// 액션 객체 생성
const INCREASE = "counter/INCREASE";
const DECREASE = "counter/DECREASE";
// 앞에 counter 붙인 이유?
// inc나 dec는 다른데서도 충분히 사용할 수 있는 거라
// 특정해주지 않으면 나중에 충돌이 일어날 수도 있음

// 액션 생성 함수
// export const increase = () => ({ type: INCREASE });
// export const decrease = () => ({ type: DECREASE });
export const increase = createAction(INCREASE);
export const decrease = createAction(DECREASE);

// 초기 상태 및 리듀서
const initialState = {
  number: 0,
};

// function counter(state = initialState, action) {
//   switch (action.type) {
//     case INCREASE:
//       return {
//         number: state.number + 1,
//       };
//     case DECREASE:
//       return {
//         number: state.number - 1,
//       };
//     default:
//       return state;
//   }
// }

const counter = handleActions(
  // handleActions 함수의 첫번째 파라미터에는
  // 각 액션에 대한 업데이트 함수를 넣어주고
  // 두번째 파라미터에는 초기 상태를 넣어준다.
  {
    [INCREASE]: (state, action) => ({ number: state.number + 1 }),
    [DECREASE]: (state, action) => ({ number: state.number - 1 }),
  }, // 상태값 넘겨받아서 연산해준다.
  // action은 생략해도 된다.
  initialState // 두번째에 담아서 넘겨준다.
);

export default counter;
