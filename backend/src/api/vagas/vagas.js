const restful = require('node-restful')
const mongoose = restful.mongoose

const vagasSchema = new mongoose.Schema({
    nomeCargo: {  type: String, required: false },
    tipoContratacao: {  type: String, required: false },
    cargaHoraria: {  type: String, required: false },
    salario: {  type: String, required: false },
    inicioExibicao: {  type: Date, required: false },
    fimExibicao: {  type: Date, required: false },
    descricao: {  type: String, required: false }
})

module.exports = restful.model('Vagas', vagasSchema)