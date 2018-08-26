const restful = require('node-restful')
const mongoose = restful.mongoose

const vagasSchema = new mongoose.Schema({
    nomeCargo: {  type: String, required: true },
    tipoContratacao: {  type: String, required: false },
    cargaHoraria: {  type: String, required: false },
    salario: {  type: String, required: false },
    tempoExibicao: {  type: Date, required: false },
    descricao: {  type: String, required: false }
})

module.exports = restful.model('Vagas', vagasSchema)