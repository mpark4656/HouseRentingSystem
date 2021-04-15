package com.app.security;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.enterprise.context.ApplicationScoped;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@ApplicationScoped
public class PasswordHash {
    private SecretKeyFactory factory;
    private int iterations;
    private int keyLength;
    private byte[] salt;

    public PasswordHash() {
        try {
            iterations = 10000;
            keyLength = 512;
            salt = "1234".getBytes();
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        } catch(NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
    }

    public String hash(String password) {
        try {
            char[] passwordByte = password.toCharArray();
            PBEKeySpec spec = new PBEKeySpec(passwordByte, salt, iterations, keyLength);
            SecretKey key = factory.generateSecret(spec);
            byte[] res = key.getEncoded();
            return Hex.encodeHexString(res);
        } catch(InvalidKeySpecException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
