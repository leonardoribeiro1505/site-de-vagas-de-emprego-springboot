import React, { Component } from 'react' 
import axios from 'axios'
import { connect } from 'react-redux' 
import { bindActionCreators } from 'redux'

import CadVagasForm from '../components/vagas/Form'
import Auth from '../components/auth/Form'
import { validateToken } from '../components/auth/authActions'

class AuthOrCadVagasForm extends Component {

    componentWillMount() {
        if (this.props.auth.user) {
            this.props.validateToken(this.props.auth.user.token)
        }
    }

    render() {
        const { user, validToken } = this.props.auth

        if (user && validToken) {
            axios.defaults.headers.common['authorization'] = user.token 
            return <CadVagasForm>{this.props.children}</CadVagasForm>
        } else if (!user && !validToken) {
            return <Auth />
        } else {
            return false
        }
    }
}

const mapStateToProps = state => ({ auth: state.auth })
const mapDispatchToProps = dispatch => bindActionCreators({ validateToken }, dispatch)
export default connect(mapStateToProps, mapDispatchToProps)(AuthOrCadVagasForm)