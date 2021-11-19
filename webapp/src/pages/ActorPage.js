import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import CssBaseline from '@mui/material/CssBaseline';
import * as React from 'react';
import BaseLayout from './BaseLayout';
import { useParams } from 'react-router-dom';
import { getActorFetch } from '../api/rest/filmService';
import Skeleton from '@mui/material/Skeleton';
import { Typography } from '@mui/material';

export default function ActorPage() {

  const { actorId } = useParams();
  const [actor, setActor] = React.useState();

  React.useEffect(() => {
    actorId && getActorFetch(actorId).then(setActor);
  }, [actorId]);

  return (
    <BaseLayout>
      <Container component="main" maxWidth="md" sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}>
        <CssBaseline />
        <Box sx={{ mt: 5 }}>
          {
            actor ?
              <ActorDetail actor={actor} />
              :
              <Skeleton variant="circular" width={200} height={200} />
          }
        </Box>
      </Container>
    </BaseLayout>
  );
}

function ActorDetail({ actor }) {

  return (
    <Box sx={{ textAlign: 'center' }}>
      <Box>
        <img src={actor.profilePath} alt="actor"
          style={{
            borderRadius: '100%',
            position: 'relative',
            width: 200,
            height: 200,
            objectFit: "cover"
          }} />
        <Typography
          variant='h4'>
          {actor.name}
        </Typography>
      </Box>
      <Box sx={{ mt: 3, textAlign: 'justify' }}>
        <Box>
          <Typography
            sx={{mb:1}}
            variant='h4'>
            Description
          </Typography>
          <Box sx={{ display: 'flex' }}>
            <Typography style={{ fontWeight: 600 }}>
              Name:&nbsp;
            </Typography>
            <Typography>
              {actor.name}
            </Typography>
          </Box>
          <Box sx={{ display: 'flex' }}>
            <Typography style={{ fontWeight: 600 }}>
              Birthday:&nbsp;
            </Typography>
            <Typography>
              {actor.birthday}
            </Typography>
          </Box>
          <Box sx={{ display: 'flex' }}>
            <Typography style={{ fontWeight: 600 }}>
              Birthplace:&nbsp;
            </Typography>
            <Typography>
              {actor.birthplace}
            </Typography>
          </Box>
        </Box>
        <Box sx={{mt:3}}>
          <Typography
            sx={{mb:1}}
            variant='h4'>
            Biography
          </Typography>
          <Typography
            variant='body'>
            {actor.biography}
          </Typography>
        </Box>
      </Box>
    </Box>
  );
}