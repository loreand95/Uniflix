import { Button } from "@mui/material";
import * as React from 'react';
import { useSelector } from 'react-redux';
import { useHistory } from "react-router-dom";
import BuyDialog from '../components/BuyDialog';

export default function BuyButton({ film , setFilm}) {

    const history = useHistory();
    const user = useSelector((state) => state.user);

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        //Check if user is logged
        if (!user.token) {
            history.push('/signin')
        }else{
            setOpen(true);
        }
    };

    const handleClose = (value) => {
        setOpen(false);
    };

    return (
        <>
            <BuyDialog
                open={open}
                onClose={handleClose}
                film={film}
                setFilm={setFilm}
            />
            <Button
                onClick={handleClickOpen}
                disabled={!!film.purchaseDate}
                sx={{ mt: 5, mb: 5, width: '200px' }}
                variant='contained'>
                {!!film.purchaseDate ? 'BOUGHT' : `BUY $ ${film.price}`}
            </Button>
        </>
    );
}