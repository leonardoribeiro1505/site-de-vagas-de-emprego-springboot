import React from 'react'

import { BrowserRouter } from 'react-router-dom'
import MenuNav from '../template/MenuNav'
import Routes from './routes'

export default class App extends React.Component {
    render() {
        return (            
            <BrowserRouter>
                <div className="container">
                    <MenuNav />
                    <Routes />
                </div>
            </BrowserRouter>
    )
    }
}
