package org.example;

/* El objetivo es encontrar el par de números adyacentes que, al multiplicarse,
   den como resultado el mayor producto posible dentro del arreglo de números. */
public class ProductosAdyacentes {

    /*
    Valida que el arreglo tenga al menos dos elementos. Si no es así, imprime un mensaje de error
    indicando el motivo y termina la ejecución del programa.
     */
    public static void validarArreglo(int[] arreglo) {
        if (arreglo == null || arreglo.length < 2) {
            System.out.println("Error: El arreglo debe tener al menos dos elementos para calcular el producto adyacente.");
            System.exit(0); // Termina la ejecución del programa.
        }
    }

    /*
    Obtiene el producto inicial del primer par de elementos adyacentes (índice 0 y 1) del arreglo.
    Este valor se utilizará como referencia para comparar con los demás productos adyacentes.
     */
    public static int ProductoDeLosPrimerosElementosAdyacentes(int[] arreglo) {
        return arreglo[0] * arreglo[1];
    }

    /*
    Encuentra el mayor producto de números adyacentes en el arreglo comparando cada par de elementos consecutivos
    con el producto inicial obtenido en el método ProductoDeLosPrimerosElementosAdyacentes.
    */
    public static int encontrarMayorProductoAdyacente(int[] arreglo) {

        validarArreglo(arreglo); // Verifica que el arreglo sea válido.
        int productoMaximo = ProductoDeLosPrimerosElementosAdyacentes(arreglo); // Se inicializa con el producto del primer par de elementos adyacentes.

        /*
           El ciclo recorre desde el segundo elemento (índice 1) hasta el penúltimo elemento (índice arreglo.length - 1).
           Se detiene en el penúltimo elemento para asegurar que siempre exista un siguiente elemento (índice i + 1)
           para formar un par adyacente. Si recorriera hasta el último, no habría un elemento "arreglo[i + 1]"
           para calcular el producto, generando un error de índice fuera de los límites.
        */
        for (int i = 1; i < arreglo.length - 1; i++) {
            int productoActual = arreglo[i] * arreglo[i + 1]; // Inicializa productoActual con el producto del elemento actual y el siguiente.
            if (productoActual > productoMaximo) { // Si el producto actual es mayor al producto máximo almacenado.
                productoMaximo = productoActual; // Actualiza productoMaximo con el nuevo mayor producto encontrado.
            }
        }
        return productoMaximo; // Retorna el mayor producto encontrado entre los pares adyacentes.
    }

    /*
    El metodo main prueba el método encontrarMayorProductoAdyacente con el ejemplo del arreglo que se muestra en la actividad dentro del campus.
    */
    public static void main(String[] args) {
        // Caso 1: Arreglo de prueba con números positivos y negativos.
        int[] arregloEjemplo = {1, -4, 2, 2, 5, -1};
        System.out.println("El mayor producto adyacente en el arreglo {1, -4, 2, 2, 5, -1} es: " + encontrarMayorProductoAdyacente(arregloEjemplo)); // Debería mostrar 10 como resultado.
    }
}
