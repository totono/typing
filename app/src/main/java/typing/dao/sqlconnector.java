package typing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sqlconnector {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultset = null;

    String url = "jdbc:postgres://postgres:postgrespw@localhost:49153";
    
}
