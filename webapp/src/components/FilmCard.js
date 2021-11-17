import * as React from 'react';
import IconButton from '@mui/material/IconButton';
import PlayCircleOutlineRoundedIcon from '@mui/icons-material/PlayCircleOutlineRounded';
import { Typography } from '@mui/material';
import { Link } from 'react-router-dom';

export default function FilmCard({film}) {
  return (
    <div
    style={{
      margin:'10px',
      position:'relative'
    }}>
      <img src={film.posterPath} alt="" style={{borderRadius:'5%',position: 'relative', maxWidth:250,minHeight:'200px', objectFit: "cover"}}/>
      <IconButton
        aria-label="add an alarm"
            style={{
              top:'30px',
              left:'50px',
              position:'absolute',
              width:'150px',
              height:'150px',
              color: 'white'
            }}
            component={Link}
            to={'/films/' + film.movieId}
      >
        <PlayCircleOutlineRoundedIcon />
      </IconButton>
      <div
          style={{
            bottom:'10px',
            left:'10px',
            position:'absolute'
          }}>
            <Typography
            variant='subtitle1'
            color="white"
            >
            {film.title} ({film.year}) - {film.duration} min
            </Typography>
      </div>
    </div>
  );
}