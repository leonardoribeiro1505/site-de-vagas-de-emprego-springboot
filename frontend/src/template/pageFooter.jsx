import React from 'react'

export default props =>
    <footer className='footer' style={{ textAlign: 'center' }}>
            <p style={{ color: '#FFFFFF' }}>
                {props.paragraph1}
                <strong>{props.featured}</strong>
                {props.paragraphKeep}
            </p>
            <p style={{ color: '#FFFFFF' }}>
                {props.paragraph2}
            </p>
    </footer>