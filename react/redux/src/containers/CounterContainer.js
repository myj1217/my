import { connect } from "react-redux";
import Counter from "../components/Counter";
import { increase, decrease } from "../modules/counter";

const CounterContainer = ({ number, increase, decrease }) => {
  return (
    <Counter number={number} onIncrease={increase} onDecrease={decrease} />
  );
};

// const mapState = (state) => ({ number: state.counter.number });
// const mapDispatch = (dispatch) => ({
//   increase: () => {
//     dispatch(increase());
//   },
//   decrease: () => {
//     dispatch(decrease());
//   },
// });

// export default connect(mapState, mapDispatch)(CounterContainer);
//                     상태관리    액션관리
// 서로 연결되게끔 한다.

// export default connect(
//   (state) => ({
//     number: state.counter.number,
//   }),
//   (dispatch) => ({
//     increase: () => dispatch(increase()),
//     decrease: () => dispatch(decrease()),
//   })
// )(CounterContainer);
// redux는 어차피 이미 알고있다.
// 무엇이 상태관리고 액션관리인지
// 따라서, 따로 변수를 줘가면서까지 나눌 필요가 없다 (낭비)

export default connect(
  (state) => ({
    number: state.counter.number,
  }),
  {
    increase,
    decrease,
  }
)(CounterContainer);
