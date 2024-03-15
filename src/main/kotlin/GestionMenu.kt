package org.practicatrim2

import org.practicatrim2.Clientes.GestionClientes
import org.practicatrim2.Menus.MenuClienteExist
import org.practicatrim2.Menus.MenuInicio
import org.practicatrim2.Menus.MenuPolizas
import org.practicatrim2.Polizas.*

/**
 * Objeto que gestiona el flujo de menús de la aplicación.
 */
object GestionMenu{

    var terminar = false
    var atras = false
    val menuInicio = MenuInicio()
    val menuClienteExist = MenuClienteExist()
    val menuPolizas = MenuPolizas()
    val gestorClientes = GestionClientes()
    val poliza = PolizaMoto(gestorClientes)
    val consola = Consola<String>()
    val mensajeOpcion = "Opción no válida"
    val mensajeExcepcion = "**ERROR - Error interno**"

    /**
     * Función que representa el inicio de la aplicación.
     * Proporciona un bucle de inicio que continúa hasta que se decide terminar.
     */
    fun inicio(){

        while (!terminar){
            try {
                menuInicio.menu()
                val opcion = menuInicio.respuesta()

                when(opcion){
                    1 -> {
                        val dni = gestorClientes.pedirDni()
                        if (gestorClientes.clienteExistente(dni)){
                            menuClienteExist()
                        }else{
                            consola.mostrarInfo("Dni no encontrado. No hay ningún cliente con dni: $dni")
                            continue
                        }
                    }
                    2 -> menuPolizas()
                    0 -> terminar = true
                    else -> consola.mostrarInfo(mensajeOpcion)

                }
            }catch (e: Exception){
                consola.mostrarInfo(mensajeExcepcion)
            }

        }

    }

    /**
     * Función que representa el menú para clientes existentes.
     * Proporciona un bucle de menú que continúa hasta que se decide volver atrás.
     */
    fun menuClienteExist(){

        while (!terminar){
            try {
                menuClienteExist.menu()
                val opcion = menuClienteExist.respuesta()

                when (opcion){
                    1 -> menuPolizas()
                    2 -> {
                        val dni = gestorClientes.pedirDni()
                        gestorClientes.bajaCliente(dni)
                    }
                    3 -> {
                        val dni = gestorClientes.pedirDni()
                        poliza.mostrarPoliza(dni)
                    }
                    4 -> {
                        val dni = gestorClientes.pedirDni()
                        if (gestorClientes.clienteExistente(dni)){
                            println(gestorClientes.buscarCliente(dni))
                        }
                    }
                    else -> consola.mostrarInfo(mensajeOpcion)
                }

            }catch (e: Exception){
                consola.mostrarInfo(mensajeExcepcion)
            }


        }
    }

    /**
     * Función que representa el menú para la gestión de pólizas.
     * Proporciona un bucle de menú que continúa hasta que se decide volver atrás.
     */
    fun menuPolizas(){
        while (!atras){
            try {
                menuPolizas.menu()
                val opcion = menuPolizas.respuesta()

                when(opcion){
                    1 -> PolizaDeceso(gestorClientes).grabarPoliza()
                    2 -> PolizaHogar(gestorClientes).grabarPoliza()
                    3 -> PolizaVida(gestorClientes).grabarPoliza()
                    4 -> PolizaMoto(gestorClientes).grabarPoliza()
                    5 -> PolizaCoche(gestorClientes).grabarPoliza()
                    0 -> atras = true
                    else -> consola.mostrarInfo(mensajeOpcion)
                }
            }catch (e: Exception){
                consola.mostrarInfo(mensajeExcepcion)
            }

        }
    }



}