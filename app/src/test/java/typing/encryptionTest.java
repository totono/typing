package typing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import typing.utils.PasswordEncryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.apache.commons.logging.LogFactory;

public class encryptionTest {
    @Test
    public void password_encrypt_test() {
      Pbkdf2PasswordEncoder pbfk2enco = new Pbkdf2PasswordEncoder();
        String rawTestPass = "test";
        String encryptedPass = PasswordEncryption.encryption(rawTestPass);
        System.out.println(encryptedPass);
        assertEquals(true, pbfk2enco.matches(rawTestPass, encryptedPass)); 
    }

    @Test
    public void password_encrypt_test_wrong(){
        Pbkdf2PasswordEncoder pbfk2enco = new Pbkdf2PasswordEncoder();
        String rawTestPass = "test";
        String encryptedPass = PasswordEncryption.encryption(rawTestPass);
        System.out.println(encryptedPass);
        assertEquals(false, pbfk2enco.matches("wrong", encryptedPass));
    }


    @Test
    public void checkpassword2() {
        BCryptPasswordEncoder bcryptenco = new BCryptPasswordEncoder();
        String password = "password";
        String encrypted = bcryptenco.encode(password);
        System.out.println(bcryptenco.encode(encrypted));
        assertEquals(true, bcryptenco.matches("password",encrypted));
    }
}
