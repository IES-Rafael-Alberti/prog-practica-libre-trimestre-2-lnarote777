package org.practicatrim2.Polizas

import org.practicatrim2.Cliente
import org.practicatrim2.GestionClientes
import org.practicatrim2.capitalizar

class PolizaMoto : Poliza() {

    val clientes = mutableMapOf<Cliente, MutableList<String>>()

    override fun generarId(): String {
        var id : String

        val numero1 = (1..999).random().toString()
        val numero2 = (1..999).random().toString()

        id = "$numero1-$numero2"

        return id
    }


    override fun grabarPoliza(cliente: GestionClientes) {
        val datosCliente = cliente.pedirDatosCliente()

        val tipoPoliza = TipoPoliza.MOTO

        datosCliente.polizas.addLast(tipoPoliza)

        val datosMoto = datosEspecificos()

        clientes[datosCliente] = datosMoto

    }

    override fun datosEspecificos(): MutableList<String> {

        val moto = mutableListOf<String>()
        val matricula = pedirMatricula()
        val marca = pedirMarca()
        val modelo = pedirModelo()

        moto.add(matricula)
        moto.add(marca)
        moto.add(modelo)

        return moto

    }

    private fun pedirMatricula(): String{

        var matricula: String

        while (true){
            print("Matrícula de la moto a asegurar: ")
            matricula = readln().uppercase()
            if (matricula.isBlank()){
                println(mensaje)
            }else if (matricula.length != 7){
                println("*** Matrícula inválida. Asegurese de que tenga 7 caracteres(4 números y 3 letras) ***")
            }else if (!matricula.substring(0,3).all { it.isDigit() }){
                println("Los primeros 4 caracteres deben ser numeros" )
            }else if (!matricula.substring(4,6).all { it.isLetter() }){
                println("Los ultimos 3 caracteres deben ser letras")
            }else{
                break
            }
        }

        return matricula
    }

    private fun pedirMarca(): String{

        var marca: String

        while (true){
            println("Marca: ")
            marca = readln().capitalizar()
            if (marca.isBlank()){
                println(mensaje)
            }else{
                break
            }
        }

        return marca
    }

    private fun pedirModelo(): String {
        var modelo: String

        while (true){
            println("Marca: ")
            modelo = readln().capitalizar()
            if (modelo.isBlank()){
                println(mensaje)
            }else{
                break
            }
        }

        return modelo
    }

    override fun toString(): String {
        return super.toString()
    }
}