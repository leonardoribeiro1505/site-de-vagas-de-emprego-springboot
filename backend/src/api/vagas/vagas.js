const restful = require('node-restful')
const mongoose = restful.mongoose

const vagasSchema = new mongoose.Schema({
    nomeCargo: {  type: String, required: true },
    tipoContratacao: {  type: String, required: true },
    cargaHoraria: {  type: String, required: false },
    salario: {  type: String, required: false },
    tempoExibicao: {  type: Date, required: true },
    descricao: {  type: String, required: true },
})

module.exports = restful.model('Vagas', vagasSchema)