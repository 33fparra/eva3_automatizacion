package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDbConnection implements AutoCloseable {

    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";
    private static final String URL = "jdbc:mysql://tu_host:3306/tu_base_de_datos";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection connection;

    public MysqlDbConnection() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
