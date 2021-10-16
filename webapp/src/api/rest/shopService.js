import axios from 'axios';
//import {store} from '../../redux/Store';
//import {HttpStatus} from '../../utils';
//import {logout} from '../../redux/action-creators/AccountActionCreators';

const shopServiceConfig = {
  url: 'http://localhost:3005/rest/shopservice',
  timeout: 6000,
  configHeaders: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
};

const shopService = axios.create({
  baseURL: shopServiceConfig.url,
  timeout: shopServiceConfig.timeout,
  headers: shopServiceConfig.configHeaders,
});

export async function getAllFilmByCategory(category){
  return shopService
  .get('/films?category='+category).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}

export async function getFilmById(id){
  return shopService
  .get('/films/'+id).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}

export async function getReviewsFilmById(id){
  return shopService
  .get('/films/'+id+'/reviews').then(res => res.data)
  .catch((error) => {
    throw error;
  });
}



// const securedBlueSling = axios.create({
//   baseURL: blueSlingConfig.url,
//   timeout: blueSlingConfig.timeout,
//   headers: blueSlingConfig.configHeaders,
// });

// securedBlueSling.interceptors.request.use(async (request) => {
//   request.headers.Authorization = `Bearer ${store.getState().account.jwt}`;
//   return request;
// });

// securedBlueSling.interceptors.response.use((response) => response, (error) => {
//   if (error.response?.status === HttpStatus.UNAUTHORIZED) {
//     store.dispatch(logout());
//   }
//   return Promise.reject(error);
// });
