import React from 'react'
import { BrowserRouter } from 'react-router-dom'
import MenuNav from '../template/MenuNav'
import Routes from './routes'
import PageFooter from '../template/pageFooter'

export default class App extends React.Component {
    render() {
        return (            
            <BrowserRouter>
                <div className="container">
                    <MenuNav />
                    <Routes />
                    <PageFooter  
                        paragraph1='&copy; Copyrights '
                        featured=' EquipeVagasDeEmprego. '
                        paragraphKeep='Todos os direitos reservados'
                        paragraph2='Desenvolvido na disciplina de Tecnologias para Internet II' />
                </div>
            </BrowserRouter>
    )
    }
}
