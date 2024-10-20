package com.spaceinvaders.space_invaders.utils;
import java.util.Base64;



public class DataEncryption {
	
    public static String encryptData(String data) {
        byte[] bytesToEncrypt = data.getBytes();

        String encodedData = Base64.getEncoder().encodeToString(bytesToEncrypt);

        return encodedData;
    }
    
    public static String decryptData(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
        String decryptedData = new String(decodedBytes);

        return decryptedData;
    }
    
}
