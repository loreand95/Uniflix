import React from 'react';
import { makeStyles } from '@mui/styles';
import Typography from '@mui/material/Typography';
import AppBar from '../components/AppBar';
import { useTheme } from '@mui/material/styles';

function BaseLayout({children, onlyLogo,style}) {
  const classes = useStyles();
  const theme = useTheme();

  return (
    <div className={classes.container} style={{...style}}>
        <AppBar onlyLogo={onlyLogo}/>
        <div style={{ flexGrow: 1,backgroundColor:theme.palette.background.paper}}>
            {children}
        </div>
        <div className={classes.footer}>
            <Typography variant="caption">
                &copy; 2021 Uniflix, All rights reserved
            </Typography>
        </div>
    </div>
  );
}

const useStyles = makeStyles((theme) => ({
  container: {
    display: 'flex',
    flexDirection: 'column',
    flexGrow: 1,
    height:'100%',
  },
  content: {
    display: 'flex',
    flexDirection: 'column',
    flexGrow: 1,
  },
  footer: {
    paddingLeft:'5px'
  }
}));

export default BaseLayout;