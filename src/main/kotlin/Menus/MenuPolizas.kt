package org.practicatrim2.Menus


class MenuPolizas: Menu<Int> {
    override fun menu() {
        val menu = "--¿Qué tipo de póliza desea contratar?\n\t1. Deceso\n\t2. Hogar\n\t3. Vida\n\t5. Coche\n\t0. Atrás"
        consola.mostrarInfo(menu)
    }

    override fun respuesta(): Int {

        print("--> ")
        val opcion = consola.pedirOpcion()

        return opcion
    }
}