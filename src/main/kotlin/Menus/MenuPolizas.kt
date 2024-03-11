package org.practicatrim2.Menus

class MenuPolizas: Menu<Int> {
    override fun menu() {
        println("--¿Qué tipo de póliza desea contratar?")
        println("\t1. Deceso")
        println("\t2. Hogar")
        println("\t3. Vida")
        println("\t4. Moto")
        println("\t5. Coche")
        println("\t0. Atrás")
    }

    override fun respuesta(): Int {

        print("--> ")
        val opcion = readln().toInt()

        return opcion
    }
}