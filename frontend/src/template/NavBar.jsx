import React, { Component } from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import { logout } from '../components/auth/authActions'
import { Avatar, Popover, Button } from 'antd'

class Navbar extends Component {
    constructor(props) {
        super(props)
        this.state = { open: false }
    }

    changeOpen() {
        this.setState({ open: !this.state.open })
    }

    render() {
        const { email } = this.props.user
        return (
            <content style={{ float: 'right' }}>
            <Popover
                content={<a href="" onClick={this.props.logout}>Sair</a>} 
                title={email} 
                trigger="click">
                <Avatar icon="user" />
                <Button>
                    {email}
                </Button>
            </Popover>

            </content>
        )
    }
}
const mapStateToProps = state => ({ user: state.auth.user })
const mapDispatchToProps = dispatch => bindActionCreators({ logout }, dispatch)
export default connect(mapStateToProps, mapDispatchToProps)(Navbar)