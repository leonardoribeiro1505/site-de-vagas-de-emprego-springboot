import React from 'react'
import { Route, Switch, HashRouter } from 'react-router-dom'

import Vagas from '../vagas/vagas'
import About from '../about/about'

export default props =>
    <HashRouter>
        <Switch>
            <Route path="/vagas" component={Vagas} />
            <Route path="/about" component={About} />
        </Switch>
    </HashRouter>