import * as React from 'react';
import IconButton from '@mui/material/IconButton';
import { Typography } from '@mui/material';
import { Link } from 'react-router-dom';

export default function ActorCard({ actor }) {

  return (
    <div
      style={{
        margin: '10px',
        position: 'relative'
      }}>
      <img src={actor.profilePath} alt="" style={{
        borderRadius: '100%',
        position: 'relative',
        width: 100,
        height: 100,
        objectFit: "cover"
      }} />
      <IconButton
        aria-label="add an alarm"
        style={{
          top: '0px',
          left: '0px',
          position: 'absolute',
          width: 100,
          height: 100,
          color: 'white'
        }}
        component={Link}
        to={'/actors/' + actor.actorId}
      >
        <Typography variant="caption">
          {actor.name}
        </Typography>
      </IconButton>
    </div>
  );
}