import { combineReducers } from 'redux'
import { reducer as toastrReducer } from 'react-redux-toastr'

import AuthReducer from '../components/auth/authReducer'

const rootReducer = combineReducers({
    auth: AuthReducer,
    toastr: toastrReducer
})

export default rootReducer