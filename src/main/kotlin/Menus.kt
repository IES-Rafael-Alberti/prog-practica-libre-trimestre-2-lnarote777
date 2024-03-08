package org.practicatrim2

interface Muenus {
    fun menu()
}

fun menuCliente(){

    println("1. Darse de alta en Ocaso")
    println("2. Darse de baja de Ocaso")
    println("3. Ver polizas contratadas")
    println("4. Ver estado cliente")

}

fun menu(){
    println("---------Bienvenido al portal de ocaso -----------")
    println("1. Cliente existente")
    println("2. Nuevo cliente")
}

fun menuPolizas(){
    println("-------Tipo de poliza------")
    println("1. Deceso")
    println("2. Hogar")
    println("3. Vida")
    println("4. Accidente")
}
