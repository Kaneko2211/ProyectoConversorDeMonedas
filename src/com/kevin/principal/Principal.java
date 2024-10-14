package com.kevin.principal;

import com.kevin.modelo.ConsultarMoneda;
import com.kevin.modelo.Moneda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        var entrada = new Scanner(System.in);
        ConsultarMoneda cambiar = new ConsultarMoneda();


        System.out.println("******************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        String moneda1 = "";
        String moneda2 = "";
        double valor = 0;
        var bandera = false;
        Moneda moneda;
        var opcion = 0;

        while(!bandera){
            System.out.println("""
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida: 
                ********************************************************************
                """);
            try{
                opcion = entrada.nextInt();
                switch (opcion) {

                    case 1:
                        System.out.print("\nIngrese el valor que deseas convertir: ");
                        moneda1 = "USD";
                        moneda2 = "ARS";
                        valor = entrada.nextDouble();
                        System.out.println();
                        moneda = cambiar.cambiarMoneda(moneda1, moneda2, valor);
                        concatenarCadena(valor, moneda.cambioDeMoneda());
                        // BRL COP
                        break;
                    case 2:
                        System.out.print("\nIngrese el valor que deseas convertir: ");
                        moneda1 = "ARS";
                        moneda2 = "USD";
                        valor = entrada.nextDouble();
                        System.out.println();
                        moneda = cambiar.cambiarMoneda(moneda1, moneda2, valor);
                        concatenarCadena(valor, moneda.cambioDeMoneda());
                        break;
                    case 3:
                        System.out.print("\nIngrese el valor que deseas convertir: ");
                        moneda1 = "USD";
                        moneda2 = "BRL";
                        valor = entrada.nextDouble();
                        System.out.println();
                        moneda = cambiar.cambiarMoneda(moneda1, moneda2, valor);
                        concatenarCadena(valor, moneda.cambioDeMoneda());
                        break;
                    case 4:
                        System.out.print("\nIngrese el valor que deseas convertir: ");
                        moneda1 = "BRL";
                        moneda2 = "USD";
                        valor = entrada.nextDouble();
                        System.out.println();
                        moneda = cambiar.cambiarMoneda(moneda1, moneda2, valor);
                        concatenarCadena(valor, moneda.cambioDeMoneda());
                        break;
                    case 5:
                        System.out.print("\nIngrese el valor que deseas convertir: ");
                        moneda1 = "USD";
                        moneda2 = "COP";
                        valor = entrada.nextDouble();
                        System.out.println();
                        moneda = cambiar.cambiarMoneda(moneda1, moneda2, valor);
                        concatenarCadena(valor, moneda.cambioDeMoneda());
                        break;
                    case 6:
                        System.out.print("\nIngrese el valor que deseas convertir: ");
                        moneda1 = "COP";
                        moneda2 = "USD";
                        valor = entrada.nextDouble();
                        System.out.println();
                        moneda = cambiar.cambiarMoneda(moneda1, moneda2, valor);
                        concatenarCadena(valor, moneda.cambioDeMoneda());
                        break;
                    case 7:
                        bandera = true;
                        break;
                    default:
                        System.out.println("Opcion no valida!");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("No puedes ingresar una cadena como opción!!!!\n");
                entrada.next();
            }

        }

    }

    public static void concatenarCadena(double valor ,String cadena){

        System.out.println("El valor "+valor+" "+cadena+"\n");

    }

}