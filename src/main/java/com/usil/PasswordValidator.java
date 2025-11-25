package com.usil;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        // Longitud mínima 8, máxima 64
        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        int spaceCount = 0;

        String specialChars = "!@#$%^&*()_-+={}[]|:;\"'<>,.?/";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.contains(String.valueOf(c))) hasSpecial = true;
            else if (c == ' ') {
                spaceCount++;
                // No espacios al inicio ni al final
                if (i == 0 || i == password.length() - 1) return false;
            } else {
                return false; // Caracter no permitido
            }
        }

        // Solo 1 espacio permitido en el medio
        if (spaceCount > 1) return false;

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}