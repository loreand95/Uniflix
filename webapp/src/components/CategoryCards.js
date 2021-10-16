import React, { useEffect } from "react";
import { ScrollMenu, VisibilityContext } from "react-horizontal-scrolling-menu";
import Button from '@mui/material/Button';
import FilmCard from './FilmCard';
import ChevronLeftRoundedIcon from '@mui/icons-material/ChevronLeftRounded';
import ChevronRightRoundedIcon from '@mui/icons-material/ChevronRightRounded';
import { Typography } from "@mui/material";
import {getAllFilmByCategory} from '../api/rest/shopService';


function CategoryCards({categoryName}) {
  const [items, setItems] = React.useState([]);
  const [selected, setSelected] = React.useState([]);

  const isItemSelected = (id) => !!selected.find((el) => el === id);

  const handleClick = (id) => ({ getItemById, scrollToItem }) => {
    const itemSelected = isItemSelected(id)

    setSelected((currentSelected) =>
      itemSelected
        ? currentSelected.filter((el) => el !== id)
        : currentSelected.concat(id)
    );
  }

  useEffect(()=>{
    getAllFilmByCategory(categoryName).then(response=>{
      setItems(response.data)
    });
  },[categoryName])

  return (
    <div>
      <Typography
        style={{
          color:'white',
          marginTop: '15px',
          marginLeft: '15px',
          textTransform: 'capitalize'
        }}
        variant='h5'
        >
       {categoryName}
      </Typography>
      <ScrollMenu
        LeftArrow={LeftArrow}
        RightArrow={RightArrow}
        style={{ overflowX: 'hidden' }}
      >
        {items.map((film) => (
          <FilmCard
            itemId={film.id}
            key={film.id}
            film ={film}
            onClick={handleClick(film.id)}
            selected={isItemSelected(film.id)}
          />)
        )}
      </ScrollMenu>
    </div>
  );
}

function Arrow({
  children,
  disabled,
  onClick
}) {
  return (
    <div style={{ display: 'flex', justifyContent: 'center' }}>
      <Button
        variant='default'
        disabled={disabled}
        onClick={onClick}
      >
        {children}
      </Button>
    </div>
  );
}

function LeftArrow() {
  const { isFirstItemVisible, scrollPrev } = React.useContext(VisibilityContext)

  return (
    <Arrow disabled={isFirstItemVisible} onClick={() => scrollPrev()}>
      <ChevronLeftRoundedIcon style={{color:'white'}}/>
    </Arrow>
  );
}

function RightArrow() {
  const { isLastItemVisible, scrollNext } = React.useContext(VisibilityContext)

  return (
    <Arrow disabled={isLastItemVisible} onClick={() => scrollNext()}>
      <ChevronRightRoundedIcon style={{color:'white'}}/>
    </Arrow>
  );
}

export default CategoryCards;