import { DialogContent } from '@mui/material';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import Typography from '@mui/material/Typography';
import { Box } from '@mui/system';
import PropTypes from 'prop-types';
import * as React from 'react';
import { buyMovieFetch } from '../api/rest/shopService';

BuyButton.propTypes = {
  onClose: PropTypes.func.isRequired,
  open: PropTypes.bool.isRequired,
  selectedValue: PropTypes.string.isRequired,
  film: PropTypes.object.isRequired
};

export default function BuyButton(props) {
  const { onClose, selectedValue, open, film } = props;

  const handleClose = () => {
    onClose(selectedValue);
  };

  const handleClickPay = () => {

    buyMovieFetch(film.id).then(res =>{
      film.bought=true
      onClose(selectedValue);
    })

  };

  return (
    <Dialog onClose={handleClose} open={open}>
      <DialogTitle>Buy Movie at ${film.price}</DialogTitle>
      <DialogContent>
        <div style={{ display: 'flex' }}>
          <img src={'https://image.tmdb.org/t/p/original' + film.posterPath}
            alt={film.title}
            style={{
              borderRadius: '3%',
              height: 200
            }}
          />
          <Box component='div' sx={{ display: 'flex', marginLeft: '20px', flexDirection: 'column', justifyContent: 'space-between' }}>
            <Box>
            <Typography>
              Title: {film.title}
            </Typography>
            <Typography>
              Author: {film.author}
            </Typography>
            </Box>
            <Button
              onClick={handleClickPay}
              sx={{ width: '200px' }}
              variant='contained'>
              PAY ${film.price}
            </Button>
          </Box>
        </div>
      </DialogContent>
    </Dialog>
  );
}