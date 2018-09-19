import React from 'react'
import { List } from 'antd';

export default class DetailsVaga extends React.Component {

    render() {

        const data = [
            'Racing car sprays burning fuel into crowd.',
            'Japanese princess to wed commoner.',
            'Australian walks 100km after outback crash.',
            'Man charged over missing wedding girl.',
            'Los Angeles battles huge wildfires.',
        ];

        return (

            <div style={{ marginLeft: 100, marginRight: 100 }}>
                <h3 style={{ marginBottom: 16 }}>Default Size</h3>
                <List
                    header={<div>Header</div>}
                    footer={<div>Footer</div>}
                    bordered
                    dataSource={data}
                    renderItem={item => (<List.Item>{item}</List.Item>)}
                />
            </div>

        );
    }
}
