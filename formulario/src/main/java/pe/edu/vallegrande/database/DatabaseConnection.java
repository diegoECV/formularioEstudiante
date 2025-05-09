package pe.edu.vallegrande.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/escuela";
    private static final String USER = "root";  // Ajusta tu usuario
    private static final String PASSWORD = "123456diego";  // Ajusta tu contraseña

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
