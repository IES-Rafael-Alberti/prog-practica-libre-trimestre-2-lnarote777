package org.practicatrim2

import org.practicatrim2.Clientes.GestionClientes
import org.practicatrim2.Polizas.PolizaMoto


fun String.capitalizar(): String{
    var palabrasFrase = this.split(" ")
    val frase = mutableListOf<String>()
    for (i in palabrasFrase){
        val mayuscula = i.capitalize()
        frase.add(mayuscula)
    }
    return frase.joinToString(" ")
}


fun main() {

    val gestionClientes = GestionClientes()

    val polizaMoto= PolizaMoto(gestionClientes)
    polizaMoto.grabarPoliza()

   gestionClientes.listadoClientes()


}



fun respuestaUsuario(){
    while (true){
        try {
            val usuario = readln().lowercase()
            if (usuario.isNotBlank()){

            }else{
                throw Exception()
            }
        }catch (e: Exception){
            println("Opción incorrecta indique si es cliente o empleado porfavor.")
        }
    }

}
