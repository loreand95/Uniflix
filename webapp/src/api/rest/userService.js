import axios from 'axios';

const userServiceConfig = {
  url: process.env.REACT_APP_URI_USER_SERVICE,
  timeout: 6000,
  configHeaders: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
};

const userService = axios.create({
  baseURL: userServiceConfig.url,
  timeout: userServiceConfig.timeout,
  headers: userServiceConfig.configHeaders,
});

export async function signInFetch(user){
  return userService
  .post('/signin', user).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}

export async function signUpFetch(user){
  return userService
  .post('/signup', user).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}

export async function getLibraryFetch(token){

  userService.defaults.headers.common['Authorization'] = `Bearer ${token}`;

  return userService
  .get('/library').then(res => res.data)
  .catch((error) => {
    throw error;
  });
}