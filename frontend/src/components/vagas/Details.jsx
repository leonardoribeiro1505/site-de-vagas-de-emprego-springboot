import React from 'react'
import { List } from 'antd';

const baseUrl = 'http://localhost:3002/api/vagas'
export default class DetailsVaga extends React.Component {
    
    render() {       
        const data =  []
        console.log(data);

        return (

            <div style={{ marginLeft: 100, marginRight: 100 }}>
            <br/>
                <h3 style={{ marginBottom: 16 }}>Detalhes da vaga</h3>
                <List
                    header={<div>Header</div>}
                    footer={<div>Footer</div>}
                    bordered
                    dataSource={''}
                    renderItem={item => (<List.Item>{}</List.Item>)}
                />
            </div>

        );
    }
}
