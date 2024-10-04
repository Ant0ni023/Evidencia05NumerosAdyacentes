package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/* El objetivo es encontrar el par de números adyacentes que, al multiplicarse,
   den como resultado el mayor producto posible dentro del arreglo de números. */
public class ProductosAdyacentes {

    // Variable para almacenar el tamaño del arreglo.
    private static int tamañoArreglo;

    // Variable para almacenar el arreglo ingresado por el usuario.
    private static int[] arreglo;

    /*
    Solicita el tamaño del arreglo al usuario. No realiza validaciones,
    solo muestra un mensaje solicitando la entrada del usuario.
    */
    public static void solicitarTamañoArreglo() {
        System.out.print("Ingrese el tamaño del arreglo (debe ser un número entero mayor a 1): ");
    }

    /*
    Obtiene el tamaño del arreglo ingresado por el usuario, validando que sea un número entero
    y que sea mayor a 1. Si ocurre un error, se solicita nuevamente el dato.
    */
    public static void obtenerTamañoArreglo(Scanner scanner) {
        while (true) {
            try {
                tamañoArreglo = scanner.nextInt();
                if (tamañoArreglo < 2) {
                    System.out.println("Error: El arreglo debe tener al menos dos elementos.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Se ha ingresado un valor no valido. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    /*
    Solicita al usuario que ingrese los elementos del arreglo. No realiza validaciones,
    solo muestra un mensaje para cada elemento.
    */
    public static void solicitarElementosArreglo() {
        System.out.println("Ingrese los elementos del arreglo (solo números enteros):");
    }

    /*
    Obtiene los elementos del arreglo desde el teclado. Cada valor se valida para asegurarse
    de que sean números enteros. Si ocurre un error, se solicita nuevamente el dato.
    */
    public static void obtenerElementosArreglo(Scanner scanner) {
        arreglo = new int[tamañoArreglo];
        for (int i = 0; i < tamañoArreglo; i++) {
            while (true) {
                try {
                    System.out.print("Elemento " + (i + 1) + ": ");
                    arreglo[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se ha ingresado un valor no valido. Por favor, ingrese un número entero.");
                    scanner.next(); // Limpiar el buffer
                }
            }
        }
    }

    /*
    Valida que el arreglo tenga al menos dos elementos y que no contenga solo ceros.
    Si no es así, lanza una excepción con el mensaje correspondiente.
     */
    public static void validarArreglo(int[] arreglo) {
        if (arreglo == null || arreglo.length < 2) {
            throw new IllegalArgumentException("El arreglo debe tener al menos dos elementos para calcular el producto adyacente.");
        }

        boolean todosCeros = true;
        for (int num : arreglo) {
            if (num != 0) {
                todosCeros = false;
                break;
            }
        }

        if (todosCeros) {
            throw new IllegalArgumentException("Error: El arreglo no puede contener solo ceros.");
        }
    }

    /*
    Obtiene el producto inicial del primer par de elementos adyacentes (índice 0 y 1) del arreglo.
    Este valor se utilizará como referencia para comparar con los demás productos adyacentes.
     */
    public static int obtenerProductoDeLosPrimerosElementosAdyacentes(int[] arreglo) {
        return arreglo[0] * arreglo[1];
    }

    /*
    Encuentra el mayor producto de números adyacentes en el arreglo comparando cada par de elementos consecutivos
    con el producto inicial obtenido en el método obtenerProductoDeLosPrimerosElementosAdyacentes.
    */
    public static int encontrarMayorProductoAdyacente(int[] arreglo) {
        validarArreglo(arreglo); // Verifica que el arreglo sea válido.
        int productoMaximo = obtenerProductoDeLosPrimerosElementosAdyacentes(arreglo); // Se inicializa con el producto del primer par de elementos adyacentes.

        for (int i = 1; i < arreglo.length - 1; i++) {
            int productoActual = arreglo[i] * arreglo[i + 1]; // Inicializa productoActual con el producto del elemento actual y el siguiente.
            if (productoActual > productoMaximo) { // Si el producto actual es mayor al producto máximo almacenado.
                productoMaximo = productoActual; // Actualiza productoMaximo con el nuevo mayor producto encontrado.
            }
        }
        return productoMaximo; // Retorna el mayor producto encontrado entre los pares adyacentes.
    }

    /*
    El método main orquesta el flujo del programa, asegurándose de que cada tarea sea realizada por un método específico.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar y obtener el tamaño del arreglo
            solicitarTamañoArreglo();
            obtenerTamañoArreglo(scanner);

            // Solicitar y obtener los elementos del arreglo
            solicitarElementosArreglo();
            obtenerElementosArreglo(scanner);

            // Calcular y mostrar el mayor producto de números adyacentes
            System.out.println("El mayor producto adyacente en el arreglo ingresado es: " + encontrarMayorProductoAdyacente(arreglo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
}