package org.practicatrim2.Polizas

import org.practicatrim2.GestionClientes

abstract class Poliza {

    val mensaje: String
        get() = "*** No puede dejar este campo en blanco ***"

    abstract fun generarId(): String
    abstract fun grabarPoliza(cliente: GestionClientes)
    abstract fun datosEspecificos() : MutableList<String>


}