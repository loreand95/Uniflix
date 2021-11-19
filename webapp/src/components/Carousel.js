import React from "react";
import { Button, Typography } from "@mui/material";
import { makeStyles } from "@mui/styles";
import PlayArrowRoundedIcon from "@mui/icons-material/PlayArrowRounded";
import { Link } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  showBtn: { position: "absolute", right: "50px", bottom: "30px" },
  title: { position: "absolute", left: "5%", top: "40%" },
  description: {
    fontWeight: 900,
    [theme.breakpoints.down("sm")]: {
      visibility: "hidden",
    },
  },
}));

function Carousel({ film }) {
  const classes = useStyles();

  return (
    <div style={{ position: "relative" }}>
      <img
        src={film.posterPath}
        alt=""
        style={{
          position: "relative",
          maxHeight: 500,
          width: "100%",
          objectFit: "cover",
        }}
      />
      <div className={classes.showBtn}>
        <Button
          variant="contained"
          component={Link}
          to={"/films/" + film.movieId}
          startIcon={<PlayArrowRoundedIcon />}
        >
          Preview
        </Button>
      </div>
      <div className={classes.title}>
        <Typography variant="h3" style={{ fontWeight: 900 }} color="white">
          {film.title}
        </Typography>
        <Typography className={classes.description} variant="h6" color="white">
          {film.releaseDate?.substr(0,4)} - {film.duration || 120} min
        </Typography>
      </div>
    </div>
  );
}

export default Carousel;
