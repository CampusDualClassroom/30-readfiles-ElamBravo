package com.campusdual.classroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Exercise {

    public static void main(String[] args) {
        // Intentamos obtener el recurso desde el classpath
        InputStream inputStream = Exercise.class.getClassLoader().getResourceAsStream("lorem.txt");

        // Validamos que el recurso exista
        if (inputStream == null) {
            System.err.println("No se pudo encontrar el archivo lorem.txt");
            return;
        }

        // Usamos BufferedReader para leer línea por línea
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Imprime cada línea
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

