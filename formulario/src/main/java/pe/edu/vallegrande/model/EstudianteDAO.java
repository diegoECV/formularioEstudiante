package pe.edu.vallegrande.model;

import pe.edu.vallegrande.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    // Insertar estudiante
    public void insertarEstudiante(Estudiante estudiante) {
        String sql = "INSERT INTO estudiantes (nombre, apellido, correo, estado) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getCorreo());
            stmt.setBoolean(4, estudiante.isEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modificar estudiante
    public void modificarEstudiante(Estudiante estudiante) {
        String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, correo = ?, estado = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getCorreo());
            stmt.setBoolean(4, estudiante.isEstado());
            stmt.setInt(5, estudiante.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar lógicamente estudiante (cambiar estado a 0)
    public void eliminarLogicoEstudiante(int id) {
        String sql = "UPDATE estudiantes SET estado = 0 WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar estudiantes activos
    public List<Estudiante> listarEstudiantesActivos() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes WHERE estado = 1";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCorreo(rs.getString("correo"));
                estudiante.setEstado(rs.getBoolean("estado"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

    // Listar estudiantes eliminados
    public List<Estudiante> listarEstudiantesEliminados() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes WHERE estado = 0";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCorreo(rs.getString("correo"));
                estudiante.setEstado(rs.getBoolean("estado"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
}
