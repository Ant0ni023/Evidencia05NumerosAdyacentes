package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductosAdyacentesTest {

    @Test
    void validarArreglo_CuandoArregloVacio_EntoncesLanzaExcepcion() {
        int[] arregloVacio = {};
        IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> {
            ProductosAdyacentes.validarArreglo(arregloVacio);
        });
        assertEquals("El arreglo debe tener al menos dos elementos para calcular el producto adyacente.", excepcion.getMessage());
    }

    @Test
    void validarArreglo_CuandoArregloConUnElemento_EntoncesLanzaExcepcion() {
        int[] arregloUnElemento = {5};
        IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> {
            ProductosAdyacentes.validarArreglo(arregloUnElemento);
        });
        assertEquals("El arreglo debe tener al menos dos elementos para calcular el producto adyacente.", excepcion.getMessage());
    }

    @Test
    void encontrarMayorProductoAdyacente_CuandoArregloConNumerosPositivos_EntoncesRetornaMayorProducto() {
        int[] arreglo = {1, 5, 3, 6, 2};
        int resultado = ProductosAdyacentes.encontrarMayorProductoAdyacente(arreglo);
        assertEquals(18, resultado, "El mayor producto adyacente en el arreglo {1, 5, 3, 6, 2} debe ser 18 (6*3).");
    }

    @Test
    void encontrarMayorProductoAdyacente_CuandoArregloConNumerosNegativosYPositivos_EntoncesRetornaMayorProducto() {
        int[] arreglo = {-1, -3, 4, 5, -2};
        int resultado = ProductosAdyacentes.encontrarMayorProductoAdyacente(arreglo);
        assertEquals(20, resultado, "El mayor producto adyacente en el arreglo {-1, -3, 4, 5, -2} debe ser 20 (4*5).");
    }

    @Test
    void encontrarMayorProductoAdyacente_CuandoArregloConNumerosNegativos_EntoncesRetornaMayorProducto() {
        int[] arreglo = {-1, -3, -4, -2};
        int resultado = ProductosAdyacentes.encontrarMayorProductoAdyacente(arreglo);
        assertEquals(12, resultado, "El mayor producto adyacente en el arreglo {-1, -3, -4, -2} debe ser 12 (-3*-4).");
    }

    @Test
    void encontrarMayorProductoAdyacente_CuandoArregloConCeros_EntoncesRetornaCero() {
        int[] arreglo = {0, 0, 0, 0};
        int resultado = ProductosAdyacentes.encontrarMayorProductoAdyacente(arreglo);
        assertEquals(0, resultado, "El mayor producto adyacente en el arreglo {0, 0, 0, 0} debe ser 0 (0*0).");
    }

    @Test
    void encontrarMayorProductoAdyacente_CuandoArregloConDosElementos_EntoncesRetornaMayorProducto() {
        int[] arreglo = {5, 10};
        int resultado = ProductosAdyacentes.encontrarMayorProductoAdyacente(arreglo);
        assertEquals(50, resultado, "El mayor producto adyacente en el arreglo {5, 10} debe ser 50 (5*10).");
    }


    @Test
    void encontrarMayorProductoAdyacente_CuandoArregloTieneElementosIguales_EntoncesRetornaMayorProducto() {
        int[] arreglo = {2, 2, 2, 2, 2};
        int resultado = ProductosAdyacentes.encontrarMayorProductoAdyacente(arreglo);
        assertEquals(4, resultado, "El mayor producto adyacente en el arreglo {2, 2, 2, 2, 2} debe ser 4 (2*2).");
    }
}
