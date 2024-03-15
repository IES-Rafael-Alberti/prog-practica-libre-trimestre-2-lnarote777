package org.practicatrim2.Menus


class MenuInicio: Menu<Int> {
    override fun menu() {
        val menu = "--------Bienvenido al portal de ocaso -----------\n\t1. Cliente existente\n\t2. Nuevo cliente\n\t0. Salir"
        consola.mostrarInfo(menu)
    }

    /**
     * Obtiene la respuesta del usuario después de mostrar el menú.
     *
     * @return La opción seleccionada por el usuario.
     */
    override fun respuesta(): Int {
        print("--> ")
        val opcion = consola.pedirDatos().toInt()

        return opcion
    }
}