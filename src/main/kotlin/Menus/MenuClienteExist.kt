package org.practicatrim2.Menus


class MenuClienteExist: Menu<Int> {
    override fun menu() {
        val menu = "----Bienvenido de nuevo, elija  una opción:\n\t1. Contratar nueva póliza\n\t2. Darse de baja de Ocaso\n\t3. Ver pólizas contratadas\n\t4. Ver estado cliente\n\t0. Atrás"
        consola.mostrarInfo(menu)
    }

    override fun respuesta(): Int {

        print("--> ")
        val opcion = consola.pedirOpcion()
        return opcion
    }


}