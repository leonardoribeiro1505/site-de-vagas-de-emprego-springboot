import React from 'react'
import { Route, Switch, Redirect } from 'react-router-dom'

import VagasList from '../components/vagas/List'
import CadVagasForm from '../components/vagas/Form'
import About from '../about/about'
import Auth from '../components/auth/Form'
import DetailsVaga from '../components/vagas/Details'
import { isAuthenticated } from '../components/auth/auth'

const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route
      {...rest}
      render={props =>
        isAuthenticated() ? (
          <Component {...props} />
        ) : (
          <Redirect to={{ pathname: "/loginForm", state: { from: props.location } }} />
        )
      }
    />
  );

export default props =>
        <Switch>
            <Route exact path="/" component={VagasList} />
            <PrivateRoute path="/cadVagasForm" component={CadVagasForm} />
            <Route path="/loginForm" component={Auth} />
            <Route path="/about" component={About} />
            <Route path="/details/:id" component={DetailsVaga} />
        </Switch>
    