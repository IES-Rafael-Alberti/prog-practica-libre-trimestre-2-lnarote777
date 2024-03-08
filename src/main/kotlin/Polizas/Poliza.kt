package org.practicatrim2.Polizas

import org.practicatrim2.GestionClientes

interface Poliza {

    fun generarId()
    fun grabarPoliza(cliente: GestionClientes)
    fun datosEspecificos()

}