/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.util;

/**
 *
 * @author JHOJAN L
 */
public class Aproximador {
    
    public long aproximador(long dato) {

        var datoConvertido = String.valueOf(dato);
        var tam = datoConvertido.length();

        System.out.println("total sin aproximar =" + dato + " \ntam =" + tam);

        if (tam == 1) {

            return 0;

        } else if (tam == 2) {
            
            int cantidad = Integer.parseInt(datoConvertido);

            if (cantidad != 00 && cantidad != 50) {
                var cantidadConvertida = cambiarCantidad(cantidad);
                System.out.println("cantidad convertida dos digitos= " + cantidadConvertida);

                return Long.parseLong(cantidadConvertida);
            } else {

                return dato;
            }

//            (tam != 2)
        } else {
//            System.out.println("\n substring= " + datoConvertido.substring(tam-2, tam));
            int cantidad = Integer.parseInt(datoConvertido.substring(tam - 2, tam));

            if (cantidad != 00 && cantidad != 50) {

                var cantidadConvertida = cambiarCantidad(cantidad);
                System.out.println("cantidad nueva:" + cantidadConvertida);
                return convertirCantidad(datoConvertido, cantidadConvertida);

            } else {
                return dato;
            }

        }

    }

    public String cambiarCantidad(int substring) {
        System.out.println("substring = " + substring);

        var cantidad = "";

        if (substring > 0 && substring < 26) {//mayor a 1 y menor a 26 ultimos dos digitos 00
            cantidad = "00";
            System.out.println("mayor a 1 y menor a 26");
            
        } else if (substring > 25 && substring < 76) {//mayor a 25 y menor a 76 ultimos dos digitos 50
            cantidad = "50";
            System.out.println("mayor a 25 y menor a 75");
            
        } else if (substring > 75 && substring <= 99) {//mayor a 75 e igual o menor a 99 se aproxima
            // sgte valor Ej: 1999 seria 2000
            
            cantidad = "100";
            System.out.println("mayor o igual a 75 y menor o igual 99");
        }

        return cantidad;
    }

    public long convertirCantidad(String dato, String cantidad) {

        System.out.println("\nel dato es: " + dato + " la cantidad a convertir es: " + cantidad);
        var nuevoDato = new StringBuilder(dato);
        nuevoDato.setCharAt(dato.length() - 1, cantidad.charAt(cantidad.length() - 1));
        nuevoDato.setCharAt(dato.length() - 2, cantidad.charAt(cantidad.length() - 2));

        System.out.println("dato nuevo: " + nuevoDato);

        if (cantidad.length() == 3) {
            var datoConvertido = Long.parseLong(String.valueOf(nuevoDato));
            var cantidadConvertida = Long.parseLong(cantidad);
            datoConvertido = datoConvertido + cantidadConvertida;

            System.out.println("dato convertido " + datoConvertido);
            return datoConvertido;
        }else{
           
            var datoConvertido = Long.parseLong(String.valueOf(nuevoDato));
           return datoConvertido;
        
        }
    }
    
}
