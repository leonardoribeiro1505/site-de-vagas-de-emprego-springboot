import React from 'react'
import { Button, Modal, Form, Input, Icon, Checkbox } from 'antd';
import CadLoginForm from './CadLoginForm'

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
        >
          <CadLoginForm />
        </Modal>
      );
    }
  }
);

class LoginForm extends React.Component {
  state = {
    visible: false,
  };

  clear = () => {
    this.props.form.resetFields();
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
        console.log('Received values of form: ', values);
      }
    });
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <center>
        <br/>
        <br/>
        <div style={{ width: 300 }} >
        <h1>Login de usuário</h1>
          <Form onSubmit={this.handleSubmit} className="login-form">
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
              <Button style={{ width: 300 }} type="primary" onClick={e => this.login(e)}>
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
        </div>
      </center>
    );
  }
}

export default Form.create()(LoginForm);