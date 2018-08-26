import React from 'react'
import { Route, Switch, HashRouter } from 'react-router-dom'

import VagasList from '../components/vagas/List'
import CadVagasForm from '../components/vagas/Form'
import About from '../about/about'

export default props =>
    <HashRouter>
        <Switch>
            <Route path="/vagasList" component={VagasList} />
            <Route path="/cadVagasForm" component={CadVagasForm} />
            <Route path="/about" component={About} />
        </Switch>
    </HashRouter>