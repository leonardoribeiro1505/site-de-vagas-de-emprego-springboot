const Usuarios = require('./usuarios')

Usuarios.methods(['get', 'post', 'put', 'delete'])
Usuarios.updateOptions({new: true, runValidators: true})

module.exports = Usuarios