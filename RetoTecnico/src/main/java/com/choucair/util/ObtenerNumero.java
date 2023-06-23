package com.choucair.util;

public class ObtenerNumero {

    public static int obtenerEnteros(String input) {
        StringBuilder enterosBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                enterosBuilder.append(c);
            }
        }
        return Integer.parseInt(enterosBuilder.toString());
    }
}
