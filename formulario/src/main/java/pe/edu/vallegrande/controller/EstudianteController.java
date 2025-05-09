package pe.edu.vallegrande.controller;

import pe.edu.vallegrande.model.Estudiante;
import pe.edu.vallegrande.service.EstudianteService;

import java.util.List;

public class EstudianteController {
    private EstudianteService estudianteService;

    public EstudianteController() {
        this.estudianteService = new EstudianteService();
    }

    public void insertarEstudiante(Estudiante estudiante) {
        estudianteService.insertarEstudiante(estudiante);
    }

    public void modificarEstudiante(Estudiante estudiante) {
        estudianteService.modificarEstudiante(estudiante);
    }

    public void eliminarLogicoEstudiante(int id) {
        estudianteService.eliminarLogicoEstudiante(id);
    }

    public List<Estudiante> listarEstudiantesActivos() {
        return estudianteService.listarEstudiantesActivos();
    }

    public List<Estudiante> listarEstudiantesEliminados() {
        return estudianteService.listarEstudiantesEliminados();
    }
}
