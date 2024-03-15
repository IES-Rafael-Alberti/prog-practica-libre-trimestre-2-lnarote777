package org.practicatrim2.Clientes

import org.practicatrim2.Consola
import org.practicatrim2.Polizas.TipoPoliza
import org.practicatrim2.capitalizar
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

/**
 * Clase para gestionar clientes.
 * Permite añadir, dar de baja y buscar clientes, así como realizar operaciones de validación y manipulación de archivos.
 */
class GestionClientes {


    companion object{
        private val path = "src/main/kotlin/baseDatos/Clientes.txt"
        private val archivo = File(path)

        //Resguardo de los clientes. Cuando empieza el programa se cargan los clientes del archivo a la lista para operar más fácilmente
        private val datosClientes = mutableListOf<Cliente>()
    }

    val consola = Consola<String>()

    val mensaje: String
        get() = "*** No puede dejar este campo en blanco ***"

    /**
     * Añade un nuevo cliente al archivo de registro.
     *
     * @param cliente El cliente que se va a añadir al archivo de registro.
     */
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

    /**
     * Da de baja a un cliente con el DNI especificado.
     *
     * @param dni El número de DNI del cliente a dar de baja.
     */
    fun bajaCliente(dni: String){

        val cliente = buscarCliente(dni)
        try {
            if (cliente != null){
                datosClientes.remove(cliente)
                val lineas = archivo.readLines().filter { !it.contains(cliente.toString()) }
                archivo.writeText(lineas.joinToString("\n"))
                println("cliente eliminado")
            }else{
                println("No se pudo dar de baja porque no existe ningún cliente con dni: $dni")
            }

        }catch (e: Exception){
            println("*** Error Interno ***")
        }

    }

    /**
     * Busca un cliente por su número de DNI.
     *
     * @param dni El número de DNI del cliente a buscar.
     * @return El cliente correspondiente si se encuentra, o null si no se encuentra ningún cliente con ese DNI.
     */
    fun buscarCliente(dni: String): Cliente? = datosClientes.find { it.dni == dni }

    /**
    * Solicita al usuario introducir los datos de un cliente, incluyendo nombre, DNI y teléfono(s).
    * Recolecta estos datos mediante llamadas a funciones auxiliares.
    * @return El cliente creado con los datos proporcionados por el usuario.
    */
    fun pedirDatosCliente(): Cliente {

        var cliente: Cliente

        val nombre = pedirNombre()
        val edad = pedirEdad()
        val dni = pedirDni()
        val telefono = pedirTelefono()

        cliente = Cliente(nombre, edad, dni, telefono)

        return cliente

    }

    /**
     * Solicita al usuario que ingrese un nombre completo y lo devuelve como una cadena de texto.
     * Si el nombre ingresado está en blanco, se solicita nuevamente al usuario hasta que se proporcione un nombre válido.
     *
     * @return El nombre completo ingresado por el usuario.
     */
    private fun pedirNombre(): String{

        var nombre: String

        while(true){

            print("Nombre completo: ")
            nombre = consola.pedirDatos().capitalizar()
            if (nombre.isBlank()) {
                consola.mostrarInfo("**Error - El nombre no puede estar en blanco**")
            }else{
                break
            }
        }

        return nombre
    }

    /**
     * Solicita al usuario que ingrese un número de DNI y lo devuelve como una cadena de texto en mayúsculas.
     * Se solicita al usuario que ingrese el DNI hasta que se proporcione un número válido.
     *
     * @return El número de DNI ingresado por el usuario.
     */
    fun pedirDni(): String{
        var dni : String

        while (true){
            print("DNI: ")
            dni = consola.pedirDatos().uppercase()

            if (!validarDni(dni)){
                break
            }
        }
        return dni
    }

    /**
     * Valida un número de DNI.
     *
     * @param dni El número de DNI a validar.
     * @return true si el DNI es válido, false en caso contrario.
     */
    fun validarDni(dni: String): Boolean {

        return if (dni.isBlank()) {
            consola.mostrarInfo(mensaje)
            true
        }else if (dni.length != 9) {
            consola.mostrarInfo("** Error - El dni debe tener 9 caracteres**")
            true
        }else if (!dni.substring(0,7).all { it.isDigit() }){
            consola.mostrarInfo("*** Error - formato de DNI incorrecto ***")
            true
        }else if (!dni.last().isLetter()){
            consola.mostrarInfo("*** Error - formato de DNI incorrect")
            true
        }else{
            false
        }
    }

    /**
     * Solicita al usuario que ingrese un número de teléfono y lo devuelve como un entero.
     * Se solicita al usuario que ingrese el teléfono hasta que se proporcione un número válido.
     *
     * @return El número de teléfono ingresado por el usuario.
     */
    private fun pedirTelefono(): Int{

        var telefono: Int

        while (true){

            try {
                print("Teléfono ** Un telefono operativo **: ")
                telefono = consola.pedirDatos().toIntOrNull() ?: throw Exception()
                if (telefono == null){
                    consola.mostrarInfo(mensaje)
                }else if (telefono.toString().length != 9){
                    consola.mostrarInfo("*** Error - Debe introducir un número de teléfono válido y sin prefijo. ***")
                }else{
                    break
                }
            }catch (e: Exception){
                consola.mostrarInfo("*** Error - Introduzca un número válido ***")
            }

        }

        return telefono
    }

    /**
     * Solicita al usuario que introduzca su edad.
     * Se sigue solicitando al usuario hasta que se proporcione un número válido.
     * Se valida que la edad sea mayor o igual a 18 años.
     *
     * @return La edad ingresada por el usuario.
     */
    private fun pedirEdad(): Int {
        var edad: Int

        while (true){
            print("Edad:")
            edad = consola.pedirDatos().toIntOrNull() ?: continue
            if (edad < 18){
                println("Debe ser mayor de edad para contratar una póliza.")
            }else if (edad == null){
                consola.mostrarInfo(mensaje)
            }else{
                break
            }
        }

        return edad
    }

    /**
     * Verifica si un cliente con el número de DNI especificado ya existe en la lista de clientes.
     *
     * @param dni El número de DNI del cliente a verificar.
     * @return true si el cliente ya existe, false en caso contrario.
     */
    fun clienteExistente(dni: String): Boolean = if (buscarCliente(dni) != null) true else false

    /**
     * Lee los clientes del archivo y los agrega a la lista de clientes.
     *
     * @return La lista de clientes leída del archivo.
     */
    fun guardarClientesDelArchivo(): MutableList<Cliente> {

        archivo.forEachLine { linea ->
            val cliente = deStringACliente(linea)
            if (cliente != null) {
                datosClientes.add(cliente)
            } else {
                println("Error en el formato de la línea: $linea")
            }
        }

        return datosClientes
    }

    /**
     * Convierte una cadena de String del archivo en un objeto Cliente.
     *
     * @param linea La cadena que representa al cliente en el formato especificado.
     * @return El objeto Cliente correspondiente, o null si la cadena no tiene el formato esperado.
     */
    fun deStringACliente(linea: String): Cliente? {
        val partes = linea.split(",")

        if (partes.size == 5) {

            val nombre = partes[0].substringAfter("nombre=").trim()
            val edad = partes[1].substringAfter("edad=").trim().toInt()
            val dni = partes[2].substringAfter("dni=").trim()
            val telefonos = partes[3].substringAfter("telefono=").substringAfter("[").substringBefore("]").toInt()
            val polizasStr = partes[4].substringAfter("polizas=").substringAfter("{").substringBefore("}")
            val (idPoliza, tipoPolizaStr) = polizasStr.split("=")
            val tipoPoliza = when(tipoPolizaStr){
                "MOTO" -> TipoPoliza.MOTO
                "HOGAR" -> TipoPoliza.HOGAR
                "COCHE" -> TipoPoliza.COCHE
                "VIDA" -> TipoPoliza.VIDA
                "DECESO" -> TipoPoliza.DECESO
                else -> throw Exception("Tipo de póliza desconocido: $tipoPolizaStr")
            }
            val polizas = mutableMapOf(idPoliza to  tipoPoliza)

            return Cliente(nombre, edad, dni, telefonos, polizas)
        }
        return null
    }

}
