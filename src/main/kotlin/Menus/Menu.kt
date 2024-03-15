package org.practicatrim2.Menus

import org.practicatrim2.Consola


interface Menu <T> {
    val consola: Consola<String>
        get() = Consola()

    fun menu()
    fun respuesta(): T

}
