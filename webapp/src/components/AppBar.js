import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';

export default function CustomAppBar({onlyLogo}) {
  return (
    <Box>
      <AppBar position="static">
        <Toolbar>
          <Typography 
            style={{ fontWeight: 900 }}
            variant="h6"
            sx={{ flexGrow: 1, textDecoration: 'none', color:'white'}}
            component={Link} to={'/'}>
            Uniflix
          </Typography>
          {!onlyLogo && <Button color="inherit" component={Link} to={'/signin'}>Sign In</Button>}
        </Toolbar>
      </AppBar>
    </Box>
  );
}