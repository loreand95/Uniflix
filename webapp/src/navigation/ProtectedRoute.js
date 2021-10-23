import React from "react";
import { Redirect, Route } from "react-router-dom";
import { useSelector } from 'react-redux'

function ProtectedRoute({ component: Component, ...restOfProps }) {

  const user = useSelector((state) => state.user);

  const isAuthenticated = user.token;

  return (
    <Route
      {...restOfProps}
      render={(props) =>
        isAuthenticated ? <Component {...props} /> : <Redirect to="/signin" />
      }
    />
  );
}

export default ProtectedRoute;