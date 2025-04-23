package mx.uam.grade_service;

public class Grade {
    private String matricula;
    private String materia;
    private double calificacion;
    private String nota;
    private String profesor;
    private String trimestre;

    public Grade() {
    }

    public Grade(String matricula, String materia, double calificacion, String nota, String profesor, String trimestre) {
        this.matricula = matricula;
        this.materia = materia;
        this.calificacion = calificacion;
        this.nota = nota;
        this.profesor = profesor;
        this.trimestre = trimestre;

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public String getTrimestre() {
        return trimestre;
    }
}