package RegistroAlumnos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Giraldo
 */
public class SistemaAlumnos extends Alumno {

    private final List<SistemaAlumnos> alumnos = new ArrayList<>();
    private int id;

    public void informacionAlumnos() {

        int numeroAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de alumnos"));
        for (int i = 0; i < numeroAlumnos; i++) {
            List<Double> calificaciones = new ArrayList<>();
            SistemaAlumnos mensajero = new SistemaAlumnos();

            String nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre del alumno numero " + (i + 1));
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa edad del alumno"));

            int numeroCalificaciones = Integer.parseInt(JOptionPane.showInputDialog("Cuantas calificaciones desea ingresar para este alumno "));

            for (int j = 0; j < numeroCalificaciones; j++) {
                double calificacion = Double.parseDouble(JOptionPane.showInputDialog("Digite la calificacion numero "
                        + (j + 1)));
                calificaciones.add(calificacion);

            }
            id++;
            mensajero.setNombre(nombre);
            mensajero.setEdad(edad);
            mensajero.setId(id);
            mensajero.setCalificaciones(calificaciones);
            alumnos.add(mensajero);

        }
        menu(alumnos);
    }

    public void menu(List<SistemaAlumnos> alumnos) {
        int idConsultar;
        boolean bandera = true;
        while (bandera) {

            int opciones = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingresa el numero de la accion que deseas realizar\n"
                    + "1. Obtener información de el alumno\n"
                    + "2. Calcular promedio de el alumno\n"
                    + "3. Salir"));

            switch (opciones) {
                case 1:
                    idConsultar = Integer.parseInt(JOptionPane.showInputDialog("Digite el id del alumno a consultar"));
                    if ((idConsultar - 1) <= alumnos.size()) {
                        informacionAlumnoIngresado(alumnos.get((idConsultar - 1)));
                    } else {
                        JOptionPane.showMessageDialog(null, "El id ingresado no existe");
                    }
                    break;
                case 2:
                    idConsultar = Integer.parseInt(JOptionPane.showInputDialog("Digite el id de el alumno para promediar sus notas"));
                    if ((idConsultar - 1) <= alumnos.size()) {
                        JOptionPane.showMessageDialog(null, "\"El estudiante  " + alumnos.get(idConsultar - 1).getNombre());
                        calcularPromedio(alumnos.get(idConsultar - 1).getCalificaciones());
                    } else {
                        JOptionPane.showMessageDialog(null, "El id ingresado no existe");
                    }
                    break;
                case 3:
                    bandera = false;
                    JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                    break;
                default:
            }
        }
    }

    public void informacionAlumnoIngresado(SistemaAlumnos datos) {

        System.out.print("\n"+"Id alumno: " + datos.getId() + "\n" + "Nombre alumno: " + datos.getNombre()
                + "\n" + "Edad alumno: " + datos.getEdad() + "\n" + "Calificaciones alumno: " );
        for (Double calificacion : datos.getCalificaciones()) {

            System.out.print("   " +calificacion);
        }
    }

    public void calcularPromedio(List<Double> notas) {
        double promedio = 0;
        for (Double calificacion : notas) {
            promedio = promedio + calificacion;

        }
        promedio = promedio / notas.size();
        JOptionPane.showMessageDialog(null, "Tiene un promedio de notas de: " + promedio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
