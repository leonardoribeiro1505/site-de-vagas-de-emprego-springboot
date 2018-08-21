const Vagas = require('./vagas')

Vagas.methods(['get', 'post', 'put', 'delete'])
Vagas.updateOptions({new: true, runValidators: true})

module.exports = Vagas