import { createSlice } from '@reduxjs/toolkit';
import { signInFetch, signUpFetch, getLibraryFetch } from '../../api/rest/userService';

const initialState = {
  fullname: null,
  email: null,
  token: null,
}

export const userSlice = createSlice({
  name: 'user',
  initialState: initialState,
  reducers: {
    logout: (state) => initialState,
    login: (state, action) => action.payload
  },
})

export const signInAction = user => dispatch => {
  return signInFetch(user).then(res => {
    dispatch(login(res));
  });
};

export const signUpAction = user => dispatch => {
  return signUpFetch(user).then(res => {
    dispatch(login(res));
  });
};

export const logoutAction = () => async dispatch => {
  return dispatch(logout());
};

export const getLibraryAction = () => {
  return async (dispatch, getState) => {
       const token= getState().user.token;
      return getLibraryFetch(token);
  };
};

export const { login, logout } = userSlice.actions

export default userSlice.reducer