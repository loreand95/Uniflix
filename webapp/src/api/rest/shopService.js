import axios from 'axios';

const shopServiceConfig = {
  url: 'http://localhost:3006/shopservice/rest',
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
