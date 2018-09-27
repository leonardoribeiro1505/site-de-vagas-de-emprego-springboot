import React from 'react'
import { Button, Modal, Form, Input, Icon, Checkbox } from 'antd';
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'

import { login, signup } from './authActions'
import Messages from '../../template/msg/messages'
import CadLoginForm from './CadLoginForm'
import PageHeader from '../../template/pageHeader'

const FormItem = Form.Item;

const CollectionCreateForm = Form.create()(
  class extends React.Component {
    
    render() {
      const { visible, onCancel } = this.props;
      return (
        <Modal
        visible={visible}
        title="Cadastro de novo usuário"
        okButtonDisabled={true}
        cancelText="Fechar"
        onCancel={onCancel}
        footer={null}
        >
          <CadLoginForm />
        </Modal>
      );
    }
  }
  );
  
  class Auth extends React.Component {
      constructor(props) {
        super(props)
        this.state = {loginMode: true}
      }
    
    state = {
      visible: false,
      title: 'Login de usuário'
    };

  changeMode() {
    this.setState({ loginMode: !this.state.loginMode })
  }

  onSubmit(values) {
    const { login, signup } = this.props
    login(values)
  }

  componentDidUpdate(){
    document.title = this.state.title
  }  

  showModal = () => {
    this.setState({ visible: true });
  }

  handleCancel = () => {
    this.setState({ visible: false });
  }

  login = (e) => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.onsubmit(values)
        console.log('Received values of form: ', values);
      }
    });
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    const { loginMode } = this.state 
    const { handleSubmit } = this.props
    return (
      <center>
        <PageHeader name={this.state.title}/>
        <br/>
          <Form onSubmit={handleSubmit(v => this.login(v))} className="login-form" style={{ width: 300 }}>
            <FormItem>
              {getFieldDecorator('userName', {
                rules: [{
                  type: 'email', 
                  required: true, message: 'Por favor insira seu e-mail!' }],
              })(
                <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="E-mail" />
              )}
            </FormItem>
            <FormItem>
              {getFieldDecorator('password', {
                rules: [{ required: true, message: 'Por favor insira sua senha!' }],
              })(
                <Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />} type="password" placeholder="Senha" />
              )}
            </FormItem>
            <FormItem>
              {getFieldDecorator('remember', {
                valuePropName: 'checked',
                initialValue: true,
              })(
                <Checkbox>Lembrar</Checkbox>
              )}
              <a className="login-form-forgot" href="">Esqueceu a senha</a>
              <br/>
              <Button style={{ width: 300 }} type="primary" htmlType="submit">
                Entrar
              </Button>
              <br/>
              Ou <a onClick={this.showModal}>Cadastre-se agora!</a>
            </FormItem>
          </Form>
          <CollectionCreateForm
            visible={this.state.visible}
            onCancel={this.handleCancel}
          />
          <Messages />
      </center>
    );
  }
}

Auth = Form.create()(Auth)
const mapDispatchToProps = dispatch => bindActionCreators({ login, signup }, dispatch)
export default connect(null, mapDispatchToProps)(Auth)