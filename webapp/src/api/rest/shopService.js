import axios from 'axios';

const shopServiceConfig = {
  url: 'http://35.223.107.128:3006/shopservice/rest',
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
  console.log('IP',shopServiceConfig.url);
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
