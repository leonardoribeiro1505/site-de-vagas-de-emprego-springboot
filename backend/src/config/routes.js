const express = require('express')

module.exports = function(server) {

    //API Routes
    const router = express.Router()
    server.use('/api', router)

    //VAGAS Routes
    const vagasService = require('../api/vagas/vagasService')
    vagasService.register(router, '/vagas')

    //USUARIOS Routes
    const usuariosService = require('../api/login/usuariosService')
    usuariosService.register(router, '/usuarios')
}