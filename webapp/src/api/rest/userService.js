import axios from 'axios';
//import {store} from '../../redux/Store';
//import {HttpStatus} from '../../utils';
//import {logout} from '../../redux/action-creators/AccountActionCreators';

const userServiceConfig = {
  url: 'http://localhost:3005/rest/userservice',
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