import React from 'react'

export default props =>
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand" href="#/">Vagas</a>
        <div className="collapse navbar-collapse" id="navbarText">
            <ul className="navbar-nav mr-auto">
                <li className="nav-item active">
                    <a className="nav-link" href="#/vagas">Vagas</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#/about">Sobre</a>
                </li>
            </ul>
        </div>
    </nav>
