package com.usil;

import java.util.regex.Pattern;

public class Email {
    // Regex estricto según requerimientos
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_]+([.-][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.-][a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }
        if (email.length() < 6 || email.length() > 254) {
            return false;
        }
        // Validaciones manuales extra para puntos consecutivos o inicio/fin
        if (email.startsWith(".") || email.endsWith(".")) return false;
        if (email.contains("..")) return false;

        return PATTERN.matcher(email).matches();
    }
}