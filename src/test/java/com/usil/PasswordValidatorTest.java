package com.usil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    // Prueba 1: Validar excepciones por Nulo o Vacío
    @Test
    void testPasswordNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(""));
    }

    // Prueba 2: Validar contraseñas correctas (Caminos felices y límites válidos)
    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
        assertTrue(PasswordValidator.isValid("Secure 123!")); // Espacio permitido
        assertTrue(PasswordValidator.isValid("Abcdef1!")); // Límite inferior (8)
        assertTrue(PasswordValidator.isValid("A".repeat(58) + "1a!")); // Límite superior (64)
    }

    // Prueba 3: Validar longitud inválida (Muy corta o muy larga)
    @Test
    void testInvalidLength() {
        assertFalse(PasswordValidator.isValid("Short1!")); // Menos de 8
        assertFalse(PasswordValidator.isValid("A".repeat(65) + "1!")); // Más de 64
    }

    // Prueba 4: Validar requisitos faltantes (Mayúscula, Minúscula, Dígito)
    @Test
    void testMissingRequirements() {
        assertFalse(PasswordValidator.isValid("nosecure123!")); // Falta Mayúscula
        assertFalse(PasswordValidator.isValid("NOSECURE123!")); // Falta Minúscula
        assertFalse(PasswordValidator.isValid("NoDigit!"));     // Falta Número
        assertFalse(PasswordValidator.isValid("NoSpecial1"));   // Falta Caracter Especial
    }

    // Prueba 5: Validar reglas de espacios incorrectos
    @Test
    void testInvalidSpacing() {
        assertFalse(PasswordValidator.isValid(" SpaceStart1!")); // Espacio al inicio
        assertFalse(PasswordValidator.isValid("SpaceEnd1! "));   // Espacio al final
        assertFalse(PasswordValidator.isValid("Two  Spaces1!")); // Dos espacios consecutivos
    }

    // Prueba 6: Validar caracteres prohibidos
    @Test
    void testInvalidCharacters() {
        assertFalse(PasswordValidator.isValid("Secure123~")); // Caracter no permitido (~)
    }
}