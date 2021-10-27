import { Container, Typography } from "@mui/material";
import Skeleton from '@mui/material/Skeleton';
import * as React from 'react';
import { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';
import { getActorsFetch } from '../api/rest/filmService';
import { getFilmById } from '../api/rest/shopService';
import ActorScrollCards from '../components/ActorScrollCards';
import BuyButton from '../components/BuyButton';
import UserReviews from '../components/UserReviews';
import BaseLayout from "./BaseLayout";

export default function FilmPage({ data }) {

    const { id } = useParams();

    const [film, setFilm] = useState();
    const [actors, setActors] = useState();

    useEffect(() => {
        if (id) {
            getFilmById(id).then(setFilm);
            getActorsFetch(id).then(setActors);
        }
    }, [id]);

    return (
        <BaseLayout>
            <Container maxWidth='xl'>
                <div style={{ textAlign: 'center' }}>
                    {
                        film ?
                            <img
                                alt={film.title}
                                style={{ width: '100%', height: '400px', objectFit: "cover" }}
                                src={'https://image.tmdb.org/t/p/original' + film.backdropPath}
                            />
                            :
                            <div style={{
                                maxWidth: '60%',
                                margin: '0 auto'
                            }}>
                                <Skeleton height={300} />
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
                        {film && <BuyButton film={film} />}
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
                    {film && actors && <ActorScrollCards actors={actors} />}
                    {film && <UserReviews movie={film} />}
                </div>
            </Container>
        </BaseLayout>
    );
}