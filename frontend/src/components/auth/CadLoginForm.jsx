import React from 'react'
import { Form, Input, Select, Button, AutoComplete } from 'antd';
import axios from 'axios';
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import { login, signup } from './authActions'

const FormItem = Form.Item;
const Option = Select.Option;
const AutoCompleteOption = AutoComplete.Option;

const baseUrl = 'http://localhost:3002/oapi/usuarios'
const initialState = {
  usuarios: {email: '', senha: '', telefone: '', website: ''}
}
class CadLoginForm extends React.Component {

  state = {
    confirmDirty: false,
    autoCompleteResult: [],
    ...initialState
  };

  onSubmit(values) {
    const { login, signup } = this.props
    login(values)
}
  
  handleSubmit = (e) => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        this.onSubmit(values)
        this.clear()
      }
    });
  }

  clear = () => {
    this.props.form.resetFields();
  }
  
  handleCancel = () => {
    this.setState({ visible: false });
  }

  handleConfirmBlur = (e) => {
    const value = e.target.value;
    this.setState({ confirmDirty: this.state.confirmDirty || !!value });
  }

  compareToFirstPassword = (rule, value, callback) => {
    const form = this.props.form;
    if (value && value !== form.getFieldValue('senha')) {
      callback('Esta senha não confere com a anterior!');
    } else {
      callback();
    }
  }

  validateToNextPassword = (rule, value, callback) => {
    const form = this.props.form;
    if (value && this.state.confirmDirty) {
      form.validateFields(['confirm'], { force: true });
    }
    callback();
  }

  handleWebsiteChange = (value) => {
    let autoCompleteResult;
    if (!value) {
      autoCompleteResult = [];
    } else {
      autoCompleteResult = ['.com.br', '.com', '.org', '.net'].map(domain => `${value}${domain}`);
    }
    this.setState({ autoCompleteResult });
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    const { autoCompleteResult } = this.state;

    const formItemLayout = {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 8 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 16 },
      },
    };
    const tailFormItemLayout = {
      wrapperCol: {
        xs: {
          span: 24,
          offset: 0,
        },
        sm: {
          span: 16,
          offset: 8,
        },
      },
    };
    const prefixSelector = getFieldDecorator('prefix', {
      initialValue: '85',
    })(
      <Select style={{ width: 70 }}>
        <Option value="88">88</Option>
        <Option value="85">85</Option>
      </Select>
    );

    const websiteOptions = autoCompleteResult.map(website => (
      <AutoCompleteOption key={website}>{website}</AutoCompleteOption>
    ));

    return (
      <Form onSubmit={this.handleSubmit}>
        <FormItem
          {...formItemLayout}
          label="E-mail"
        >
          {getFieldDecorator('email', {
            rules: [{
              type: 'email', message: 'E-mail inválido!',
            }, {
              required: true, message: 'Por favor insira seu e-mail!',
            }],
          })(
            <Input />
          )}
        </FormItem>
        <FormItem
          {...formItemLayout}
          label="Senha"
        >
          {getFieldDecorator('senha', {
            rules: [{
              required: true, message: 'Por favor insira sua senha!',
            }, {
              validator: this.validateToNextPassword,
            }],
          })(
            <Input type="password" />
          )}
        </FormItem>
        <FormItem
          {...formItemLayout}
          label="Confirmar Senha"
        >
          {getFieldDecorator('confirm', {
            rules: [{
              required: true, message: 'Por favor confirme sua senha!',
            }, {
              validator: this.compareToFirstPassword,
            }],
          })(
            <Input type="password" onBlur={this.handleConfirmBlur} />
          )}
        </FormItem>
        <FormItem
          {...formItemLayout}
          label="Telefone"
        >
          {getFieldDecorator('telefone', {
            rules: [{ required: true, message: 'Por favor insira seu telefone de contato!' }],
          })(
            <Input addonBefore={prefixSelector} style={{ width: '100%' }} />
          )}
        </FormItem>
        <FormItem
          {...formItemLayout}
          label="Site"
        >
          {getFieldDecorator('website', {
            rules: [{ required: false }],
          })(
            <AutoComplete
              dataSource={websiteOptions}
              onChange={this.handleWebsiteChange}
              placeholder="www.meusite.com.br"
            >
              <Input />
            </AutoComplete>
          )}
        </FormItem>
        <FormItem {...tailFormItemLayout}>
          <Button type="primary" htmlType="submit">Cadastrar</Button>
        </FormItem>
      </Form>
    );
  }
}

const mapDispatchToProps = dispatch => bindActionCreators({ login, signup }, dispatch)
CadLoginForm = Form.create()(CadLoginForm)
export default connect(null, mapDispatchToProps)(CadLoginForm)