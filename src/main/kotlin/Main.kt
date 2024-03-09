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

    val polizaMoto= PolizaMoto(gestionClientes)
    polizaMoto.mostrarPoliza("290-867")
//
//    menu()
//    val opcion = readln().toInt()
//
//    if (opcion == 1){
//        menuClienteExistente()
//        val op = readln().toInt()
//        if(op == 1 ){
//            menuPolizas()
//            val opc = readln().toInt()
//            if (opc == 1){
//                polizaMoto.grabarPoliza()
//            }
//        }else if (op == 2){
//
//        }
//    }else if (opcion == 2){
//        println("Que póliza desea contratar ?")
//        menuPolizas()
//    }



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
