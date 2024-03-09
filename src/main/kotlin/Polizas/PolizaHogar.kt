package org.practicatrim2.Polizas

import org.practicatrim2.GestionClientes

class PolizaHogar ( val gestor: GestionClientes): Poliza() {

    /**
     * Registra una nueva póliza en el sistema.
     * Se solicitan los datos del cliente, se genera un ID único para la póliza, se obtiene la fecha de alta,
     * y se almacenan estos datos junto con los datos específicos de la póliza en el sistema.
     * Finalmente, se guarda la información de la póliza en el archivo de registro.
     */
    override fun grabarPoliza() {
        val datosCliente = gestor.pedirDatosCliente()
        val tipoPoliza = TipoPoliza.HOGAR
        val id = generarId()
        val fecha = generarFechaAlta()

        datosCliente.polizas[id] = tipoPoliza

        val datosHogar = datosEspecificos()
        val datos = listOf(datosCliente, datosHogar, fecha)

        polizas[id] = datos
        gestor.altaCliente(datosCliente)

        guardarPoliza(polizas)

    }

    override fun datosEspecificos(): MutableList<String> {
        TODO("Not yet implemented")
    }


}