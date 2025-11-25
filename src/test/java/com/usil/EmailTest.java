package com.usil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    Email emailValidator = new Email();

    // Prueba 1: Exception por Nulo o Vacío
    @Test
    void testNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> emailValidator.isValidEmail(null));
        assertThrows(IllegalArgumentException.class, () -> emailValidator.isValidEmail(""));
    }

    // Prueba 2: Correos válidos (Estándar y casos borde permitidos)
    @Test
    void testValidEmails() {
        assertTrue(emailValidator.isValidEmail("cliente123@tienda.com"));
        assertTrue(emailValidator.isValidEmail("a.b@test.pe")); // Puntos en local
        assertTrue(emailValidator.isValidEmail("a@b.pe")); // Longitud mínima exacta
    }

    // Prueba 3: Estructura general inválida (Sin arroba, dominios rotos)
    @Test
    void testInvalidStructure() {
        assertFalse(emailValidator.isValidEmail("sinarroba.com"));
        assertFalse(emailValidator.isValidEmail("user@.com")); // Dominio empieza con punto
        assertFalse(emailValidator.isValidEmail("user@domain.c")); // Extensión muy corta
    }

    // Prueba 4: Parte local inválida (Puntos inicio/fin/consecutivos)
    @Test
    void testInvalidLocalPart() {
        assertFalse(emailValidator.isValidEmail(".user@domain.com")); // Empieza con punto
        assertFalse(emailValidator.isValidEmail("user.@domain.com")); // Termina con punto
        assertFalse(emailValidator.isValidEmail("us..er@domain.com")); // Puntos consecutivos
    }

    // Prueba 5: Parte dominio inválida (Puntos al final o consecutivos)
    @Test
    void testInvalidDomainPart() {
        assertFalse(emailValidator.isValidEmail("user@domain.com.")); // Termina con punto
        assertFalse(emailValidator.isValidEmail("user@domain..com")); // Puntos consecutivos
    }

    // Prueba 6: Límites de longitud excedidos
    @Test
    void testLengthBoundaries() {
        assertFalse(emailValidator.isValidEmail("short")); // Menor a 6
        assertFalse(emailValidator.isValidEmail("a".repeat(250) + "@test.com")); // Mayor a 254
    }
}