import axios from 'axios';

const serviceConfig = {
  url: process.env.REACT_APP_URI_REVIEW_SERVICE,
  timeout: 6000,
  configHeaders: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
};

const service = axios.create({
  baseURL: serviceConfig.url,
  timeout: serviceConfig.timeout,
  headers: serviceConfig.configHeaders,
});

export async function getReviewsFilmById(id){
  return service
  .get('/movies/'+id).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}
