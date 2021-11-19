import { Container, Typography } from "@mui/material";
import Skeleton from "@mui/material/Skeleton";
import * as React from "react";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ActorScrollCards from "../components/ActorScrollCards";
import BuyButton from "../components/BuyButton";
import UserReviews from "../components/UserReviews";
import BaseLayout from "./BaseLayout";
import { useDispatch } from 'react-redux';
import { getMovieAction } from '../redux/reducers/userSlice';

export default function FilmPage() {
  const dispatch = useDispatch();

  const { id } = useParams();

  const [film, setFilm] = useState();


  useEffect(() => {
    console.log(film)
  }, [film]);

  useEffect(() => {
    if (id) {
      dispatch(getMovieAction(id)).then((res) => {
        setFilm(res)
      }).catch(e =>{
        console.log(e)
      })
    }
  }, [dispatch,id]);

  return (
    <BaseLayout>
      <div style={{ textAlign: "center" }}>
        {film ? (
          <img
            alt={film.title}
            style={{ width: "100%", height: "400px", objectFit: "cover" }}
            src={film.backdropPath}
          />
        ) : (
          <div
            style={{
              textAlign: "center",
              margin: "0 auto",
            }}
          >
            <Skeleton variant="rectangular" height={400} />
          </div>
        )}
        <div
          style={{
            margin: "0 auto",
            marginTop: "15px",
          }}
        >
          <Typography variant="h3">
            {film ? (
              film.title
            ) : (
              <Skeleton sx={{ margin: "auto" }} width={400} />
            )}
          </Typography>
          <Typography variant="h6">
            {film ? (
              `${film.releaseDate?.substr(0, 4)} - ${film.genres[0].name}`
            ) : (
              <Skeleton sx={{ margin: "auto" }} width={400} />
            )}
          </Typography>
          {film && <BuyButton film={film} setFilm={setFilm}/>}
        </div>
      </div>
      <Container maxWidth="md">
        <div style={{ textAlign: "justify" }}>
          <Typography variant="h4">Description</Typography>
          <Typography variant="body">
            {film ? (
              film.overview
            ) : (
              <>
                <Skeleton />
                <Skeleton />
                <Skeleton />
                <Skeleton />
              </>
            )}
          </Typography>
        </div>
        <div style={{ margin: "0 auto" }}>
          {film && film.cast && <ActorScrollCards cast={film.cast} />}
          {film && film.reviews && <UserReviews reviews={film.reviews} />}
        </div>
      </Container>
    </BaseLayout>
  );
}
