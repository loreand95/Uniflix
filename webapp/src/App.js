import './App.css';
import { ThemeProvider } from '@mui/material/styles';
import theme from './theme';
import Routes from './navigation/Routes';
import { CssBaseline } from '@mui/material';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline/>
      <Routes/>
    </ThemeProvider>
  );
}

export default App;
