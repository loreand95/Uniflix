import { Button } from "@mui/material";
import * as React from 'react';
import { useSelector } from 'react-redux';
import { useHistory } from "react-router-dom";
import BuyDialog from '../components/BuyDialog';

const emails = ['username@gmail.com', 'user02@gmail.com'];

export default function BuyButton({ film }) {

    const history = useHistory();

    const user = useSelector((state) => state.user);

    const [open, setOpen] = React.useState(false);
    const [selectedValue, setSelectedValue] = React.useState(emails[1]);

    const handleClickOpen = () => {

        if (!user.token) {
            history.push('/signin')
        }

        setOpen(true);
    };

    const handleClose = (value) => {
        setOpen(false);
        setSelectedValue(value);
    };

    return (
        <>
            <BuyDialog
                selectedValue={selectedValue}
                open={open}
                onClose={handleClose}
                film={film}
            />
            <Button
                onClick={handleClickOpen}
                disabled={film.bought}
                sx={{ mt: 5, mb: 5, width: '200px' }}
                variant='contained'>
                {film.bought ? 'BOUGHT' : `BUY $ ${film.price}`}
            </Button>
        </>
    );
}