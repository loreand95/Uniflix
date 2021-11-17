import axios from 'axios';

const shopServiceConfig = {
  url: process.env.REACT_APP_URI_SHOP_SERVICE,
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
  .get('/movies?category='+category).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}

export async function getFilmById(id){
  return shopService
  .get('/movies/'+id).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}

export async function buyMovieFetch(id){
  return shopService
  .post('/movies/'+id+'/buy').then(res => res.data)
  .catch((error) => {
    throw error;
  });
}
