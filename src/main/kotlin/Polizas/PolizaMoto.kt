package org.practicatrim2.Polizas

import org.practicatrim2.Cliente
import org.practicatrim2.GestionClientes
import org.practicatrim2.capitalizar

class PolizaMoto(val gestor :GestionClientes ) : Poliza() {


    override fun grabarPoliza() {
        val datosCliente = gestor.pedirDatosCliente()

        if (!gestor.clienteExistente(datosCliente)){
            gestor.altaCliente(datosCliente)
        }

        val tipoPoliza = TipoPoliza.MOTO

        val id = generarId()

        datosCliente.polizas[id] = tipoPoliza

        val datosMoto = datosEspecificos()
        val datos = Pair(datosCliente, datosMoto)

        polizas[id] = datos

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
            if (matricula.isNullOrBlank()){
                println(gestor.mensaje)
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
            print("Marca: ")
            marca = readln().capitalizar()
            if (marca.isNullOrBlank()){
                println(gestor.mensaje)
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
                println(gestor.mensaje)
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