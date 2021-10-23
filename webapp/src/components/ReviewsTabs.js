import * as React from 'react';
import { useEffect, useState } from "react";
import { Typography } from "@mui/material";
import Skeleton from '@mui/material/Skeleton';
import Box from '@mui/material/Box';
import Tab from '@mui/material/Tab';
import Tabs from '@mui/material/Tabs';
import Rating from '@mui/material/Rating';
import { getReviewsFilmById } from '../api/rest/shopService';

/* DEPRECATED */

function TabPanel(props) {
    const { children, value, index, ...other } = props;

    return (
        <div
            role="tabpanel"
            hidden={value !== index}
            id={`simple-tabpanel-${index}`}
            aria-labelledby={`simple-tab-${index}`}
            {...other}
        >
            {value === index && (
                <Box sx={{ p: 3 }}>
                    <Typography>{children}</Typography>
                </Box>
            )}
        </div>
    );
}

function a11yProps(index) {
    return {
        id: `simple-tab-${index}`,
        'aria-controls': `simple-tabpanel-${index}`,
    };
}

export default function ReviewsTabs({ film }) {
    const [value, setValue] = useState(0);
    const [reviews, setReviews] = useState();

    useEffect(()=>{
        getReviewsFilmById(film.id).then(res =>{
            setReviews(res)
        });
    },[film]);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (

        <div style={{
            marginTop: '25px',
        }}>

            <div style={{ display: 'flex', alignItems: 'center' }}>
                <Typography
                    variant='h4'>
                    Reviews
                </Typography>
                {
                    !film ?
                        <Skeleton /> :
                        <Rating name="read-only" sx={{ marginLeft: '15px' }} value={film.score} readOnly />
                }
            </div>

            <Box sx={{ width: '100%' }}>
                <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
                    <Tabs value={value} onChange={handleChange} aria-label="basic tabs example">
                        <Tab label="Coming Soon" {...a11yProps(0)} />
                        <Tab label="IMBd" {...a11yProps(1)} />
                        <Tab label="MyMovies" {...a11yProps(2)} />
                    </Tabs>
                </Box>
                <TabPanel value={value} index={0}>
                    {reviews ? reviews[0].review : <Skeleton />}
                </TabPanel>
                <TabPanel value={value} index={1}>
                    {reviews ? reviews[1].review : <Skeleton />}
                </TabPanel>
                <TabPanel value={value} index={2}>
                    {reviews ? reviews[2].review : <Skeleton />}
                </TabPanel>
            </Box>
        </div>
    );
}