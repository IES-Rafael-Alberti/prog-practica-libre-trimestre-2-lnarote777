package org.practicatrim2.Polizas

import org.practicatrim2.GestionClientes
import org.practicatrim2.capitalizar

class PolizaCoche(val gestor : GestionClientes): Poliza() {

    /**
     * Registra una nueva póliza en el sistema.
     * Se solicitan los datos del cliente, se genera un ID único para la póliza, se obtiene la fecha de alta,
     * y se almacenan estos datos junto con los datos específicos de la póliza en el sistema.
     * Finalmente, se guarda la información de la póliza en el archivo de registro.
     */
    override fun grabarPoliza() {
        val datosCliente = gestor.pedirDatosCliente()
        val tipoPoliza = TipoPoliza.COCHE
        val id = generarId()
        val fecha = generarFechaAlta()

        datosCliente.polizas[id] = tipoPoliza

        val datosCoche = datosEspecificos()
        val datos = listOf(datosCliente, datosCoche, fecha)

        polizas[id] = datos
        gestor.altaCliente(datosCliente)

        guardarPoliza(polizas)

    }

    /**
     * Recolecta los datos específicos de una póliza de coche, incluyendo la matrícula, marca y modelo.
     * Solicita al usuario introducir estos datos a través de la consola.
     * @return Una lista mutable que contiene la matrícula, marca y modelo del coche.
     */
    override fun datosEspecificos(): MutableList<String> {

        val coche = mutableListOf<String>()
        val matricula = pedirMatricula()
        val marca = pedirMarca()
        val modelo = pedirModelo()

        coche.add(matricula)
        coche.add(marca)
        coche.add(modelo)

        return coche

    }

    /**
     * Solicita al usuario introducir la matrícula de la moto a asegurar.
     * La matrícula debe tener 7 caracteres: 4 números seguidos de 3 letras.
     * @return La matrícula proporcionada por el usuario.
     */
    private fun pedirMatricula(): String{

        var matricula: String

        while (true){
            print("Matrícula de la moto a asegurar: ")
            matricula = readln().uppercase()
            if (matricula.isNullOrBlank()){
                println(gestor.mensaje)
            }else if (matricula.length != 7){
                println("*** Matrícula inválida. Asegurese de que tenga 7 caracteres(4 números y 3 letras) ***")
            }else if (!matricula.substring(0,3).all { it.isDigit() }){ //Comprueba si los 4 primeros caracteres son digitos
                println("Los primeros 4 caracteres deben ser numeros" )
            }else if (!matricula.substring(4,6).all { it.isLetter() }){ //Comprueba si los 3 ultimos caracteres son letras
                println("Los ultimos 3 caracteres deben ser letras")
            }else{
                break
            }
        }

        return matricula
    }

    /**
     * Solicita al usuario introducir la marca del objeto.
     * La marca no puede estar en blanco o nula.
     * @return La marca proporcionada por el usuario.
     */
    private fun pedirMarca(): String{

        var marca: String

        while (true){
            print("Marca: ")
            marca = readln().capitalizar()
            if (marca.isNullOrBlank()){
                println(gestor.mensaje)
            }else{
                break
            }
        }

        return marca
    }

    /**
     * Solicita al usuario introducir el modelo del objeto.
     * El modelo debe ser una cadena no vacía.
     * @return El modelo proporcionado por el usuario.
     */
    private fun pedirModelo(): String {
        var modelo: String

        while (true){
            print("Modelo: ")
            modelo = readln().capitalizar()
            if (modelo.isBlank()){
                println(gestor.mensaje)
            }else{
                break
            }
        }

        return modelo
    }

}