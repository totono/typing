package typing.utils;

import java.util.UUID;
import java.util.Date;
import java.util.Optional;

import org.jdbi.v3.core.Jdbi;


public class DBUtils {

    final static String SQL_URL = "jdbc:postgresql://localhost:49153/typing_game";
    final static String SQL_USER = "postgres";
    final static String SQL_PASS = "postgrespw";
    static Jdbi jdbi = Jdbi.create(SQL_URL,SQL_USER,SQL_PASS);
    
    //アカウント名の存在チェック
    public static boolean isUserExists(String username) {
            return jdbi.withHandle(handle -> 
            {
            return handle.select("SELECT user_name FROM userdata WHERE user_name = ?",username)
            .mapTo(String.class)
            .findOne()
            .isPresent();  
            }
        );
    }

    //アカウント名と入力フィールドのパスから資格情報が正しいかどうか
    public static boolean isCorrectCred(String username, String inputPassword){
        Optional<String> encryptedPassword = jdbi.withHandle(handle -> 
        {
            return handle.select("SELECT password FROM userdata WHERE user_name = ?",username)
            .mapTo(String.class)
            .findOne();  
        });
        if (encryptedPassword.isEmpty()) {
            return false;
        } else {
            return PasswordEncryption.checkPassword(inputPassword, encryptedPassword.get());
        }
    }


    //ユーザーの存在チェックを行い、存在しなければ登録
    //Todo : 登録されたかどうかをboolで返したい 
    public static void userRegister(String username, String password) {
        if(!(isUserExists(username))){            
            Date date = new Date();
            String uuid = UUID.randomUUID().toString();
            jdbi.useHandle(handle ->{
                handle.createUpdate("INSERT INTO userdata (uuid,user_name,password,register_date) VALUES (:uuid, :user_name ,:password,:register_date)")
                .bind("uuid",uuid)
                .bind("user_name",username)
                .bind("password",password)
            .bind("register_date",date)
            .execute();
        });
    }

} 
}
