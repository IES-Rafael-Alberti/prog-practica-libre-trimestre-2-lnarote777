package org.practicatrim2.Menus


class MenuPolizas: Menu<Int> {

    /**
     * Muestra el menú de opciones disponibles para la gestión de pólizas.
     */
    override fun menu() {
        val menu = "--¿Qué tipo de póliza desea contratar?\n\t1. Deceso\n\t2. Hogar\n\t3. Vida\n\t4. Moto\n\t5. Coche\n\t0. Atrás"
        consola.mostrarInfo(menu)
    }

    /**
     * Obtiene la respuesta del usuario después de mostrar el menú.
     *
     * @return La opción seleccionada por el usuario.
     */
    override fun respuesta(): Int {

        print("--> ")
        val opcion = consola.pedirOpcion()

        return opcion
    }
}