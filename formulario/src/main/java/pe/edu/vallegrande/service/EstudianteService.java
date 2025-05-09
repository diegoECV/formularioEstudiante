package pe.edu.vallegrande.service;

import pe.edu.vallegrande.model.Estudiante;
import pe.edu.vallegrande.model.EstudianteDAO;

import java.util.List;

public class EstudianteService {
    private EstudianteDAO estudianteDAO;

    public EstudianteService() {
        this.estudianteDAO = new EstudianteDAO();
    }

    public void insertarEstudiante(Estudiante estudiante) {
        estudianteDAO.insertarEstudiante(estudiante);
    }

    public void modificarEstudiante(Estudiante estudiante) {
        estudianteDAO.modificarEstudiante(estudiante);
    }

    public void eliminarLogicoEstudiante(int id) {
        estudianteDAO.eliminarLogicoEstudiante(id);
    }

    public List<Estudiante> listarEstudiantesActivos() {
        return estudianteDAO.listarEstudiantesActivos();
    }

    public List<Estudiante> listarEstudiantesEliminados() {
        return estudianteDAO.listarEstudiantesEliminados();
    }
}
