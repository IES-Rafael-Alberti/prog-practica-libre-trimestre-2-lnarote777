package org.practicatrim2

import org.practicatrim2.Clientes.GestionClientes
import org.practicatrim2.Polizas.PolizaMoto


fun String.capitalizar(): String{
    var palabrasFrase = this.split(" ")
    val frase = mutableListOf<String>()
    for (i in palabrasFrase){
        val mayuscula = i.capitalize()
        frase.add(mayuscula)
    }
    return frase.joinToString(" ")
}


fun main() {

    // Se cargan los archivos guardados antes de empezar
    val gestionClientes = GestionClientes()
    val polizas = PolizaMoto(gestionClientes) //solo es para llamar a la funcion
    gestionClientes.guardarClientesDelArchivo()
    polizas.guardarPolizasDelArchivo()

    GestionMenu.inicio()


}

