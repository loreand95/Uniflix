import { createTheme } from '@mui/material/styles';
import { orange } from '@mui/material/colors';

const theme = createTheme({
  typography: {
    fontFamily: 'Poppins',
    button: {
      fontWeight: 600,
    },
  },
  components: {
    MuiAppBar: {
      defaultProps: {
        enableColorOnDark: true,
      },
    },
  },
  palette: {
    mode: 'dark',
    primary: {
        main: '#E50914'
    },
    secondary: {
      main: orange[500],
    },
    
  },
});

export default theme;