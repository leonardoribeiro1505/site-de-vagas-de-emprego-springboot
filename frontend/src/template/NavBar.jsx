import React, { Component } from 'react'
import { Avatar, Popover, Button } from 'antd'

export default class Navbar extends Component {

    render() {
        const { email } = this.props.user || {}
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
