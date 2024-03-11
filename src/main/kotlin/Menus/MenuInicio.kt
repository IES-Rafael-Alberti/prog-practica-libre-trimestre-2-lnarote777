package org.practicatrim2.Menus

class MenuInicio: Menu<Int> {
    override fun menu() {
        println("---------Bienvenido al portal de ocaso -----------")
        println("\t1. Cliente existente")
        println("\t2. Nuevo cliente")
        println("\t0. Salir")
    }

    override fun respuesta(): Int {
        print("--> ")
        val opcion = readln().toInt()

        return opcion
    }
}