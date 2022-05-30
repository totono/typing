package typing;

import org.junit.Test;
import typing.utils.DBUtils;
import typing.utils.PasswordEncryption;
import static org.junit.Assert.*;

public class DBUtilsTest {

    @Test
    public void user_exists() {
        assertEquals(true,DBUtils.isUserExists("debug"));
    }

    @Test
    public void user_doesnt_exists() {
        assertEquals(false, DBUtils.isUserExists("doesntexists"));
    }

    @Test
    public void user_has_correct_password() {
        assertEquals(true, DBUtils.isCorrectCred("testuser6", "password"));
    }

    @Test
    public void user_can_register() {
        String username = "testuser1";
        String password = PasswordEncryption.encryption("password");
        DBUtils.userRegister(username,password);
        
        assertEquals(true,DBUtils.isUserExists(username));
    }

}
