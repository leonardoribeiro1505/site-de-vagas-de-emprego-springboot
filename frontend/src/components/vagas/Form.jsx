import React from 'react'
import { Form, Input, Button, DatePicker, Select, InputNumber } from 'antd';
import locale from 'antd/lib/date-picker/locale/pt_BR';
import axios from 'axios';

const FormItem = Form.Item;
const Option = Select.Option;

const formItemLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8 },
};
const formTailLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8, offset: 4 },
};

const baseUrl = 'http://localhost:3003/api/vagas'
const initialState = {
  vagas: {nomeCargo: '', tipoContratacao: '', cargaHoraria: '', salario: '', inicioExibicao: '', fimExibicao: '', descricao: ''},
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
          console.log("Valor passado: ", value)
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
      rules: [{ required: false, message: 'Por favor informe o tempo de exibição!' }],
    };
    
    const { getFieldDecorator } = this.props.form;
    return (
      <Form>
        <br/>
        <center><h1>Incluir uma nova vaga</h1></center>
        <FormItem {...formItemLayout} label="Cargo">
          {getFieldDecorator('nomeCargo', {
            rules: [{
              required: true,
              message: 'Por favor informe o nome do cargo',
            }],
          })(
            <Input placeholder="Ex.: Analista de sistemas" />
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
              type="number" />
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
              type="number" />
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
            <Input.TextArea rows={6} placeholder="Por favor informe os detalhes da vaga" />
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