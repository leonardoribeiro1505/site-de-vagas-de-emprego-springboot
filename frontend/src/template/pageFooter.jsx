import React from 'react'

export default props =>
    <footer style={{ background: '#363636', 
        padding: '37px', 
        position: 'absolute',
        bottom: '0', 
        width: '100%', 
        color: '#FFFFFF' }}>
        <center>
            <p style={{ color: '#FFFFFF' }}>
                {props.paragraph1}
                <strong>{props.featured}</strong>
                {props.paragraphKeep}
            </p>
            <p style={{ color: '#FFFFFF' }}>
                {props.paragraph2}
            </p>
        </center>
    </footer>