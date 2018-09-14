import React from 'react'

import { HashRouter } from 'react-router-dom'
import MenuNav from '../template/MenuNav'
import Routes from './routes'

export default class App extends React.Component {
    render() {
        return (
            <HashRouter>
                <div className="container">
                    <MenuNav />
                    <Routes />
                </div>
            </HashRouter>
    )
    }
}
