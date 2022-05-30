package typing.utils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {
    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //パスワードハッシュと入力パスワードの一致確認
    public static boolean checkPassword(String rowPassword,String encryptedPassword) {
        return encoder.matches(rowPassword,encryptedPassword);
    }

    //入力パスワードのハッシュ化
    public static String encryption(String password) {
        return encoder.encode(password);
    }

}

