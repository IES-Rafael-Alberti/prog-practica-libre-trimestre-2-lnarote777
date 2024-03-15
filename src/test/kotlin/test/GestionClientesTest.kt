package test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.practicatrim2.Clientes.GestionClientes

class GestionClientesTest {

    @Test
    fun validarDni() {
        val gestor = GestionClientes()
        assertEquals(true, gestor.validarDni("7823723827387"))
        assertEquals(true, gestor.validarDni("87a87237e"))
        assertEquals(false, gestor.validarDni("43567762L"))
    }
}