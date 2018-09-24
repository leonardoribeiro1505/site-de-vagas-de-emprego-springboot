const restful = require('node-restful')
const mongoose = restful.mongoose

const userSchema = new mongoose.Schema({
    email: { type: String, required: true },
    senha: { type: String, min: 6, max: 12, required: true },
    telefone: {  type: String, required: false },
    website: {  type: String, required: false },
})

module.exports = restful.model('User', userSchema)