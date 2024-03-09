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
            datosClientes.add(cliente)
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
            val lineas = archivo.readLines().toMutableList()
            val lineaEliminar = cliente.toString()
            if(lineas.remove(lineaEliminar)){
                archivo.writeText(lineas.joinToString("\n"))
            }else{
                println("No se encontró el cliente especificado")
            }
            datosClientes.remove(cliente)
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

    fun pedirDatosCliente(): Cliente {

        var cliente: Cliente

        val nombre = pedirNombre()
        val dni = pedirDni()
        val telefono = pedirTelefono()

        cliente = Cliente(nombre, dni, telefono)

        return cliente

    }

    private fun pedirNombre(): String{

        var nombre: String

        while(true){
            try {
                print("Nombre completo: ")
                nombre = readln().capitalizar()
                if (nombre.isBlank()) {
                    throw Exception("**Error - El nombre no puede estar en blanco**")
                }else{
                    break
                }

            }catch (e: Exception){
                println(e)
            }
        }

        return nombre
    }

    fun pedirDni(): String{
        var dni : String

        while (true){
            print("DNI: ")
            dni = readln().uppercase()
            if (dni.isBlank()) {
                print(mensaje)
            }else if (dni.length != 9) {
                throw Exception("** Error - El dni debe tener 9 caracteres**")
            }else if (!dni.substring(0,7).all { it.isDigit() }){

            }
            else{
                break
            }
        }
        return dni
    }

    private fun pedirTelefono(): List<String>{

        var telefonos: List<String>

        while (true){

            try {
                print("Teléfono(s) **Introducir los teléfonos separados asi: ' / '**: ")
                telefonos = readln().split(" / ")
                if (telefonos.isEmpty()){
                    throw Exception("***Instroduzca al menos un teléfono.")
                }else{
                    break
                }

            }catch (e: Exception){
                println(e)
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
