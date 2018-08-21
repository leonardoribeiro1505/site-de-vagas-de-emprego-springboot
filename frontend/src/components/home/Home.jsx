import React from 'react'
import Main from '../template/Main'

export default props =>
    <Main icon="home" title="Início"
        subtitle="Testando o subtitulo." >
        <div className="display-4">Bem Vindo!</div>
        <hr />
        <p className="mb-0">Site de vagas de emprego, estágios, trainee e etc.</p>
    </Main>