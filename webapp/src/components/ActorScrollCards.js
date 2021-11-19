import React from "react";
import { ScrollMenu, VisibilityContext } from "react-horizontal-scrolling-menu";
import Button from '@mui/material/Button';
import ChevronLeftRoundedIcon from '@mui/icons-material/ChevronLeftRounded';
import ChevronRightRoundedIcon from '@mui/icons-material/ChevronRightRounded';
import { Typography } from "@mui/material";
import ActorCard from "./ActorCard";
import Box from '@mui/material/Box';

export default function ActorScrollCards({cast}) {
 
  const [items] = React.useState(cast);
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

  return (
    <Box sx={{mt:3}}>
      <Typography
        style={{
          color:'white',
          textTransform: 'capitalize'
        }}
        variant='h4'
        >
       Cast
      </Typography>
      <ScrollMenu
        LeftArrow={LeftArrow}
        RightArrow={RightArrow}
        style={{ overflowX: 'hidden' }}
      >
        {items.map((actor) => (
          <ActorCard
            itemId={actor.actorId}
            key={actor.actorId}
            actor ={actor}
            onClick={handleClick(actor.actorId)}
            selected={isItemSelected(actor.actorId)}
          />)
        )}
      </ScrollMenu>
    </Box>
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