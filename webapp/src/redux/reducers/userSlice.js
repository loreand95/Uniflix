import { createSlice } from '@reduxjs/toolkit';
import { signInFetch, signUpFetch, getLibraryFetch } from '../../api/rest/userService';
import { buyMovieFetch, getFilmById } from '../../api/rest/shopService';

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

export const buyMovieAction = (movieId) => {
  return async (dispatch, getState) => {
       const token= getState().user.token;
      return buyMovieFetch(token, movieId);
  };
};

export const getMovieAction = (movieId) => {
  return async (dispatch, getState) => {
       const token= getState().user.token;
       console.log('token',token)
      return getFilmById(token, movieId);
  };
};

export const { login, logout } = userSlice.actions

export default userSlice.reducer