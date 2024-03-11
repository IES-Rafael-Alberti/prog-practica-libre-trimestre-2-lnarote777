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

    /**
     * Busca una póliza por su ID en la lista de pólizas.
     * @param id El ID de la póliza que se quiere buscar.
     * @return El mapa que contiene la información de la póliza si se encuentra, o null si no se encuentra.
     */
    fun buscarPoliza(id: String): MutableMap<String, List<Any>>? = polizas.find { it.keys.contains(id) }

    /**
     * Muestra la información de una póliza identificada por su ID.
     * @param id El ID de la póliza que se quiere mostrar.
     */
    fun mostrarPoliza(id: String) {
        val poliza = buscarPoliza(id)

        if (poliza != null){

            println("Id Póliza: $id")
            println("Datos póliza: ")

            val datos = poliza.values.first()

            println("dni contratador: ${datos[0]}")

            when(datos[3]){
                "MOTO" -> println("TipoPoliza: Moto")
                "COCHE" -> println("TipoPoliza: Coche")
                "VIDA" -> println("TipoPoliza: Vida")
                "DECESO" -> println("TipoPoliza: Deceso")
                "Hogar" -> println("TipoPoliza: Hogar")
            }

            println(datos[1])
            println("Fecha alta: ${datos[2]}")

        }else{
            println("No se encontro la poliza con id: $id")
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

    /**
     * Guarda las pólizas del archivo de registro en la lista de pólizas.
     *
     * @return La lista de pólizas guardadas, representadas como mapas de datos en el formato especificado.
     */
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

    /**
     * Analiza una cadena que representa una póliza y la convierte en un mapa con el ID de la póliza como clave y una lista de datos como valor.
     * @param linea La cadena que representa la póliza.
     * @return Un mapa que contiene el ID de la póliza como clave y una lista de datos como valor, o null si falla el análisis.
     */
    private fun deStringAPoliza(linea: String): MutableMap<String, List<Any>>? {

        val linea = linea.substring(1, linea.length - 1) // quita corchetes
        val partes = linea.split("=", limit =  2)
        val idPoliza = partes[0]
        val datosStr = partes[1]

       val datos = mutableListOf<Any>()

       val partesDatos = datosStr.substring(1, datosStr.length - 1).split(", ")
        if (partesDatos.size >= 5){
            val dni = partesDatos[2].substringAfter("dni=").trim()
            val polizasStr = partesDatos[4].substringAfter("polizas=").substringAfter("{").substringBefore("}").split("=")
            val tipoPoliza =  polizasStr[1]
            val datosEspecificos = partesDatos.subList(5, partesDatos.size -1)
            val fecha = partesDatos.last()

            datos.add(dni)
            datos.add(datosEspecificos)
            datos.add(fecha)
            datos.add(tipoPoliza)
        }else{
            print("cuac")
        }

        val poliza = mutableMapOf<String, List<Any>>()
        poliza[idPoliza] = datos

        return poliza
    }

}