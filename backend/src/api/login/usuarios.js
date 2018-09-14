const restful = require('node-restful')
const mongoose = restful.mongoose

const usuariosSchema = new mongoose.Schema({
    email: {  type: String, required: false },
    senha: {  type: String, required: false },
    telefone: {  type: String, required: false },
    website: {  type: String, required: false },
})

module.exports = restful.model('Usuarios', usuariosSchema)