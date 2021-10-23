import axios from 'axios';

const serviceConfig = {
  url: 'http://localhost:3005/filmservice/rest',
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

export async function getActorFetch(actorId){
  return service
  .get('/actors/'+actorId).then(res => res.data)
  .catch((error) => {
    throw error;
  });
}
