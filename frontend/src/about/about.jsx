import React from 'react'
import { Row, Col, Card, Avatar, Icon } from 'antd';
import imageAvatar from '../assets/images/avatar.png'

const { Meta } = Card;

export default props =>

    <div>
        <div style={{ background: '#3498db', padding: '30px', color: '#FFFFFF' }}>
        <center>
            <p>SAIBA UM POUCO MAIS SOBRE NÓS</p>
            <p>SOMOS UM SITE PARA ANÚNCIO DE VAGAS DE EMPREGO</p>
        </center>
        </div>
        <br/>
        <div style={{ background: '#ECECEC', padding: '30px' }}>

            <Row gutter={16}>
                <Col span={6}>
                    <Card
                        style={{ width: 300, marginTop: 16 }}
                        actions={[<Icon type="linkedin" />, <Icon type="facebook" />, <Icon type="mail" />]}
                    >
                        <Meta
                            avatar={<Avatar src={imageAvatar} size={64}/>}
                            title="Leonardo Ribeiro"
                            description="This is the description"
                        />
                    </Card>
                </Col>
                <Col span={6}>
                <Card
                        style={{ width: 300, marginTop: 16 }}
                        actions={[<Icon type="linkedin" />, <Icon type="facebook" />, <Icon type="mail" />]}
                    >
                        <Meta
                            avatar={<Avatar src={imageAvatar} size={64} />}
                            title="Renato Braúna"
                            description="This is the description"
                        />
                    </Card>
                </Col>
                <Col span={6}>
                <Card
                        style={{ width: 300, marginTop: 16 }}
                        actions={[<Icon type="linkedin" />, <Icon type="facebook" />, <Icon type="mail" />]}
                    >
                        <Meta
                            avatar={<Avatar src={imageAvatar} size={64} />}
                            title="Júnior"
                            description="This is the description"
                        />
                    </Card>
                </Col>
                <Col span={6}>
                <Card
                        style={{ width: 300, marginTop: 16 }}
                        actions={[<Icon type="linkedin" />, <Icon type="facebook" />, <Icon type="mail" />]}
                    >
                        <Meta
                            avatar={<Avatar src={imageAvatar} size={64} />}
                            title="Card title"
                            description="This is the description"
                        />
                    </Card>
                </Col>
            </Row>
        </div>
    </div>
