package org.practicatrim2

import org.practicatrim2.Clientes.GestionClientes
import org.practicatrim2.Menus.MenuClienteExist
import org.practicatrim2.Menus.MenuInicio
import org.practicatrim2.Menus.MenuPolizas
import org.practicatrim2.Polizas.*


object GestionConsola {

    var terminar = false
    var atras = false
    val menuInicio = MenuInicio()
    val menuClienteExist = MenuClienteExist()
    val menuPolizas = MenuPolizas()
    val gestorClientes = GestionClientes()
    val poliza = PolizaMoto(gestorClientes)


    fun inicio (){

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
                            println("Dni no encontrado. No hay ningún cliente con dni: $dni")
                            continue
                        }
                    }
                    2 -> menuPolizas()
                    0 -> terminar = true
                    else -> println("Opción no válida")

                }
            }catch (e: Exception){
                println(e)
            }

        }

    }

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
                }

            }catch (e: Exception){
                print(e)
            }


        }
    }

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
                    else -> println("Opción no válida.")
                }
            }catch (e: Exception){
                println(e)
            }

        }
    }



}