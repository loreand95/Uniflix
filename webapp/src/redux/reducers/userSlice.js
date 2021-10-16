import { createSlice } from '@reduxjs/toolkit';
import { signInFetch, signUpFetch } from '../../api/rest/userService';

const initialState = {
  fullname: null,
  email: null,
  token: null,
}

export const userSlice = createSlice({
  name: 'user',
  initialState: initialState,
  reducers: {
    logout: (state) => {
      state = initialState
    },
    login: (state, action) => {
      state = action.payload
    },
  },
})

export const signInAction = user => dispatch => {
  return signInFetch(user).then(res => {
    // console.log('user',user)
    // console.log('res',res)
    console.log('SIGN IN')
    dispatch(login(res));
  });
};

export const signUpAction = user => dispatch => {
  return signUpFetch(user).then(res => {
    // console.log('user',user)
    // console.log('res',res)
    console.log('SIGN UP')
    dispatch(login(res));
  });
};

export const { login, logout } = userSlice.actions

export default userSlice.reducer