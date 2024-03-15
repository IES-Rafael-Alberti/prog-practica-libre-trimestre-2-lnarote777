package org.practicatrim2.Polizas

import org.practicatrim2.Clientes.GestionClientes
import org.practicatrim2.capitalizar

/**
 * Clase que representa una póliza de seguro para una vivienda.
 *
 * @property gestor El gestor de clientes asociado a la póliza.
 */
class PolizaHogar ( gestor: GestionClientes): Poliza(gestor) {

    /**
     * Registra una nueva póliza en el sistema.
     * Se solicitan los datos del cliente, se genera un ID único para la póliza, se obtiene la fecha de alta,
     * y se almacenan estos datos junto con los datos específicos de la póliza en el sistema.
     * Finalmente, se guarda la información de la póliza en el archivo de registro.
     */
    override fun grabarPoliza() {
        val datosCliente = gestor.pedirDatosCliente()
        val tipoPoliza = TipoPoliza.HOGAR
        val id = generarId()
        val fecha = generarFechaAlta()

        datosCliente.polizas[id] = tipoPoliza

        val datosHogar = datosEspecificos()
        val datos = listOf(datosCliente, datosHogar, fecha)

        poliza[id] = datos
        gestor.altaCliente(datosCliente)

        guardarPoliza(poliza)

    }

    /**
     * Devuelve una lista mutable que contiene datos específicos sobre un hogar.
     * Se solicita al usuario que introduzca la dirección, el número de habitaciones,
     * el número de personas habitantes y el número de puertas del hogar.
     *
     * @return Una lista mutable que contiene los datos específicos del hogar.
     */
    override fun datosEspecificos(): MutableList<Any> {
        val hogar = mutableListOf<Any>()

        println("Introduzca los siguientes datos:")
        val direccion = pedirDireccicon()
        val habitaciones = pedirHabitaciones()
        val personasHabitantes = personasHabitantes()
        val nPuertas = pedirPuertas()

        hogar.add(direccion)
        hogar.add(habitaciones)
        hogar.add(personasHabitantes)
        hogar.add(nPuertas)

        return hogar
    }

    /**
     * Solicita al usuario que ingrese una dirección hasta que se proporcione una entrada no nula o no vacía.
     * La dirección proporcionada se capitaliza antes de devolverla.
     *
     * @return La dirección ingresada por el usuario, capitalizada.
     */
    private fun pedirDireccicon(): String{

        var direccion: String

        while (true){
            print("Dirección: ")
            direccion = consola.pedirDatos().capitalizar()
            if(direccion.isNullOrBlank()) {
                consola.mostrarInfo(gestor.mensaje)
            }else{
                break
            }
        }

        return direccion

    }

    /**
     * Solicita al usuario que introduzca el número de habitaciones, incluyendo el salón.
     * Se sigue solicitando al usuario hasta que se proporciona un número válido.
     *
     * @return El número de habitaciones ingresado por el usuario.
     */
    private fun pedirHabitaciones(): Int{
        var nHabitaciones: Int

        while (true){
            print("Número de habitaciones (Salón incluido): ")
            nHabitaciones = consola.pedirDatos().toIntOrNull() ?: continue
            if (nHabitaciones <= 0){
                consola.mostrarInfo("*** El número de habitaciones no puede ser negativo ***")
            }else if (nHabitaciones == null){
                consola.mostrarInfo(gestor.mensaje)
            }else{
                break
            }
        }

        return nHabitaciones
    }

    /**
     * Solicita al usuario que introduzca el número de personas que habitan la casa.
     * Continúa solicitando al usuario hasta que se proporcione un número válido (mayor o igual a cero).
     * Si la entrada no puede ser convertida a un número entero, se asume cero personas.
     *
     * @return El número de personas que habitan la casa, ingresado por el usuario. Si la entrada no es válida,
     *         se devuelve cero.
     */
    private fun personasHabitantes(): Int{

        var personas: Int

        while (true){
            print("Número de personas que habitan la casa: ")
            personas = consola.pedirDatos().toIntOrNull() ?: 0
            if (personas < 0){
                consola.mostrarInfo("*** El numero de personas no puede ser un número negativo ***")
            }else{
                break
            }
        }

        return personas
    }

    /**
     * Solicita al usuario que introduzca el número de puertas de acceso a la vivienda.
     * Continúa solicitando al usuario hasta que se proporcione un número válido (mayor que cero).
     * Si la entrada no puede ser convertida a un número entero, se muestra un mensaje de error y se solicita nuevamente.
     *
     * @return El número de puertas de acceso a la vivienda ingresado por el usuario.
     */
    private fun pedirPuertas(): Int{

        var puertas: Int

        while (true){
            print("Número de puertas de acceso a la vivienda: ")
            puertas = consola.pedirDatos().toIntOrNull() ?: continue
            if (puertas <= 0){
                consola.mostrarInfo("El numero de puertas no puede ser negativo ni 0")
            }else if (puertas == null){
                consola.mostrarInfo(gestor.mensaje)
            }else{
                break
            }
        }

        return puertas
    }

}