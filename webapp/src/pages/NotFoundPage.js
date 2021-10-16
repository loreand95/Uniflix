import { Typography } from "@mui/material";
import BaseLayout from "./BaseLayout";

export default function NotFoundPage() {
    return (
        <BaseLayout>
            <div style={{
                display: 'flex',
                flexDirection: 'column',
                height: '100%',
                alignItems: 'center',
                justifyContent: 'center'
            }}>
                <Typography
                    variant='h1'>
                    404
                </Typography>
                <Typography
                    variant='h4'>
                    Page not found
                </Typography>
            </div>
        </BaseLayout>
    );
}