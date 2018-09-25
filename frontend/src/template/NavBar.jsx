import React, { Component } from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import { logout } from '../components/auth/authActions'
import { Card, Avatar } from 'antd'

const { Meta } = Card;
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
            <Card
                title={email}
                extra={<a href="" onClick={this.props.logout}>Sair</a>}
                style={{ width: 300 }}
            >
            <Meta
              avatar={<Avatar icon="user" />}
              title="Card title"
              description="This is the description"
            />
            </Card>
        )
    }
}
const mapStateToProps = state => ({ user: state.auth.user })
const mapDispatchToProps = dispatch => bindActionCreators({ logout }, dispatch)
export default connect(mapStateToProps, mapDispatchToProps)(Navbar)