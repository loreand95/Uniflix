import * as React from 'react';
import BaseLayout from "./BaseLayout";
import { useParams } from 'react-router-dom';
import YouTube from 'react-youtube';
import { Button, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { getFilmById } from '../api/rest/shopService';
import Skeleton from '@mui/material/Skeleton';
import UserReviews from '../components/UserReviews';
import ActorScrollCards from '../components/ActorScrollCards';

export default function FilmPage({ data }) {

    const { id } = useParams();

    const [film, setFilm] = useState();

    useEffect(() => {
        if (id) {
            getFilmById(id).then(res => {
                setFilm(res)
            });
        }
    }, [id]);

    const opts = {
        height: '720',
        width: '60%',
        playerVars: {
            autoplay: 0,
            showinfo: 0
        },
    };

    return (
        <BaseLayout>
            <div style={{ textAlign: 'center', marginTop: '15px' }}>
                {
                    film ?
                        <div style={{ minHeight: '750px' }}>
                            <YouTube videoId="Ulws6xyu14A" opts={opts} />
                        </div>
                        :
                        <div style={{
                            maxWidth: '60%',
                            margin: '0 auto'
                        }}>
                            <Skeleton height={750} />
                        </div>

                }
                <div style={{
                    maxWidth: '60%',
                    margin: '0 auto',
                }}>
                    <Typography
                        variant='h3'>
                        {film ? film.title : <Skeleton />}
                    </Typography>
                    <Typography
                        variant='h6'>
                        {film ? `${film.author} - ${film.year} - ${film.duration} min` : <Skeleton />}
                    </Typography>
                    {film &&
                        <Button
                            sx={{ mt: 5, mb: 5, width: '200px' }}
                            variant='contained'>
                            BUY $ {film.price}
                        </Button>}
                    <div style={{
                        textAlign: 'justify'
                    }}>
                        <Typography
                            variant='h4'>
                            Description
                        </Typography>
                        <Typography
                            variant='body'>
                            {film ? film.overview : <Skeleton />}
                        </Typography>
                    </div>
                </div>
            </div>
            <div style={{
                    maxWidth: '60%',
                    margin: '0 auto',
                }}>
            {film && film.actors && <ActorScrollCards actors={film.actors}/> }
            {film && <UserReviews movie={film}/> }
            </div>
        </BaseLayout>
    );
}