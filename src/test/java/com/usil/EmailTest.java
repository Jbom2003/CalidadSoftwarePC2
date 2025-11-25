package com.usil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    Email emailValidator = new Email();

    // Prueba 1: Null
    @Test
    void testEmailNull() {
        assertThrows(IllegalArgumentException.class, () -> emailValidator.isValidEmail(null));
    }

    // Prueba 2: Vacío
    @Test
    void testEmailEmpty() {
        assertThrows(IllegalArgumentException.class, () -> emailValidator.isValidEmail(""));
    }

    // Prueba 3: Gmail
    @Test
    void testValidGmail() {
        assertTrue(emailValidator.isValidEmail("cliente@gmail.com"));
    }

    // Prueba 4: Dominio .pe
    @Test
    void testValidPe() {
        assertTrue(emailValidator.isValidEmail("usuario@empresa.pe"));
    }

    // Prueba 5: Dominio .org
    @Test
    void testValidOrg() {
        assertTrue(emailValidator.isValidEmail("info@ong.org"));
    }

    // Prueba 6: Email con números
    @Test
    void testValidNumbers() {
        assertTrue(emailValidator.isValidEmail("user2025@test.net"));
    }
}