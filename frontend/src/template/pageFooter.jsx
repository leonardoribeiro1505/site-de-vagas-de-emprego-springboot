import React from 'react'

export default props =>
    <footer className='footer' style={{ background: '#363636',
        padding: '25px', 
        textAlign: 'center',
        position: 'fixed',
        bottom: '0px', 
        width: '100%',
        color: '#FFFFFF' }}>
            <p style={{ color: '#FFFFFF' }}>
                {props.paragraph1}
                <strong>{props.featured}</strong>
                {props.paragraphKeep}
            </p>
            <p style={{ color: '#FFFFFF' }}>
                {props.paragraph2}
            </p>
    </footer>