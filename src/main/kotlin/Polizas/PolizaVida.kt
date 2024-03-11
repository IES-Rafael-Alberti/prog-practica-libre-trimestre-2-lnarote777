package org.practicatrim2.Polizas

import org.practicatrim2.Clientes.GestionClientes
import org.practicatrim2.capitalizar

/**
 * Clase que representa una póliza de seguro de vida.
 *
 * @property gestor El gestor de clientes asociado a la póliza.
 */
open class PolizaVida (val gestor : GestionClientes): Poliza() {

    /**
     * Registra una nueva póliza en el sistema.
     * Se solicitan los datos del cliente, se genera un ID único para la póliza, se obtiene la fecha de alta,
     * y se almacenan estos datos junto con los datos específicos de la póliza en el sistema.
     * Finalmente, se guarda la información de la póliza en el archivo de registro.
     */
    override fun grabarPoliza() {
        val datosCliente = gestor.pedirDatosCliente()
        val tipoPoliza = TipoPoliza.VIDA
        val id = generarId()
        val fecha = generarFechaAlta()

        datosCliente.polizas[id] = tipoPoliza

        val datosVida = datosEspecificos()
        val datos = listOf(datosCliente, datosVida, fecha)

        poliza[id] = datos
        gestor.altaCliente(datosCliente)

        guardarPoliza(poliza)

    }

    /**
     * Devuelve una lista mutable que contiene datos específicos sobre la salud de una persona.
     * Se solicita al usuario información sobre problemas de salud, altura y peso.
     *
     * @return Una lista mutable que contiene los datos específicos sobre la salud de la persona, incluyendo:
     *         - Información sobre problemas de salud ("Si" o "No").
     *         - Altura en centímetros.
     *         - Peso en kilogramos.
     */
    override fun datosEspecificos(): MutableList<Any> {

        val vida = mutableListOf<Any>()

        val salud = datoSalud()
        val altura = pedirAltura()
        val peso = pedirPeso()

        vida.add(salud)
        vida.add(altura)
        vida.add(peso)

        return vida
    }

    /**
     * Solicita al usuario información sobre si tiene problemas de salud.
     * Se sigue solicitando al usuario hasta que se proporcione una respuesta válida ("Si" o "No").
     *
     * @return Una cadena que indica si el usuario tiene problemas de salud ("Si" o "No").
     */
    protected fun datoSalud(): String{

        var salud: String

        while (true){
            print("¿Tiene problemas de salud? ")
            salud = readln().capitalizar()
            if (salud.isNullOrBlank()){
                println(gestor.mensaje)
            }else if (salud != "Si" && salud != "No"){
                println("*** Responda si o no por favor ***")
            }else{
                break
            }
        }

        return salud
    }

    /**
     * Solicita al usuario que introduzca su peso en kilogramos.
     * Se sigue solicitando al usuario hasta que se proporcione un número válido.
     *
     * @return El peso en kilogramos ingresado por el usuario como un valor de tipo Float.
     */
    protected fun pedirPeso(): Float{

        var peso: Float

        while (true){
            try {
                print("Introduzca su peso en Kg: ")
                peso = readln().format(".2f").toFloatOrNull() ?: continue
                if (peso == null){
                    print(gestor.mensaje)
                }else {
                    break
                }
            }catch (e: Exception){
                println("*** Introduzca un peso válido ***")
            }
        }

        return peso
    }

    /**
     * Solicita al usuario que introduzca su altura en centímetros.
     * Se sigue solicitando al usuario hasta que se proporcione un número válido (mayor que cero).
     *
     * @return La altura en centímetros ingresada por el usuario como un valor de tipo Int.
     */
    protected fun pedirAltura(): Int{

        var altura: Int

        while (true){
            print("Introduzca su altura en cm: ")
            altura = readln().toIntOrNull() ?: continue
            if (altura == null){
                println(gestor.mensaje)
            }else if (altura <= 0){
                println("*** La altura no puede ser negativa")
            }else{
                break
            }
        }

        return altura
    }

}