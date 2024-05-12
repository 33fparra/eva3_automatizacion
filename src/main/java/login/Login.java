package login;

import java.sql.Connection;

public class Login {

    public static void main(String[] args) {
        System.out.println("Aplicación iniciada");
        try (MysqlDbConnection dbConnection = new MysqlDbConnection()) {
            Connection connection = dbConnection.getConnection();
            // Aquí podrías añadir más lógica para interactuar con la base de datos
            System.out.println("Conexión exitosa: " + (connection != null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

