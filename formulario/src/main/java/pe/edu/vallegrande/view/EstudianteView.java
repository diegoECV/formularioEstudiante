package pe.edu.vallegrande.view;

import pe.edu.vallegrande.controller.EstudianteController;
import pe.edu.vallegrande.model.Estudiante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EstudianteView extends JFrame {
    private JTable table;
    private EstudianteController controller;

    public EstudianteView() {
        controller = new EstudianteController();
        setTitle("Gestión de Estudiantes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        cargarDatos();
    }

    private void initComponents() {
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Botones
        JButton btnInsertar = new JButton("Insertar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar Lógico");
        JButton btnListar = new JButton("Listar");

        panel.add(btnInsertar);
        panel.add(btnModificar);
        panel.add(btnEliminar);
        panel.add(btnListar);

        add(panel, BorderLayout.SOUTH);

        btnInsertar.addActionListener(e -> crearEstudiante());
        btnModificar.addActionListener(e -> modificarEstudiante());
        btnEliminar.addActionListener(e -> eliminarEstudiante());
        btnListar.addActionListener(e -> cargarDatos());
    }

    public void cargarDatos() {
        String[] columnas = {"ID", "Nombre", "Apellido", "Correo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        List<Estudiante> estudiantes = controller.listarEstudiantesActivos();

        for (Estudiante estudiante : estudiantes) {
            Object[] fila = {estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getCorreo(), estudiante.isEstado()};
            modelo.addRow(fila);
        }

        table.setModel(modelo);
    }

    private void crearEstudiante() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre:");
        String apellido = JOptionPane.showInputDialog(this, "Apellido:");
        String correo = JOptionPane.showInputDialog(this, "Correo:");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCorreo(correo);
        estudiante.setEstado(true);

        controller.insertarEstudiante(estudiante);
        cargarDatos();
    }

    private void modificarEstudiante() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID del estudiante a modificar:"));
        String nombre = JOptionPane.showInputDialog(this, "Nuevo nombre:");
        String apellido = JOptionPane.showInputDialog(this, "Nuevo apellido:");
        String correo = JOptionPane.showInputDialog(this, "Nuevo correo:");

        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCorreo(correo);
        estudiante.setEstado(true);

        controller.modificarEstudiante(estudiante);
        cargarDatos();
    }

    private void eliminarEstudiante() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID del estudiante a eliminar lógicamente:"));
        controller.eliminarLogicoEstudiante(id);
        cargarDatos();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstudianteView().setVisible(true));
    }
}
