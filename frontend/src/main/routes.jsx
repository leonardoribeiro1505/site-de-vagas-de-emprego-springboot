import React from 'react'
import { Route, Switch } from 'react-router-dom'

import VagasList from '../components/vagas/List'
import CadVagasForm from '../components/vagas/Form'
import About from '../about/about'
import LoginForm from '../components/login/Form'
import DetailsVaga from '../components/vagas/Details'

export default props =>
        <Switch>
            <Route exact path="/" component={VagasList} />
            <Route path="/cadVagasForm" component={CadVagasForm} />
            <Route path="/loginForm" component={LoginForm} />
            <Route path="/about" component={About} />
            <Route path="/details/:id" component={DetailsVaga} />
        </Switch>
    