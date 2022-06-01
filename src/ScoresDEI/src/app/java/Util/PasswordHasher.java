package Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordHasher {
    // region Public methods

    /**
     * Method used to encrypt the password.
     * @param password the password to encrypt.
     * @return the encrypted password.
     */
    public static String encrypt(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    // endregion Public methods

}
