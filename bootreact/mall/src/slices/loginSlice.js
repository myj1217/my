import { createSlice } from "@reduxjs/toolkit";

const initState = {
  email: "",
};

// action과 reducer를 한 번에 작성.
const loginSlice = createSlice({
  name: "LoginSlice",
  initialState: initState,
  reducers: {
    login: (state, action) => {
      console.log("login....");
    },
    logout: (state, action) => {
      console.log("logout....");
    },
  },
});

export const { login, logout } = loginSlice.actions;
export default loginSlice.reducer;
