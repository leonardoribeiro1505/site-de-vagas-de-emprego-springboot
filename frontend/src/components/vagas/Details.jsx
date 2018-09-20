import React from 'react'
import { List } from 'antd';
import axios from 'axios';

const baseUrl = `http://localhost:3002/api/vagas`
export default class DetailsVaga extends React.Component {
    
    state = {
        
    }
    
    render() {
        const id = this.props.match.params.id;
        const getData = axios(`${baseUrl}/${id}`)
        console.log(getData);
        
        return (

            <div style={{ marginLeft: 100, marginRight: 100 }}>
            <br/>
                <h3 style={{ marginBottom: 16 }}>Detalhes da vaga</h3>
                

            </div>

        );
    }
}
