import React from 'react'
import { List, Card } from 'antd';
import axios from 'axios';
import imageAvatar from '../../assets/images/mslogo.jpg'
import { Link } from 'react-router-dom'

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
        const listData = this.state.list
        return (
            <center>
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
                            cover={<Link to={`/details/${item._id}`}><img width="238" alt="imagemDaEmpresa" src={imageAvatar} /></Link>}
                        >
                            <Meta
                            title={<Link to={`/details/${item._id}`}>{item.nomeCargo}</Link>}
                            description={<Link to={`/details/${item._id}`}>Contratação: {item.tipoContratacao}</Link>}
                            />
                        </Card>
                    )}
                    />
            </center>
        );
    }
}
