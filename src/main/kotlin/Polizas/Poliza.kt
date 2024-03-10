package org.practicatrim2.Polizas

import org.practicatrim2.Clientes.Cliente
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

abstract class Poliza {

    //Resguardo de las pólizas. Cuando empiza el programa se cargan las pólizas del archivo a la lista para operar más fácilmente
    private val polizas = mutableListOf<MutableMap<String, List<Any>>>()
    val poliza = mutableMapOf<String, List<Any>>()
    private val path = "src/main/kotlin/baseDatos/polizas.txt"
    private val archivo = File(path)

    abstract fun grabarPoliza()
    abstract fun datosEspecificos() : MutableList<Any>

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

        }while (poliza.containsKey(id))

        return id
    }

    fun generarFechaAlta(): String {

        //Genera una fecha aleatoria
        val dia = String.format("%02d", (1..31).random())
        val mes = String.format("%02d", (1..12).random())
        val anio = (1980..2023).random().toString()

        val fecha = "$dia/$mes/$anio"

        return fecha

    }

    ///
    fun buscarPoliza(id: String): Pair<Pair<String, List<String>>?, Pair<String, List<String>>?> {
        TODO("Modificar")
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

    //
    fun mostrarPoliza(id: String) {
        TODO("Modificar")
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

    /**
     * Guarda una póliza en el archivo de registro.
     *
     * @param poliza El mapa de datos que representa la póliza a guardar. Debe contener la información de la póliza
     * en el formato especificado.
     */
    fun guardarPoliza(poliza:  MutableMap<String, List<Any>>){

        try {

            polizas.add(poliza)
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


    fun guardarPolizasDelArchivo(): MutableList<MutableMap<String, List<Any>>> {

        archivo.forEachLine { linea ->
            val poliza = deStringAPoliza(linea)
            if (poliza != null) {
                polizas.add(poliza)
            } else {
                println("Error en el formato de la línea: $linea")
            }
        }

        return polizas
    }

    private fun deStringAPoliza(linea: String): MutableMap<String, List<Any>>? {

        val linea = linea.substring(1, linea.length - 1) // quita corchetes
        val partes = linea.split("=")
        val idPoliza = partes[0]
        val datos = partes[1]

        val valores = if (datos.startsWith("[") && datos.endsWith("]")) {
            // Eliminamos los corchetes y dividimos los elementos en la lista
            datos.substring(1, datos.length - 1).split(", ")
        } else {
            // Si no contiene corchetes, lo añadimos como un solo elemento a la lista
            listOf(datos)
        }

        val poliza = mutableMapOf<String, List<Any>>()
        poliza[idPoliza] = valores

        return poliza
    }






}