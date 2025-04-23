package mx.uam.grade_service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeService {

    private final List<Grade> grades = new ArrayList<>();

    // Constructor con algunas calificaciones de ejemplo
    public GradeService() {
        grades.add(new Grade("2183076782", "Análisis y Diseño de Algoritmos", 8, "B", "Santiago Negrete", "25I"));
        grades.add(new Grade("2183076782", "Programación Estructurada", 10, "MB", "Adolfo Herrera", "25I"));
        grades.add(new Grade("2183087810", "Sistemas Digitales", 6, "S", "Arelí Rojo", "25I"));
        grades.add(new Grade("2183076522", "Arquitectura de Redes", 10, "MB", "Carlos Rivero", "25I"));
        grades.add(new Grade("2183076522", "Programación de Web Estático", 8, "B", "Carmen Bustillo", "25I"));
        grades.add(new Grade("2183076451", "Calculo I", 5, "NA", "Jonatán Torres", "25I"));
        grades.add(new Grade("2223027818", "Laboratorio Temático IV", 10, "", "Lizbeth Noguez", "25I"));
        grades.add(new Grade("2223027818", "Taller de Redes", 10, "MB", "Diana Román", "25I"));
        grades.add(new Grade("2223027818", "Comunicación, Información y Sistemas", 10, "MB", "Tiburcio Moreno", "25I"));
        grades.add(new Grade("2173033702", "Análisis de Requerimientos", 6, "S", "Alejandro Lara", "25I"));
        grades.add(new Grade("2183077449", "Probabilidad y Estadística", 10, "MB", "Lizbeth Noguez", "25I"));
        grades.add(new Grade("2183077449", "Arquitectura de Redes", 8, "B", "Diana Román", "25I"));
        grades.add(new Grade("2183077449", "Laboratorio Temático I", 10, "MB", "Guillermo Monroy", "25I"));
        grades.add(new Grade("2183076764", "Proyecto de Ingenieria de Software", 6, "S", "Alba Rocio Nuñez", "25I"));
        grades.add(new Grade("2183076764", "Probabilidad y Estadística", 8, "B", "Ismael Robles", "25I"));
        grades.add(new Grade("2183076764", "Microcontroladores", 8, "B", "Erik Reyes","25I"));
        grades.add(new Grade("2223027532", "Introducción a las corrientes psicologicas", 10, "MB", "Tiburcio Moreno", "25I"));
        grades.add(new Grade("2223027532", "Interacción Humano-Computadora", 10, "MB", "Adolfo Herrera", "25I"));


    }

    public List<Grade> getAllGrades() {
        return grades;
    }

    public List<Grade> getGradesByMatricula(String matricula) {
        return grades.stream()
                .filter(g -> g.getMatricula().equals(matricula))
                .collect(Collectors.toList());
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public boolean deleteGrade(String matricula, String materia) {
        return grades.removeIf(g -> g.getMatricula().equals(matricula) && g.getMateria().equalsIgnoreCase(materia));
    }

    public boolean updateGrade(String matricula, String materia, String nuevamateria, double nuevaCalificacion, String nuevanota, String nuevoprofesor, String nuevotrimestre) {
        for (Grade grade : grades) {
            if (grade.getMatricula().equals(matricula) && grade.getMateria().equalsIgnoreCase(materia)) {
                grade.setMateria(nuevamateria);
                grade.setCalificacion(nuevaCalificacion);
                grade.setNota(nuevanota);
                grade.setProfesor(nuevoprofesor);
                grade.setTrimestre(nuevotrimestre);
                return true;
            }
        }
        return false;
    }
}