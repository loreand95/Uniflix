import { Button, Skeleton } from '@mui/material';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import * as React from 'react';
import moment from 'moment';
import { Link } from 'react-router-dom';


export default function LibraryTable({ movies }) {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Title</TableCell>
            <TableCell>Duration</TableCell>
            <TableCell>Purchase Date</TableCell>
            <TableCell>Price</TableCell>
            <TableCell></TableCell>
          </TableRow>
        </TableHead>
        {
          movies ?
            <TableBody>
              {movies.map((row) => (
                <TableRow
                  key={row.id}
                  sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                >
                  <TableCell>{row.title}</TableCell>
                  <TableCell>{row.duration}</TableCell>
                  <TableCell>{ moment(row.purchaseDate).format('DD/MM/YYYY')}</TableCell>
                  <TableCell>{row.price}</TableCell>
                  <TableCell>
                    <Button
                    component={Link}
                    to={'/films/' + row.id}>
                      Show
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody> :
            < LoadingTableBody />
        }
      </Table>
    </TableContainer>
  );
}

function LoadingTableBody() {
  return (
    <TableBody>
      {[...Array(5)].map((e, i) => (
        <TableRow key={i}>
          <TableCell><Skeleton /></TableCell>
          <TableCell><Skeleton /></TableCell>
          <TableCell><Skeleton /></TableCell>
          <TableCell><Skeleton /></TableCell>
          <TableCell><Skeleton /></TableCell>
        </TableRow>
      ))}
    </TableBody>
  );
}