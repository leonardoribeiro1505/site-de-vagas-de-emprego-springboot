import React from 'react'
import { Form, Input, Button, DatePicker, Select, InputNumber } from 'antd';
import locale from 'antd/lib/date-picker/locale/pt_BR';
import axios from 'axios';

const FormItem = Form.Item;
const Option = Select.Option;

const formItemLayout = {
  labelCol: { span: 9 },
  wrapperCol: { span: 8 },
};
const formTailLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8, offset: 9 },
};

const baseUrl = 'http://localhost:3002/api/vagas'
const initialState = {
  vagas: {nomeCargo: '', tipoContratacao: '', cargaHoraria: '', salario: '', inicioExibicao: '', fimExibicao: '', descricao: ''},
  list: []
}

class CadVagasForm extends React.Component {
 
    state = {
      ...initialState
    }

    componentWillMount() {
      axios(baseUrl).then(resp => {
        this.setState({ list: resp.data })
      })
    }

  clear = () => {
    this.props.form.resetFields();
  }

  save() {
    this.props.form.validateFields(
      (err, value) => {
        if (!err) {
          const vaga = this.state.vagas
          const method = vaga.id ? 'put' : 'post'
          const url = vaga.id ? `${baseUrl}/${vaga.id}` : baseUrl
          axios[method](url, value)
          .then(resp => {
            const list = this.getUpdatedList(resp.data)
            this.setState({vaga: initialState.vagas, list})
          })
          this.clear();
        }
      },
    );
  }

  updateField(event) {
    const vagas = {...this.state.vagas}
    vagas[event.target.getFieldDecorator] = event.target.value
    this.setState({vagas})
  }
 
  getUpdatedList(vaga) {
    const list = this.state.list.filter(v => v.id !== vaga.id)
    list.unshift(vaga)
    return list
  }

  render() {
    const rangeConfig = {
      rules: [{ required: false, message: 'Por favor informe o tempo de exibição!' }],
    };
    
    const { getFieldDecorator } = this.props.form;
    return (
      <Form>
        <br/>
        <center>
          <h1>Incluir uma nova vaga</h1>
        </center>
        <FormItem {...formItemLayout} label="Cargo">
          {getFieldDecorator('nomeCargo', {
            rules: [{
              required: true,
              message: 'Por favor informe o nome do cargo',
            }],
          })(
            <Input style={{ width: 454 }} placeholder="Ex.: Analista de sistemas" />
          )}
        </FormItem>
        <FormItem {...formItemLayout} label="Tipo de contratação">
          {getFieldDecorator('tipoContratacao', {
            rules: [{
              required: false,
              message: 'Por favor informe o tipo de contratação',
            }],
          })(
            <Select style={{ width: 454 }} placeholder="Por favor selecione o tipo de contratação">
              <Option value="Emprego">Emprego</Option>
              <Option value="Estágio">Estágio</Option>
              <Option value="Trainee">Trainee</Option>
              <Option value="Temporário">Temporário</Option>
            </Select>
          )}
        </FormItem>
        <FormItem {...formItemLayout} label="Carga horária">
          {getFieldDecorator('cargaHoraria', {
            rules: [{
              required: this.state.checkNick,
              message: 'Por favor informe a carga horária',
            }],
          })(
            <Select style={{ width: 454 }} placeholder="Por favor selecione a carga horária">
              <Option value="20">20 horas semanais</Option>
              <Option value="30">30 horas semanais</Option>
              <Option value="40">40 horas semanais</Option>
              <Option value="44">44 horas semanais</Option>
            </Select>
          )}
        </FormItem>
        <FormItem {...formItemLayout} label="Salário">
          {getFieldDecorator('salario', {
            rules: [{
              required: this.state.checkNick,
              message: 'Por favor informe o salário',
            }],
          })(
            <InputNumber 
              style={{ width: 454 }}
              placeholder="Por favor informe o salário" 
              formatter={value => `$ ${value}`.replace(/([0-9]{2})$/g, ",$1")}
               />
          )}
        </FormItem>
        <FormItem
          {...formItemLayout}
          label="Início de Exibição"
        >
          {getFieldDecorator('inicioExibicao', rangeConfig)(
            <DatePicker showTime format="DD-MM-YYYY" 
            locale={locale}
            style={{ width: 454 }}
            placeholder="Marque o dia que irá publicar" />
          )}
        </FormItem>
        <FormItem
          {...formItemLayout}
          label="Fim de Exibição"
        >
          {getFieldDecorator('fimExibicao', rangeConfig)(
            <DatePicker showTime format="DD-MM-YYYY" 
            locale={locale}
            style={{ width: 454 }}
            placeholder="Marque o dia do fim da publicação" />
          )}
        </FormItem>
        <FormItem {...formItemLayout} label="Descrição da vaga">
          {getFieldDecorator('descricao', {
            rules: [{
              required: false,
              message: 'Por favor informe os detalhes da vaga',
            }],
          })(
            <Input.TextArea style={{ width: 454 }} rows={6} placeholder="Por favor informe os detalhes da vaga" />
          )}
        </FormItem>
        <FormItem {...formTailLayout}>
          <Button type="primary" onClick={e => this.save(e)}>
            Salvar
          </Button>
          <Button type="secondary" onClick={e => this.clear(e)}>
            Limpar
          </Button>
        </FormItem>
        </Form>
    );
  }
}

export default Form.create()(CadVagasForm);