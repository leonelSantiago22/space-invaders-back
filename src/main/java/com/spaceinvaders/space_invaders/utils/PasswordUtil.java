package com.spaceinvaders.space_invaders.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Método para encriptar una contraseña
    public static String encriptarContrasena(String contrasena) {
        // El número 12 es el número de rondas de hash
        return BCrypt.hashpw(contrasena, BCrypt.gensalt(12));
    }

    // Método para verificar la contraseña con el hash almacenado
    public static boolean verificarContrasena(String contrasena, String hash) {
        return BCrypt.checkpw(contrasena, hash);
    }
}
