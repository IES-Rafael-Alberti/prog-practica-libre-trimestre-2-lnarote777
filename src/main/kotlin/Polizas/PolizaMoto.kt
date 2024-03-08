package org.practicatrim2.Polizas

import org.practicatrim2.GestionClientes

class PolizaMoto : Poliza {

    override fun generarId() {
        var id : String

        val numero1 = (1..999).random().toString()
        val numero2 = (1..999).random().toString()

        id = "$numero1-$numero2"
    }

    override fun grabarPoliza(cliente: GestionClientes) {
        val datosCliente = cliente.pedirDatosCliente()

        val tipoPoliza = TipoPoliza.MOTO

        datosCliente.polizas.addLast(tipoPoliza)
    }

    override fun datosEspecificos(){

    }
}