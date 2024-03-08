import { configureStore } from "@reduxjs/toolkit";
import loginSlice from "./slices/loginSlice";

// store 객체를 생성하기 위한 함수
export default configureStore({
  reducer: {
    loginSlice: loginSlice,
  },
});
