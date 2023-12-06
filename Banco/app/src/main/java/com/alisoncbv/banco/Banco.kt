package com.alisoncbv.banco

class Banco {

    //Atributos
    var numDocumento=Int
        set(numDocumento) {
            field=numDocumento
        }
        get() {
            return field
        }

    var nombreCliente=String
        set(nombreCliente) {
            field=nombreCliente
        }
        get() {
            return field
        }

    var saldoCuenta=Int
        set(saldoCuenta) {
            field=saldoCuenta
        }
        get() {
            return field
        }

    fun inicializar(){
        this.numDocumento=numDocumento
        this.nombreCliente=nombreCliente
        this.saldoCuenta=saldoCuenta
    }

    //Lista de clientes
    var usuarios = mutableListOf<MutableList<Any>>()

    //Funciones

    //Función registrar
    fun registrarClientes(){
        println("Ingrese el número de clientes que desea registrar")
        var cantidad:Int = readLine()!!.toInt()
        for (i in 1 .. cantidad ){
            println("Ingrese el número de documento del cliente ${i}")
            var numeroD:Int = readLine()!!.toInt()

            println("Ingrese el nombre del cliente")
            var nombreC:String = readLine().toString()

            println("Ingrese el saldo del cliente")
            var saldo:Int = readLine()!!.toInt()

            usuarios.add(mutableListOf(numeroD, nombreC, saldo))
        }

    }

    //Función consignar
    fun consignarDinero(doc:Int, cantidad:Int){

        for(i in usuarios){
            if(doc == i[0]){
                var cuenta=i[2] as Int
                i[2] = cuenta+cantidad
                break
            }
        }
    }

    //Función retirar
    fun retirarDinero(doc: Int, cantidad:  Int){

        for(i in usuarios){
            if (doc == i[0]){
                var cuenta=i[2] as Int
                i[2] = cuenta-cantidad
                break
            }
        }
    }

    //Función consultar
    fun consultarSaldo(doc: Int){

        for (i in usuarios){
            if (doc == i[0]){
                var totalC=i[2] as Int
                println("Su saldo es ${totalC}")
                break
            }
        }
    }

    //Función saldo Banco
    fun saldoTotal(){
        var saldoBanco:Int = 0
        for (i in usuarios){
            var saldoClientes = i[2] as Int
            saldoBanco += saldoClientes
        }
        println("El saldo total del banco es: ${saldoBanco}")


    }


}