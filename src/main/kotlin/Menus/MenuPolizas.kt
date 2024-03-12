package org.practicatrim2.Menus

import org.practicatrim2.Consola

class MenuPolizas: Menu<Int> {
    override fun menu() {
        val menu = "--¿Qué tipo de póliza desea contratar?\n\t1. Deceso\n\t2. Hogar\n\t3. Vida\n\t5. Coche\n\t0. Atrás"
        Consola().mostrarInfo(menu)
    }

    override fun respuesta(): Int {

        print("--> ")
        val opcion = readln().toInt()

        return opcion
    }
}