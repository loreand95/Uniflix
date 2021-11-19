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

const checkToken = (token) =>{

  let t = 'd';

  if(token){
    shopService.defaults.headers.common['Authorization'] = `Bearer ${token}`;
  }else{
    shopService.defaults.headers.common['Authorization'] = null;
    t = new Date().getTime();
  }

  return t;
}

export async function getFilmById(token, movieId){

  let t = checkToken(token);

  return shopService
  .get('/movies/'+movieId+'?t='+t).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}

export async function buyMovieFetch(token, movieId){

  let t = checkToken(token);

  return shopService
  .post('/movies/'+movieId+'/buy?t='+t).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}
