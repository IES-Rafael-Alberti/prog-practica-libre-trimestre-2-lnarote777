package org.practicatrim2.Polizas

import org.practicatrim2.Clientes.GestionClientes
import org.practicatrim2.capitalizar

class PolizaMoto(gestor : GestionClientes) : Poliza(gestor) {

    /**
     * Registra una nueva póliza en el sistema.
     * Se solicitan los datos del cliente, se genera un ID único para la póliza, se obtiene la fecha de alta,
     * y se almacenan estos datos junto con los datos específicos de la póliza en el sistema.
     * Finalmente, se guarda la información de la póliza en el archivo de registro.
     */
    override fun grabarPoliza() {
        val datosCliente = gestor.pedirDatosCliente()
        val tipoPoliza = TipoPoliza.MOTO
        val id = generarId()
        val fecha = generarFechaAlta()

        datosCliente.polizas[id] = tipoPoliza

        val datosMoto = datosEspecificos()
        val datos = listOf(datosCliente, datosMoto, fecha)

        poliza[id] = datos
        gestor.altaCliente(datosCliente)

        guardarPoliza(poliza)

    }

    /**
     * Recolecta los datos específicos de una póliza de moto, incluyendo la matrícula, marca y modelo.
     * Solicita al usuario introducir estos datos a través de la consola.
     * @return Una lista mutable que contiene la matrícula, marca y modelo de la moto.
     */
    override fun datosEspecificos(): MutableList<Any> {

        val moto = mutableListOf<Any>()
        val matricula = pedirMatricula()
        val marca = pedirMarca()
        val modelo = pedirModelo()

        moto.add(matricula)
        moto.add(marca)
        moto.add(modelo)

        return moto

    }

    /**
     * Solicita al usuario que ingrese la matrícula de una moto a asegurar y la devuelve como una cadena de texto en mayúsculas.
     * Se solicita al usuario que ingrese la matrícula hasta que se proporcione una válida.
     *
     * @return La matrícula de la moto ingresada por el usuario.
     */
    private fun pedirMatricula(): String{

        var matricula: String

        while (true){
            print("Matrícula de la moto a asegurar: ")
            matricula = consola.pedirDatos().uppercase()
            if (!validarMatricula(matricula)){
                break
            }
        }

        return matricula
    }

    /**
     * Valída una matrícula de vehículo.
     *
     * @param matricula La matrícula a validar.
     * @return true si la matrícula es válida, false en caso contrario.
     */
    private fun validarMatricula(matricula: String): Boolean{

        return if (matricula.isNullOrBlank()){
            consola.mostrarInfo(gestor.mensaje)
            true
        }else if (matricula.length != 7){
            consola.mostrarInfo("*** Matrícula inválida. Asegurese de que tenga 7 caracteres(4 números y 3 letras) ***")
            true
        }else if (!matricula.substring(0,3).all { it.isDigit() }){ //Comprueba si los 4 primeros caracteres son digitos
            consola.mostrarInfo("Los primeros 4 caracteres deben ser numeros" )
            true
        }else if (!matricula.substring(4,6).all { it.isLetter() }) { //Comprueba si los 3 ultimos caracteres son letras
            consola.mostrarInfo("Los ultimos 3 caracteres deben ser letras")
            true
        }else {
            false
        }
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
            marca = consola.pedirDatos().capitalizar()
            if (marca.isNullOrBlank()){
                consola.mostrarInfo(gestor.mensaje)
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
            modelo = consola.pedirDatos().capitalizar()
            if (modelo.isBlank()){
                consola.mostrarInfo(gestor.mensaje)
            }else{
                break
            }
        }

        return modelo
    }

}