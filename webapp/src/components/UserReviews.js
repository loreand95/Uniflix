import Avatar from '@mui/material/Avatar';
import Divider from '@mui/material/Divider';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import Typography from '@mui/material/Typography';
import { Box } from '@mui/system';
import * as React from 'react';

export default function UserReviews({ reviews }) {
  return (
    <Box sx={{ mt: 3 }}>
      <Typography
        variant='h4'>
        Reviews
      </Typography>
      <List>
        {reviews && reviews.length === 0 && 'No reviews yet'}
        {reviews && reviews.map((review, index) =>
          <ReviewItem key={index} review={review} />
        )}
      </List>
    </Box>
  );
}

function ReviewItem({ review }) {

  //Content too long
  if(review.content.length > 300){
    review.content = review.content.substr(0,300) + ' ... ';
  }

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