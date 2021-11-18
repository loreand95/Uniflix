import React, { useEffect } from "react";
import { ScrollMenu, VisibilityContext } from "react-horizontal-scrolling-menu";
import Button from "@mui/material/Button";
import FilmCard from "./FilmCard";
import ChevronLeftRoundedIcon from "@mui/icons-material/ChevronLeftRounded";
import ChevronRightRoundedIcon from "@mui/icons-material/ChevronRightRounded";
import { Typography } from "@mui/material";
import { getAllFilmByCategory } from "../api/rest/shopService";
import useMediaQuery from "@mui/material/useMediaQuery";
function CategoryCards({ categoryName }) {
  const [items, setItems] = React.useState([]);
  const [selected, setSelected] = React.useState([]);

  const isItemSelected = (id) => !!selected.find((el) => el === id);

  const handleClick =
    (id) =>
    ({ getItemById, scrollToItem }) => {
      const itemSelected = isItemSelected(id);

      setSelected((currentSelected) =>
        itemSelected
          ? currentSelected.filter((el) => el !== id)
          : currentSelected.concat(id)
      );
    };

  useEffect(() => {
    getAllFilmByCategory(categoryName).then((response) => {
      setItems(response.data);
    });
  }, [categoryName]);

  return (
    <div>
      <Typography
        style={{
          color: "white",
          marginTop: "15px",
          marginLeft: "15px",
          textTransform: "capitalize",
        }}
        variant="h5"
      >
        {categoryName}
      </Typography>
      <ScrollMenu
        LeftArrow={LeftArrow}
        RightArrow={RightArrow}
        style={{ overflowX: "hidden" }}
      >
        {items.map((film) => (
          <FilmCard
            itemId={film.movieId}
            key={film.movieId}
            film={film}
            onClick={handleClick(film.movieId)}
            selected={isItemSelected(film.movieId)}
          />
        ))}
      </ScrollMenu>
    </div>
  );
}

function Arrow({ children, disabled, onClick }) {
  return (
    <div style={{ display: "flex", justifyContent: "center" }}>
      <Button variant="default" disabled={disabled} onClick={onClick}>
        {children}
      </Button>
    </div>
  );
}

function LeftArrow() {
  const { isFirstItemVisible, scrollPrev } =
    React.useContext(VisibilityContext);

  const isMobile = useMediaQuery((theme) => theme.breakpoints.down("sm"));

  return isMobile ? null : (
    <Arrow disabled={isFirstItemVisible} onClick={() => scrollPrev()}>
      <ChevronLeftRoundedIcon style={{ color: "white" }} />
    </Arrow>
  );
}

function RightArrow() {
  const { isLastItemVisible, scrollNext } = React.useContext(VisibilityContext);

  const isMobile = useMediaQuery((theme) => theme.breakpoints.down("sm"));

  return isMobile ? null : (
    <Arrow disabled={isLastItemVisible} onClick={() => scrollNext()}>
      <ChevronRightRoundedIcon style={{ color: "white" }} />
    </Arrow>
  );
}

export default CategoryCards;
