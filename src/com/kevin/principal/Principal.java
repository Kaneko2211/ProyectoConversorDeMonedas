package com.kevin.principal;

import com.kevin.modelo.ConsultarMoneda;
import com.kevin.modelo.HistorialDeConversor;
import com.kevin.modelo.Moneda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<HistorialDeConversor> historialSS = new ArrayList<>();
        ConsultarMoneda consultar_ = new ConsultarMoneda();
        var entrada = new Scanner(System.in);

        System.out.println("******************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");

        var bandera = false;

        while(!bandera){

            mostrarOpciones();

            try{

                bandera = convertirMoneda(entrada,historialSS,consultar_);

            }catch (InputMismatchException e){

                System.out.println("No puedes ingresar una cadena como opción!!!!\n");
                entrada.next();

            }

        }
    }

    public static void mostrarOpciones(){
        System.out.println("""
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Visualizar historial de conversiones
                8) Salir
                Elija una opción válida: 
                ********************************************************************
                """);
    }

    public static void imprimirConversorYGuardar(List<HistorialDeConversor> historialSS,ConsultarMoneda cambiar_, String moneda1, String moneda2, double valor){

        Moneda moneda = cambiar_.cambiarMoneda(moneda1, moneda2, valor);
        System.out.println(moneda.cambioDeMoneda(valor)+"\n");
        HistorialDeConversor historial = new HistorialDeConversor(moneda, LocalDateTime.now(), valor);
        historialSS.add(historial);

    }

    public static void imprimirHistorial(List<HistorialDeConversor> historialSS){
        System.out.println("\n**************************************************************HISTORIAL***************************************************************");
        historialSS.forEach(System.out::print);
        System.out.println("**************************************************************************************************************************************\n");
    }

    public static boolean convertirMoneda(Scanner entrada, List<HistorialDeConversor> historialSS, ConsultarMoneda cambiar_){
        boolean bandera = false;
        String moneda1 = "";
        String moneda2 = "";
        double valor = 0;
        var opcion = 0;

        opcion = entrada.nextInt();
        switch (opcion) {

            case 1:
                System.out.print("\nIngrese el valor que deseas convertir: ");
                moneda1 = "USD";
                moneda2 = "ARS";
                valor = entrada.nextDouble();
                System.out.println();
                imprimirConversorYGuardar(historialSS,cambiar_, moneda1,moneda2,valor);
                break;
            case 2:
                System.out.print("\nIngrese el valor que deseas convertir: ");
                moneda1 = "ARS";
                moneda2 = "USD";
                valor = entrada.nextDouble();
                System.out.println();
                imprimirConversorYGuardar(historialSS,cambiar_, moneda1,moneda2,valor);
                break;
            case 3:
                System.out.print("\nIngrese el valor que deseas convertir: ");
                moneda1 = "USD";
                moneda2 = "BRL";
                valor = entrada.nextDouble();
                System.out.println();
                imprimirConversorYGuardar(historialSS,cambiar_, moneda1,moneda2,valor);
                break;
            case 4:
                System.out.print("\nIngrese el valor que deseas convertir: ");
                moneda1 = "BRL";
                moneda2 = "USD";
                valor = entrada.nextDouble();
                System.out.println();
                imprimirConversorYGuardar(historialSS,cambiar_, moneda1,moneda2,valor);
                break;
            case 5:
                System.out.print("\nIngrese el valor que deseas convertir: ");
                moneda1 = "USD";
                moneda2 = "COP";
                valor = entrada.nextDouble();
                System.out.println();
                imprimirConversorYGuardar(historialSS,cambiar_, moneda1,moneda2,valor);
                break;
            case 6:
                System.out.print("\nIngrese el valor que deseas convertir: ");
                moneda1 = "COP";
                moneda2 = "USD";
                valor = entrada.nextDouble();
                System.out.println();
                imprimirConversorYGuardar(historialSS,cambiar_, moneda1,moneda2,valor);
                break;
            case 7:
                imprimirHistorial(historialSS);
                break;
            case 8:
                bandera = true;
                break;
            default:
                System.out.println("Opcion no valida!\n");
                break;
        }


        return bandera;
    }

}