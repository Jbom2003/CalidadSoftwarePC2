package com.usil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    // Prueba 1: Caso Hola -> ALOH
    @Test
    void testReverseSimple() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("hola"));
    }

    // Prueba 2: Caso con espacios (Trim)
    @Test
    void testReverseWithSpaces() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize(" hola "));
    }

    // Prueba 3: Frase completa
    @Test
    void testReversePhrase() {
        assertEquals("ODNUM ALOH", TextProcessor.reverseAndCapitalize("hola mundo"));
    }

    // Prueba 4: Null exception
    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(null));
    }

    // Prueba 5: Texto numérico
    @Test
    void testReverseNumbers() {
        assertEquals("321", TextProcessor.reverseAndCapitalize("123"));
    }

    // Prueba 6: Texto mixto
    @Test
    void testReverseMixed() {
        assertEquals("C2P", TextProcessor.reverseAndCapitalize("p2c"));
    }
}