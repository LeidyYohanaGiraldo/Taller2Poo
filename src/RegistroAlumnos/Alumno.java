package RegistroAlumnos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leidy Giraldo
 */
public class Alumno {

    private String nombre;
    private int edad;
    private List<Double> calificaciones = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

}
