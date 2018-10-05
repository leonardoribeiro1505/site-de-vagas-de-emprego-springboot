import React from 'react'
import { Button, Modal, Form, Input, Icon, Checkbox } from 'antd';
import CadLoginForm from './CadLoginForm'
import PageHeader from '../../template/pageHeader'
import api from './api'
import { login } from './auth'
import { withRouter } from 'react-router-dom'

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
    
    state = {
      visible: false,
      title: 'Login de usuário'
    };

  changeMode() {
    this.setState({ loginMode: !this.state.loginMode })
  }

  handleSignIn = () => {
    this.props.form.validateFields(
      (err, value) => {
        if (!err) {
          api.post("/login", value).then(response => {
            login(response.data)
              }
            )
        }
        this.props.history.push("/");
      },
    );
    
  }

  componentDidUpdate(){
    document.title = 'Login de usuário'
  }  

  showModal = () => {
    this.setState({ visible: true });
  }

  handleCancel = () => {
    this.setState({ visible: false });
  }

  handleSubimit = (e) => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.handleSignIn(values)
        //window.location.reload()
      }
    });
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <center>
        <PageHeader name={'Login de usuário'}/>
        <br/>
          <Form onSubmit={this.handleSubimit} className="login-form" style={{ width: 300 }}>
            <FormItem>
              {getFieldDecorator('email', {
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
      </center>
    );
  }
}

export default Auth = Form.create()(Auth)
withRouter(Auth)