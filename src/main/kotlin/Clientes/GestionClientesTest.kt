package org.practicatrim2.Clientes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//funciona fuera de este repositorio
class GestionClientesTest {

    @Test
    fun validarDni() {
        val gestionClientes = GestionClientes()
        assertEquals(true, gestionClientes.validarDni("7823723827387"))
        assertEquals(true, gestionClientes.validarDni("87a87237e"))
        assertEquals(false, gestionClientes.validarDni("43567762L"))
    }
}