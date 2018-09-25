import React from 'react'
import { Layout } from 'antd';
import { BrowserRouter } from 'react-router-dom'
import MenuNav from '../template/MenuNav'
import Routes from './routes'
import PageFooter from '../template/pageFooter'
import Messages from '../template/msg/messages'

const { Footer, Content } = Layout;

export default class App extends React.Component {
    render() {
        return (        
            <BrowserRouter>
                <Layout>
                    <MenuNav />
                        <Content>
                            <Routes />
                        </Content>
                    <Footer style={{ background: '#363636' }}>
                        <PageFooter  
                            paragraph1='&copy; Copyrights '
                            featured=' EquipeVagasDeEmprego. '
                            paragraphKeep='Todos os direitos reservados'
                            paragraph2='Desenvolvido na disciplina de Tecnologias para Internet II' />
                    </Footer>
                    <Messages />
                </Layout>
            </BrowserRouter>
    )
    }
}
