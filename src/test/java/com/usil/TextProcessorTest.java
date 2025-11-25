package com.usil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    // Prueba 1: Transformación exitosa simple
    @Test
    void testReverseSimple() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("hola"));
    }

    // Prueba 2: Transformación con limpieza (Trim) y espacios
    @Test
    void testReverseWithTrim() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("  hola  "));
    }

    // Prueba 3: Transformación compleja (Frases y números)
    @Test
    void testReverseComplex() {
        assertEquals("ODNUM ALOH", TextProcessor.reverseAndCapitalize("hola mundo"));
        assertEquals("321", TextProcessor.reverseAndCapitalize("123"));
    }

    // Prueba 4: Exception por Nulo o Vacío
    @Test
    void testInvalidInputNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(null));
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(""));
    }

    // Prueba 5: Exception por solo espacios
    @Test
    void testWhitespaceOnly() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize("   "));
    }

    // Prueba 6: Exception por longitud excedida y constructor
    @Test
    void testLengthLimitAndConstructor() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize("a".repeat(1001)));
        new TextProcessor(); // Cobertura del constructor para el 100% de clase
    }
}