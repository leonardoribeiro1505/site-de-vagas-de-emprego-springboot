import React from 'react'

export default props =>
    <header style={{ background: '#3498db', padding: '30px' }}>
        <center>
            <h1 style={{ color: '#FFFFFF' }}>
                {props.name}
            </h1>
        </center>
    </header>