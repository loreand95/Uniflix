import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import BaseLayout from './BaseLayout';
import { useSelector, useDispatch } from 'react-redux'
import { logoutAction } from '../redux/reducers/userSlice'
import { useHistory } from "react-router-dom";

export default function AccountPage() {

  const history = useHistory();
  const dispatch = useDispatch();

  const user = useSelector((state) => state.user);

  const handleSubmit = (event) => {
    event.preventDefault();
    
    dispatch(logoutAction()).then(() => {
      history.push('/home');
    })
  };

  return (
    <BaseLayout>
      <Container component="main" maxWidth="xs" sx={{height:'100%', display:'flex', flexDirection:'column'}}>
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexGrow:1,
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Typography component="h1" variant="h5">
            Account
          </Typography>
          <Box component="form" noValidate sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={12}>
                <TextField
                  defaultValue={user.fullname}
                  disabled
                  autoComplete="fname"
                  name="firstName"
                  required
                  fullWidth
                  id="firstName"
                  label="First Name"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  defaultValue={user.email}
                  disabled
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
            </Grid>
          </Box>
        </Box>
        <Button
              fullWidth
              variant="contained"
              sx={{ mb: 5}}
              onClick={handleSubmit}
            >
              Logout
            </Button>
      </Container>
      </BaseLayout>
  );
}