package com.kevin.modelo;

public record Moneda(String base_code, String target_code, double conversion_result) {

    public String cambioDeMoneda(){

        return "["+this.base_code+"]"+
                " corresponde al valor final de =>>> "+this.conversion_result+
                " ["+this.target_code+"]";

    }

}
