import React from 'react'
import { Route, Switch } from 'react-router-dom'

import VagasList from '../components/vagas/List'
import AuthOrCadVagasForm from './authOrCadVagasForm'
import About from '../about/about'
import Auth from '../components/auth/Form'
import DetailsVaga from '../components/vagas/Details'

export default props =>
        <Switch>
            <Route exact path="/" component={VagasList} />
            <Route path="/cadVagasForm" component={AuthOrCadVagasForm} />
            <Route path="/loginForm" component={Auth} />
            <Route path="/about" component={About} />
            <Route path="/details/:id" component={DetailsVaga} />
        </Switch>
    