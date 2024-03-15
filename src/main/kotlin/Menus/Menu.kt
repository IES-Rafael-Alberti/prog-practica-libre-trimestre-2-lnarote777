package org.practicatrim2.Menus

import org.practicatrim2.Consola

/**
 * Interfaz genérica que representa un menú en la aplicación.
 *
 * @param T El tipo de dato que se espera como respuesta del menú.
 */
interface Menu <T> {
    val consola: Consola<String>
        get() = Consola()

    fun menu()
    fun respuesta(): T

}
