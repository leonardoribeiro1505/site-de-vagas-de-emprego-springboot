import React, { Component } from 'react'
import { Avatar, Popover, Button } from 'antd'
import { logout } from '../components/auth/auth'

export default class Navbar extends Component {

    render() {
        return (
            <content style={{ float: 'right' }}>
                <Popover
                    content={<a href="" onClick={logout}>Sair</a>} 
                    title={'email'} 
                    trigger="click">
                    <Avatar icon="user" />
                    <Button>
                        {'email'}
                    </Button>
                </Popover>
            </content>
        )
    }
}
