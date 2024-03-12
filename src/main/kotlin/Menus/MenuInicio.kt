package org.practicatrim2.Menus

import org.practicatrim2.Consola

class MenuInicio: Menu<Int> {
    override fun menu() {
        val menu = "--------Bienvenido al portal de ocaso -----------\n\t1. Cliente existente\n\t2. Nuevo cliente\n\t0. Salir"
        Consola().mostrarInfo(menu)
    }

    override fun respuesta(): Int {
        print("--> ")
        val opcion = readln().toInt()

        return opcion
    }
}