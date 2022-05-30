package typing.dao;


public class UserDaoImpl {


    public boolean login(String username, String password) {
        return username.equals("test") && password.equals("12345");
    }
}
