package org.practicatrim2.Polizas

import org.practicatrim2.Cliente
import org.practicatrim2.GestionClientes

abstract class Poliza {

    val polizas = mutableMapOf<String, Pair<Cliente, MutableList<String>>>()



    fun generarId(): String{
        var id : String

        do {
            val numero1 = String.format("%03d" ,(1..999).random()) //si el numero aleatorio es menor de tres cifras le añade dos 0 delante
            val numero2 = String.format("%03d" ,(1..999).random())

            id = "$numero1-$numero2"

        }while (polizas.containsKey(id)) // mientras exista el id generado en el map de polizas generara un id distinto hasta que que no coincida conninguno existente (se asegura de no crear duplicados)

        return id
    }
    abstract fun grabarPoliza()
    abstract fun datosEspecificos() : MutableList<String>

    fun buscarPoliza(id: String): Pair<String, Pair<Cliente, MutableList<String>>>? {

        if (polizas.isNotEmpty() && polizas.containsKey(id)){
            val datosCliente = polizas.entries.find { it.key == id }?. key
            val datosPoliza = polizas.entries.find { it.key == id }?. value
            return Pair(datosCliente!!, datosPoliza!!)
        }else{
            println("No se encontró niguna póliza con el id: $id")
            return null
        }
    }

    fun mostrarPoliza(id: String){

        val poliza = buscarPoliza(id)

        println(poliza)

    }




}