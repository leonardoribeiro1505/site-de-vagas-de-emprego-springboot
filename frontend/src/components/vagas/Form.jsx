import React from 'react'
import { Form, Input, Button, DatePicker, Select, InputNumber } from 'antd';
import axios from 'axios';

const FormItem = Form.Item;
const RangePicker = DatePicker.RangePicker;
const Option = Select.Option;

const formItemLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8 },
};
const formTailLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8, offset: 4 },
};

const baseUrl = 'http://localhost:3001/api/vagas'
const initialState = {
  vagas: {nomeCargo: '', tipoContratacao: '', cargaHoraria: '', salario: '', tempoExibicao: '', descricao: ''},
  list: []
}

class CadVagasForm extends React.Component {
 
    state = {
      ...initialState
    }

  clear() {
    this.setState({vagas: initialState.vagas})
  }

  save() {
    const vaga = this.state.vagas
    const method = vaga.id ? 'put' : 'post'
    const url = vaga.id ? `${baseUrl}/${vaga.id}` : baseUrl
    axios[method](url, vaga)
    .then(resp => {
      const list = this.getUpdatedList(resp.data)
      this.setState({vaga: initialState.vagas, list})
    })
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        const nomeCargo = this.state.vagas.nomeCargo
          axios.post(baseUrl, {nomeCargo})
        console.log('Received values of form: ', values);
      }
    });
  }
  
  getUpdatedList(vaga) {
    const list = this.state.list.filter(v => v.id !== vaga.id)
    list.unshift(vaga)
    return list
  }
  
  updateField(event) {
    const vagas = {...this.state.vagas}
    vagas[event.target.nomeCargo] = event.target.value
    this.setState({vagas})
  }

  handlerAdd() {
    this.props.form.validateFields(
      (err) => {
        if (!err) {
          const nomeCargo = this.state.vagas.nomeCargo
          const tipoContratacao = this.state.vagas.tipoContratacao
          const cargaHoraria = this.state.vagas.cargaHoraria
          const salario = this.state.vagas.salario
          const tempoExibicao = this.state.vagas.tempoExibicao
          const descricao = this.state.vagas.descricao
          axios.post(baseUrl, {nomeCargo, tipoContratacao, cargaHoraria, salario, tempoExibicao, descricao})
            .then(resp => console.log('Deu certo'))
        }
      },
    );
  }

  render() {
    const rangeConfig = {
      rules: [{ type: 'array', required: false, message: 'Por favor informe o tempo de exibição!' }],
    };
    
    const { getFieldDecorator } = this.props.form;
    return (
      <Form onSubmit={this.handleSubmit}>
        <br/>
        <center><h1>Incluir uma nova vaga</h1></center>
        <FormItem {...formItemLayout} label="Cargo">
          {getFieldDecorator('nomeCargo', {
            rules: [{
              required: true,
              message: 'Por favor informe o nome do cargo',
            }],
          })(
            <Input onChange={e => this.updateField(e)} placeholder="Por favor informe o nome do cargo" />
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
              <Option value="emprego">Emprego</Option>
              <Option value="estagio">Estágio</Option>
              <Option value="trainee">Trainee</Option>
              <Option value="temporario">Temporário</Option>
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
            <InputNumber 
              style={{ width: 454 }}
              parser={value => parseInt(value.replace(/\D/g, '') || '0', 80)} 
              formatter={value => `${value} horas por semana`} />
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
              placeholder="Por favor informe o salário" />
          )}
        </FormItem>
        <FormItem
          {...formItemLayout}
          label="Tempo de Exibição"
        >
          {getFieldDecorator('tempoExibicao', rangeConfig)(
            <RangePicker showTime format="DD-MM-YYYY HH:mm:ss" placeholder={["Início de exibição", "Fim de exbição"]}/>
          )}
        </FormItem>
        <FormItem {...formItemLayout} label="Descrição da vaga">
          {getFieldDecorator('descricao', {
            rules: [{
              required: false,
              message: 'Por favor informe os detalhes da vaga',
            }],
          })(
            <Input.TextArea rows={6} placeholder="Por favor informe os detalhes da vaga" />
          )}
        </FormItem>
        <FormItem {...formTailLayout}>
          <Button type="primary" htmlType="submit">
            Salvar
          </Button>
          <Button type="secondary" onClick={e => this.clear(e)}>
            Limpar
          </Button>
        </FormItem>
<<<<<<< HEAD
        </Form>
=======
      </Form>
>>>>>>> 2c0b5ae6216a9ca4f14981705fe602317e5a1285
    );
  }
}

export default Form.create()(CadVagasForm);