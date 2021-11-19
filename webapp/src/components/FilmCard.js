import * as React from "react";
import { Paper, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles((theme) => ({
  paper: {
    margin: "10px",
    position: "relative",
    transition: "box-shadow .3s",
    "&:hover": {
      boxShadow: "0 0 13px #E50914",
    },
  },
  img: {
    borderRadius: "1%",
    position: "relative",
    maxWidth: 200,
    objectFit: "cover",
  },
  title: {
    bottom: "10px",
    left: "10px",
    position: "absolute",
  },
}));

export default function FilmCard({ film }) {
  const classes = useStyles();

  return (
    <Link to={`/films/${film.movieId}`}>
      <Paper className={classes.paper}>
        <img src={film.posterPath} className={classes.img} alt="movie" />
        <div className={classes.title}>
          <Typography variant="subtitle2" color="white">
          </Typography>
        </div>
      </Paper>
    </Link>
  );
}
