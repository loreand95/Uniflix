import React, { useEffect } from "react";
import { Button, Typography } from '@mui/material';
import { makeStyles } from '@mui/styles';
import { getAllFilmByCategory } from '../api/rest/shopService';
import PlayArrowRoundedIcon from '@mui/icons-material/PlayArrowRounded';
import { Link } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    showBtn: { position: 'absolute', right: '50px', bottom: '30px' },
    title: { position: 'absolute', left: '5%', top: '40%' },
    description: {
        fontWeight: 900,
        [theme.breakpoints.down('sm')]: {
            visibility: 'hidden',
        },
    }
}));

function Carousel() {
    const classes = useStyles();

    const [film, setFilm] = React.useState([]);

    useEffect(() => {
        getAllFilmByCategory('best').then(response => {
            setFilm(response.data[0])
        });
    }, [])

    return (
        <div style={{ position: 'relative' }}>
            <img src={film.posterPath} alt="" style={{ position: 'relative', maxHeight: 500, width: '100%', objectFit: "cover" }} />
            <div className={classes.showBtn}>
                <Button
                    variant='contained'
                    component={Link}
                    to={'/films/' + film.id}
                    startIcon={<PlayArrowRoundedIcon />}
                >
                    Preview
                </Button>
            </div>
            <div className={classes.title}>
                <Typography
                    variant='h3'
                    style={{ fontWeight: 900 }}
                    color='white'>
                    {film.title}
                </Typography>
                <Typography
                    className={classes.description}
                    variant='h6'
                    color='white'>
                    {film.year} - {film.author} - {film.duration} min
                </Typography>
            </div>
        </div>
    );
}



export default Carousel;