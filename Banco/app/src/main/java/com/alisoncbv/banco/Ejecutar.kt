package com.alisoncbv.banco

fun main() {

    //Objeto
    val banco: Banco = Banco()

    var opcion:Int = 1

    do {
        println("!Bienvenido al banco AlisonBBV¡")
        println("Elija la acción que desea ejecutar")
        println("1.Registrar usuarios \n2.Consignar dinero \n3.Retirar dinero \n4.Consultar Saldo \n5.Consultar saldo del banco  \n6.Salir")
        var menu:Int = readLine()!!.toInt()

        when(menu) {

            1 -> {
                println("Registrar clientes")
                banco.registrarClientes()
                println("Clientes registrados con exito")
                println(banco.usuarios)
            }

            2 -> {
                println("Consignar dinero")
                println("Para consignar en su cuenta es necesario que ingrese la siguiente información")
                println("Número de documento")
                var documento: Int = readLine()!!.toInt()

                var existe = false

                for (i in banco.usuarios) {
                    if (documento == i[0]) {
                        println("Cantidad que desea consignar")
                        var cant: Int = readLine()!!.toInt()
                        banco.consignarDinero(documento, cant)
                        existe = true
                        println("La consignación se realizó con exito")
                        break
                    }
                }
                if (existe == false) {
                    println("El número de identidad no corresponde a ningún usuario registrado")
                }
            }

            3->{
                println("Retirar dinero")
                println("Para retirar dinero de su cuenta es necesario que ingrese la siguiente información")
                println("Número de documento")
                var documento: Int = readLine()!!.toInt()

                var existe = false

                for (i in banco.usuarios) {
                    if (documento == i[0]) {
                        println("Cantidad que desea retirar")
                        var cant: Int = readLine()!!.toInt()
                        banco.retirarDinero(documento, cant)
                        existe = true
                        println("Retiro exitoso")
                        break
                    }
                }
                if (existe == false) {
                    println("El número de identidad no corresponde a ningún usuario registrado")
                }
            }

            4->{
                println("Consultar saldo")
                println("Para consultar su saldo es necesario que ingrese la siguiente información")
                println("Número de documento")
                var documento: Int = readLine()!!.toInt()

                banco.consultarSaldo(documento)
            }

            5->{
                println("Saldo total del banco")
                banco.saldoTotal()
            }

            6->{
                println("Saliendo")
            }
        }

        println("Desea regresar al menú \n 1=Si \n 2=No")
        opcion = readLine()!!.toInt()

    }while (opcion==1)

    println("Gracias por preferirnos")
}