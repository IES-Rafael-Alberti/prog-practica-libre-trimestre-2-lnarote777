package org.practicatrim2

/**
 * Clase que proporciona métodos para interactuar con la consola.
 */
open class Consola <T>{

    /**
     * Muestra un mensaje en la consola.
     *
     * @param mensaje El mensaje a mostrar.
     */
    fun mostrarInfo(mensaje: T) {
        println(mensaje)
    }

    /**
     * Solicita al usuario que ingrese una opción y devuelve el valor ingresado como un entero.
     *
     * @return La opción ingresada por el usuario como un entero.
     */
    fun pedirOpcion(): Int {
        val opcion = readln().toInt()
        return opcion
    }

    /**
     * Solicita al usuario que ingrese datos y devuelve el valor ingresado como una cadena de texto.
     *
     * @return Los datos ingresados por el usuario como una cadena de texto.
     */
    fun pedirDatos(): String{
        val datos = readln()
        return datos

    }


}