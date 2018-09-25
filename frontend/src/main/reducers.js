import { combineReducers } from 'redux'

import AuthReducer from '../components/auth/authReducer'

const rootReducer = combineReducers({
    auth: AuthReducer
})

export default rootReducer