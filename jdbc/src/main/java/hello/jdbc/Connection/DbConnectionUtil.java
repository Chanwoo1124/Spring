package hello.jdbc.Connection;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.Connection.ConnectionConst.*;

@Slf4j
public class DbConnectionUtil {

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection = {}, class ={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
