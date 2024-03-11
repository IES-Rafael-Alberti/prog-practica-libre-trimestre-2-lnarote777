package org.practicatrim2.Menus



class MenuClienteExist: Menu<Int> {
    override fun menu() {
        println("----Bienvenido de nuevo, elija  una opción:")
        println("\t1. Contratar nueva póliza")
        println("\t2. Darse de baja de Ocaso")
        println("\t3. Ver pólizas contratadas")
        println("\t4. Ver estado cliente")
        println("\t0. Atrás")
    }

    override fun respuesta(): Int {

        print("--> ")
        val opcion = readln().toInt()

        return opcion
    }


}