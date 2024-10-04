package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/* El objetivo es encontrar el par de números adyacentes que, al multiplicarse,
   den como resultado el mayor producto posible dentro del arreglo de números. */
public class ProductosAdyacentes {

    /*
    Valida que el arreglo tenga al menos dos elementos. Si no es así, lanza una excepción con el mensaje correspondiente.
    */
    public static void validarArreglo(int[] arreglo) {
        if (arreglo == null || arreglo.length < 2) {
            throw new IllegalArgumentException("El arreglo debe tener al menos dos elementos para calcular el producto adyacente.");
        }
        // Se eliminó la validación de arreglo con solo ceros.
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
    Método para permitir que el usuario ingrese el arreglo desde el teclado.
    Se agregan validaciones para manejar excepciones de entrada, como letras o valores no numéricos.
     */
    public static int[] leerArregloDesdeTeclado() {
        Scanner scanner = new Scanner(System.in);
        int tamaño = 0;

        while (true) {
            try {
                System.out.print("Ingrese el tamaño del arreglo (debe ser un número entero mayor a 1): ");
                tamaño = scanner.nextInt();
                if (tamaño < 2) {
                    System.out.println("Error: El arreglo debe tener al menos dos elementos.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Se ha ingresado un valor no numérico. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar el buffer
            }
        }

        int[] arreglo = new int[tamaño];
        System.out.println("Ingrese los elementos del arreglo (solo números enteros):");

        // Validación de entrada para los elementos del arreglo
        for (int i = 0; i < tamaño; i++) {
            while (true) {
                try {
                    System.out.print("Elemento " + (i + 1) + ": ");
                    arreglo[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se ha ingresado un valor no numérico. Por favor, ingrese un número entero.");
                    scanner.next(); // Limpiar el buffer
                }
            }
        }
        return arreglo;
    }

    /*
    El método main permite al usuario ingresar su propio arreglo desde el teclado y luego calcula
    el mayor producto de los números adyacentes en dicho arreglo.
    Se agregan bloques try-catch para manejar excepciones y evitar fallos en la ejecución.
    */
    public static void main(String[] args) {
        try {
            // Permitir al usuario ingresar el arreglo desde el teclado.
            int[] arregloUsuario = leerArregloDesdeTeclado();
            System.out.println("El mayor producto adyacente en el arreglo ingresado es: " + encontrarMayorProductoAdyacente(arregloUsuario));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
}