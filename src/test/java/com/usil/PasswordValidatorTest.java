package com.usil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    // Prueba 1: Exception por Null
    @Test
    void testPasswordNull() {
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(null));
    }

    // Prueba 2: Exception por Vacío
    @Test
    void testPasswordEmpty() {
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(""));
    }

    // Prueba 3: Caso Feliz Estándar
    @Test
    void testValidPasswordStandard() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    // Prueba 4: Caso Feliz con Espacio permitido
    @Test
    void testValidPasswordWithSpace() {
        assertTrue(PasswordValidator.isValid("Secure 123!"));
    }

    // Prueba 5: Caso Feliz Largo
    @Test
    void testValidPasswordLong() {
        assertTrue(PasswordValidator.isValid("VeryLongPassword123!@#"));
    }

    // Prueba 6: Caso Feliz Complejo
    @Test
    void testValidPasswordComplex() {
        assertTrue(PasswordValidator.isValid("Hard2Gu3ss$"));
    }
}