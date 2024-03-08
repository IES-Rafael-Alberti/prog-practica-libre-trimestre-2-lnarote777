package org.practicatrim2

import org.practicatrim2.Polizas.TipoPoliza

data class Cliente(val nombre: String, val dni: String, val telefono: List<String>, val polizas: MutableList<TipoPoliza> = mutableListOf())