package edu.pucmm.pw.entidades;

import java.util.Objects;

/**
 * Objeto con estructura POJO.
 */
public class Estudiante {

    private int matricula;
    private String nombre;
    private String carrera;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Estudiante() {
    }

    public Estudiante(int matricula, String nombre, String carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public Estudiante(int matricula, String nombre, String carrera, String id) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void mezclar(Estudiante e){
        matricula = e.getMatricula();
        nombre = e.getNombre();
        carrera = e.getCarrera();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return matricula == that.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
