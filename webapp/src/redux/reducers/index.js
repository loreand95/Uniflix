import userReducer from './userSlice'
import {combineReducers} from 'redux';

export default combineReducers({
    user: userReducer
});