package com.arquimentor.platform.arquimentor.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public record Password(String password) {
    // Contraseña de 8-16 caracteres con al menos un dígito, al menos uno
    // letra minúscula, al menos una letra mayúscula, al menos una
    // caracter especial sin espacios en blanco

    public Password(){
        this(null);
    }

    public Password{
        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password cannot be null or blank");

    }

}
