import * as React from 'react';
import { useState } from "react";
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import BaseLayout from './BaseLayout';
import { useDispatch } from 'react-redux'
import { signInAction } from '../redux/reducers/userSlice'
import { useHistory } from "react-router-dom";
import CircularProgress from '@mui/material/CircularProgress';

export default function SignInPage() {

  const history = useHistory();
  const dispatch = useDispatch();

  const [loading, setLoading] = useState();

  const [authError, setAuthError] = useState({error:false,helperText:''});

  const handleSubmit = (event) => {
    event.preventDefault();
    
    setLoading(true);
    const data = new FormData(event.currentTarget);

    const user = {
      email: data.get('email'),
      password: data.get('password')
    }

    dispatch(signInAction(user)).then(() => {
      setLoading(false);
      history.push('/home');
    }).catch(err =>{
      setLoading(false);
      setAuthError({...authError,error:true, helperText:'Wrong password'})
      console.log(err)
    });
  };

  return (
    <BaseLayout onlyLogo={true}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              defaultValue="and@mail.it"
              required
              fullWidth
              id="email"
              label="Email Address"
              name="email"
              autoComplete="email"
              autoFocus
            />
            <TextField
              error={authError.error}
              helperText={authError.helperText}
              margin="normal"
              defaultValue="123456"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
            />
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Remember me"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              {
                loading ? <CircularProgress size={20} style={{ color: 'white' }} /> : 'Sign In'
              }
            </Button>
            <Grid container>
              <Grid item xs>
              </Grid>
              <Grid item>
                <Link href="/signup" variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </BaseLayout>
  );
}