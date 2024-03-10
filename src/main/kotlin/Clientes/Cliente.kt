package org.practicatrim2.Clientes

import org.practicatrim2.Polizas.TipoPoliza

data class Cliente(val nombre: String, val edad: Int, val dni: String, val telefono: Int, val polizas: MutableMap<String, TipoPoliza> = mutableMapOf())