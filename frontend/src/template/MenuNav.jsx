import React from 'react'
import { Menu, Icon } from 'antd'
import { Link } from 'react-router-dom'

export default class MenuNav extends React.Component {

  render() {
    return (
      <div>
        <Menu
          style={{ marginLeft: 100, marginRight: 100 }}
          defaultSelectedKeys={['1']}
          defaultOpenKeys={['sub1']}
          mode="horizontal"
        >
        
          <Menu.Item key="1">
            <Link to="/">
              <Icon type="home" />
              Home
            </Link>
          </Menu.Item>

          <Menu.Item key="2">
            <Link to="/cadVagasForm">
              <Icon type="plus" />
              Anunciar vaga
            </Link>
          </Menu.Item>

          <Menu.Item key="3">
            <Link to="/loginForm">
              <Icon type="user" />
              Login/Cadastre-se
            </Link>
          </Menu.Item>

          <Menu.Item key="4">
            <Link to="/about">
              <Icon type="info-circle" />
              Sobre
            </Link>
          </Menu.Item>
        </Menu>
      </div>
    );
  }
}

