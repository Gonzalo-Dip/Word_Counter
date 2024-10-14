package org.example;

import java.util.*;    // Hacemos las  importanciones. En este caso "java.util", interfaces fundamentales para el desarrollo de aplicaciones


import java.util.regex.*;

public class ContadorPalabras {
    public static void main(String[] args) {  //Método main
        Scanner scanner = new Scanner(System.in); // Darle entrada a los datos del usuario

        // Solicitar una frase al usuario
        System.out.println("Introduce una frase (finaliza con un punto '.'):");

        StringBuilder frase = new StringBuilder();
        String input;

        // Leer la entrada hasta que se encuentre un punto
        while (!(input = scanner.nextLine()).endsWith(".")) {
            frase.append(input).append(" ");
        }

        // Añadir la última línea (que contiene el punto) y quitar el punto
        frase.append(input.substring(0, input.length() - 1));

        // Usar una expresión regular para encontrar las palabras
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(frase.toString());

        // Crear un mapa para agrupar palabras por su longitud
        Map<Integer, List<String>> grupos = new HashMap<>();
        int totalLetras = 0; // Variable para sumar el total de letras

        // Contar la cantidad de letras en cada palabra y agruparlas
        while (matcher.find()) {
            String palabra = matcher.group();
            int longitud = palabra.length();
            totalLetras += longitud; // Sumar la longitud de la palabra al total
            grupos.putIfAbsent(longitud, new ArrayList<>());
            grupos.get(longitud).add(palabra);
        }

        // Mostrar los grupos de palabras
        for (Map.Entry<Integer, List<String>> entry : grupos.entrySet()) {
            System.out.println("Palabras de " + entry.getKey() + " letras: " + entry.getValue());
        }

        // Mostrar el total de letras
        System.out.println("Total de letras en la frase: " + totalLetras);

        scanner.close();
    }
}

