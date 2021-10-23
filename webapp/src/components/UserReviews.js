import * as React from 'react';
import { useEffect, useState } from "react";
import { getReviewsFilmById } from '../api/rest/shopService';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import { Box } from '@mui/system';

export default function UserReviews({ movie }) {

  const [reviews, setReviews] = useState();

  useEffect(() => {
    getReviewsFilmById(movie.id).then(setReviews);

  }, [movie]);

  useEffect(() => {
    console.log(reviews)
  }, [reviews]);



  return (
    <Box sx={{ mt: 3 }}>
      <Typography
        variant='h4'>
        Reviews
      </Typography>
      <List>
        {reviews && reviews.map((review) =>
          <ReviewItem key={review.id} review={review} />
        )}
      </List>
    </Box>
  );
}

function ReviewItem({ review }) {
  return (
    <>
      <ListItem alignItems="flex-start">
        <ListItemAvatar>
          <Avatar alt={review.author} src="/static/images/avatar/1.jpg" />
        </ListItemAvatar>
        <ListItemText
          primary={review.author}
          secondary={review.content}
        />
      </ListItem>
      <Divider variant="inset" component="li" />
    </>
  );
}