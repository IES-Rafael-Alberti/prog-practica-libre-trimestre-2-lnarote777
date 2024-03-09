package org.practicatrim2

import org.practicatrim2.Polizas.Poliza
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
//
//    val polizaMoto = PolizaMoto(gestionClientes)
//    polizaMoto.grabarPoliza()
//
//    print("id:")
//    val id = readln()
//    polizaMoto.mostrarPoliza(id)


    val id = PolizaMoto(gestionClientes).generarId()

    print(id)

//    menu()
//    respuestaUsuario()



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
