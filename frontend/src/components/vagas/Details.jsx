import React from 'react'
import { List } from 'antd';
import axios from 'axios';

const baseUrl = `http://localhost:3002/api/vagas`
export default class DetailsVaga extends React.Component {

    state = {
       
    }    
       
    render() {
                
        const data = baseUrl
        //console.log(this.props.match.params.id);

        return (

            <div style={{ marginLeft: 100, marginRight: 100 }}>
            <br/>
                <h3 style={{ marginBottom: 16 }}>Detalhes da vaga</h3>
                <List
                    header={<div>Cabeçalho</div>}
                    footer={<div>Footer</div>}
                    bordered
                    dataSource={data}
                    renderItem={item => (<List.Item>{''}</List.Item>)}
                />
            </div>

        );
    }
}
