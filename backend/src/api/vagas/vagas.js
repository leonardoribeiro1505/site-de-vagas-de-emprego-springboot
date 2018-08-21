const restful = require('node-restful')
const mongoose = restful.mongoose

const vagasSchema = new mongoose.Schema({
    description: {  type: String, required: true },
    done: { type: Boolean, required: true, default: false }
})

module.exports = restful.model('Vagas', vagasSchema)