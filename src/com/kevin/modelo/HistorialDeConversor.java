package com.kevin.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistorialDeConversor{

    private final double valorEntrada;
    private final String moneda1;
    private final String moneda2;
    private final double valorConvertido;
    private static int CONTADOR;

    private final String horaFormateada;
    private int conta;

    public double getValorEntrada() {
        return valorEntrada;
    }

    public String getMoneda1() {
        return moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public HistorialDeConversor(Moneda moneda, LocalDateTime localDate, double valorEntrada){

        this.valorEntrada = valorEntrada;
        this.moneda1 = moneda.base_code();
        this.moneda2 = moneda.target_code();
        this.valorConvertido = moneda.conversion_result();
        this.conta = ++HistorialDeConversor.CONTADOR;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        horaFormateada = formatter.format(localDate);

    }

    @Override
    public String toString(){

        return this.conta+") "+"El valor "+ this.valorEntrada + "["+this.moneda1+"]"+" corresponde al valor final de =>>> "+this.valorConvertido+
        " ["+this.moneda2+"] -- Fecha y hora : "+this.horaFormateada + "\n";

    }

}
