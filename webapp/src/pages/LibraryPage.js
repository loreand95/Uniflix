import Container from '@mui/material/Container';
import * as React from 'react';
import { useDispatch } from 'react-redux';
import LibraryTable from '../components/LibraryTable';
import { getLibraryAction } from '../redux/reducers/userSlice';
import BaseLayout from './BaseLayout';

export default function LibraryPage() {

  const dispatch = useDispatch();

  const [movies, setMovies] = React.useState();

  React.useEffect(() => {
    dispatch(getLibraryAction()).then((res) => {
      setMovies(res)
    })
  }, [dispatch])


  return (
    <BaseLayout>
      <Container component="main" maxWidth="l" sx={{ mt:5, height: '100%', display: 'flex', flexDirection: 'column' }}>
        <LibraryTable movies={movies} />
      </Container>
    </BaseLayout >
  );
}