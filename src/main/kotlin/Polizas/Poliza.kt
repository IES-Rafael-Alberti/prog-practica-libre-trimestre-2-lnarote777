package org.practicatrim2.Polizas

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

abstract class Poliza {

    val polizas = mutableMapOf<String, List<Any>>()
    private val path = "src/main/kotlin/baseDatos/polizas.txt"
    private val archivo = File(path)

    /**
     * Genera un ID único para una póliza.
     * El ID se compone de dos números aleatorios de tres dígitos separados por un guion.
     * Si el número aleatorio generado tiene menos de tres dígitos, se le añaden ceros por delante.
     *
     * @return El ID único generado.
     */
    fun generarId(): String{
        var id : String

        do {
            val numero1 = String.format("%03d" ,(1..999).random())
            val numero2 = String.format("%03d" ,(1..999).random())

            id = "$numero1-$numero2"

        }while (polizas.containsKey(id)) // mientras exista el id generado en el map de polizas generara un id distinto hasta que que no coincida conninguno existente (se asegura de no crear duplicados)

        return id
    }
    abstract fun grabarPoliza()
    abstract fun datosEspecificos() : MutableList<String>
    fun generarFechaAlta(): String {

        val dia = String.format("%02d", (1..31).random())
        val mes = String.format("%02d", (1..12).random())
        val anio = String.format("%02d", (1980..2023).random())

        val fecha = "$dia/$mes/$anio"

        return fecha

    }

    fun buscarPoliza(id: String): Pair<Pair<String, List<String>>?, Pair<String, List<String>>?> {

        var clienteDatos :Pair<String, List<String>>? = null
        var polizaDatos :Pair<String, List<String>>? = null
        if (archivo.exists()){
            archivo.forEachLine {linea ->
                if (linea.contains(id)) {
                    val partes = linea.split(", ") // Separar la línea en partes
                    val datosPoliza = partes[1].split(",").map { it.trim() } // Extraer datos de la póliza
                    polizaDatos = Pair(id, datosPoliza)
                    val datosCliente = datosPoliza.subList(2, datosPoliza.size)// Extraer datos del cliente
                    clienteDatos = Pair(id, datosCliente)
                    return@forEachLine
                }
            }
        } else {
            println("*** Error en la base de datos - No se encontró el archivo ***")
        }

        return Pair(clienteDatos, polizaDatos)
    }

    fun mostrarPoliza(id: String) {
        val (clienteDatos, polizaDatos) = buscarPoliza(id)

        if (clienteDatos != null && polizaDatos != null) {
            println("ID de la póliza: $id")
            println("Datos del cliente:")
            println("Nombre: ${clienteDatos.second[0]}")
            println("DNI: ${clienteDatos.second[1]}")
            println("Teléfono: ${clienteDatos.second.subList(2, clienteDatos.second.size)}")
            println("Datos de la póliza:")
            println("Tipo de póliza: ${polizaDatos.second[0]}")

            if (polizaDatos.second[0] == "MOTO") {
                println("Matrícula: ${polizaDatos.second[1]}")
                println("Marca: ${polizaDatos.second[2]}")
                println("Modelo: ${polizaDatos.second[3]}")
                println("Fecha alta: ${polizaDatos.second[4]}")
            } else if (polizaDatos.first == "VIDA") {
                println("Fecha alta: ${polizaDatos.second[1]}")
            }
        } else {
            println("No se encontró ninguna póliza con el id: $id")
        }
    }


    fun guardarPoliza(poliza:  MutableMap<String, List<Any>>){

        try {

            val fileWriter = FileWriter(archivo, true)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(poliza.toString ())
            bufferedWriter.newLine()
            bufferedWriter.close()

            println("Polizas guardada correctamente")

        }catch (e: Exception){
            println("***Error***")
        }


    }




}