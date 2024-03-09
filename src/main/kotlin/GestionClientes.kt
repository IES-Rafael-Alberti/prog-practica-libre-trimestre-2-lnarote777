package org.practicatrim2

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


class GestionClientes {

    private val path = "src/main/kotlin/baseDatos/Clientes.txt"
    private val archivo = File(path)

    private val datosClientes = mutableListOf<Cliente>() //Resguardo de los clientes

    val mensaje: String
        get() = "*** No puede dejar este campo en blanco ***"


    fun altaCliente(cliente: Cliente){

        try {
            val fileWriter = FileWriter(archivo, true)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(cliente.toString())
            bufferedWriter.newLine()
            bufferedWriter.close()

            println("Cliente añadido correctamente")

        }catch (e: Exception){
            println("***Error - al añadir cliente***")
        }

    }

    fun bajaCliente(cliente: Cliente){

        try {
            val lineas = archivo.readLines().filter { !it.contains(cliente.toString()) }
            archivo.writeText(lineas.joinToString("\n"))
            println("cliente eliminado")

        }catch (e: Exception){
            println("*** Error Interno ***")
        }


    }

    fun listadoClientes(){

        val clientes = archivo.readLines()

        println("LISTADO CLIENTES")
        clientes.forEach { println(it) }

    }

    fun buscarCliente(dni: String): Boolean? {
        if(archivo.exists()){
            archivo.forEachLine { cliente ->
                if (cliente.contains(dni)){
                    return@forEachLine
                }
            }
            println("No se encontro ningun cliente con el dni: $dni")
            return false
        }else{
            println("*** Error en la base de datos - No se encontro el archivo ***")
            return null
        }
    }

    /**
    * Solicita al usuario introducir los datos de un cliente, incluyendo nombre, DNI y teléfono(s).
    * Recolecta estos datos mediante llamadas a funciones auxiliares.
    * @return El cliente creado con los datos proporcionados por el usuario.
    */
    fun pedirDatosCliente(): Cliente {

        var cliente: Cliente

        val nombre = pedirNombre()
        val dni = pedirDni()
        val telefono = pedirTelefono()

        cliente = Cliente(nombre, dni, telefono)

        return cliente

    }

    /**
     * Solicita al usuario introducir el nombre completo.
     * El nombre no puede estar en blanco.
     * @return El nombre completo proporcionado por el usuario.
     */
    private fun pedirNombre(): String{

        var nombre: String

        while(true){

            print("Nombre completo: ")
            nombre = readln().capitalizar()
            if (nombre.isBlank()) {
                println("**Error - El nombre no puede estar en blanco**")
            }else{
                break
            }
        }

        return nombre
    }

    /**
     * Solicita al usuario introducir el DNI.
     * El DNI no puede estar en blanco y debe tener 9 caracteres, incluyendo 8 dígitos y una letra.
     * @return El DNI proporcionado por el usuario.
     */
    private fun pedirDni(): String{
        var dni : String

        while (true){
            print("DNI: ")
            dni = readln().uppercase()
            if (dni.isBlank()) {
                println(mensaje)
            }else if (dni.length != 9) {
                println("** Error - El dni debe tener 9 caracteres**")
            }else if (!dni.substring(0,7).all { it.isDigit() }){
                println("*** Error - formato de DNI incorrecto ***")
            }else if (!dni.last().isLetter()){
                println("*** Error - formato de DNI incorrect")
            }else{
                break
            }
        }
        return dni
    }
    
    /**
     * Solicita al usuario introducir uno o varios números de teléfono separados por ' / '.
     * Devuelve una lista de números de teléfono introducidos.
     * Si no se introducen teléfonos o se produce un error, solicita al usuario que reintente.
     * @return Lista de números de teléfono introducidos.
     */
    fun pedirTelefono(): List<String>{

        var telefonos: List<String>

        while (true){


            print("Teléfono(s) **Introducir los teléfonos separados asi: ' / '**: ")
            telefonos = readln().split("/")
            if (telefonos.isEmpty()){
                println("***Instroduzca al menos un teléfono.")
            }else if (!telefonos.all { it -> it.substring(0,8).all { it.isDigit() } }){
                println("*** Error - Debe introducir un número de teléfono válido.")
            }else if (!telefonos.all { it -> it.length == 9 }){
                println("Error - Introduzca un número válido")
            }
            else{
                break
            }

        }

        return telefonos
    }


    fun clienteExistente(cliente: Cliente): Boolean{

        val dni = cliente.dni

        if (buscarCliente(dni) != null && buscarCliente(dni) == true){
            return true
        }else{
            return false
        }

    }

}
