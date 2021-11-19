import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux'

export default function CustomAppBar({onlyLogo}) {

  const user = useSelector((state) => state.user);

  return (
    <Box>
      <AppBar position="static">
        <Toolbar>
          <Typography 
            style={{ fontWeight: 900 }}
            variant="h6"
            sx={{ flexGrow: 1, textDecoration: 'none', color:'white'}}
            component={Link} to={'/home'}>
            Uniflix
          </Typography>
          <>
          {
            user.token ?
             <div>
              <Button color="inherit" component={Link} to={'/library'}>Library</Button> 
              <Button color="inherit" component={Link} to={'/account'}>{user.fullname || 'Account'}</Button>
             </div>:
             !onlyLogo && <Button color="inherit" component={Link} to={'/signin'}>Sign In</Button>
          }
          </>
        </Toolbar>
      </AppBar>
    </Box>
  );
}