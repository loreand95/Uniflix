import {BrowserRouter as Router, Redirect, Route, Switch} from 'react-router-dom';
import HomePage from '../pages/HomePage';
import SignInPage from '../pages/SignInPage';
import SignUpPage from '../pages/SignUpPage';
import AccountPage from '../pages/AccountPage';
import FilmPage from '../pages/FilmPage';
import NotFoundPage from '../pages/NotFoundPage';

export default function Routes(){
    return(
        <Router>
            <Switch>
                <Route exact path="/">
                    <Redirect to="/home"/>
                </Route>
                <Route path="/signin" component={SignInPage} />
                <Route path="/signup" component={SignUpPage} />
                <Route path="/account" component={AccountPage} />
                <Route path="/films/:id" component={FilmPage} />
                <Route path="/home" component={HomePage} />
                <Route path="*">
                    <NotFoundPage />
                </Route>
            </Switch>
        </Router>
    );
}