import React from 'react'
import { List, Card } from 'antd';
import axios from 'axios';
import imageAvatar from '../../assets/images/mslogo.jpg'

const { Meta } = Card;

const baseUrl = 'http://localhost:3002/api/vagas'
export default class VagasList extends React.Component {

    state = {
        
    };

    componentWillMount() {
        axios(baseUrl).then(resp => {
          this.setState({ list: resp.data })
        })
      }

    render() {
        console.log(this.state.list);
        const listData = this.state.list;
        return (
            <div style={{ marginLeft: 100, marginRight: 100 }}>
            <br/>
            <h1>Vagas disponíveis</h1>
            <br/>
                <List
                    itemLayout="horizontal"
                    dataSource={listData}
                    renderItem={item => (
                    <Card
                        hoverable
                        style={{ width: 240 }}
                        cover={<img alt="example" src={imageAvatar} />}
                    >
                        <Meta
                        title={item.nomeCargo}
                        description={`Contratação: ${item.tipoContratacao}`}
                        />
                    </Card>
                )}
                />
            </div>
        );
    }
}
