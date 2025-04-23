package mx.uam.grade_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{matricula}")
    public List<Grade> getGradesByMatricula(@PathVariable String matricula) {
        return gradeService.getGradesByMatricula(matricula);
    }

    @PostMapping
    public String addGrade(@RequestBody Grade grade) {
        gradeService.addGrade(grade);
        return "La calificación se ha agregado correctamente.";
    }

    @PutMapping("/{matricula}/{materia}")
    public String updateGrade(@PathVariable String matricula, @PathVariable String materia, @RequestBody Grade grade) {
        boolean updated = gradeService.updateGrade(matricula, materia, grade.getMateria(), grade.getCalificacion(), grade.getNota(), grade.getProfesor(), grade.getTrimestre());
        return updated ? "La calificación se ha actualizado correctamente."
                : "No se encontró la calificación para actualizar.";
    }

    @DeleteMapping("/{matricula}/{materia}")
    public String deleteGrade(@PathVariable String matricula, @PathVariable String materia) {
        boolean deleted = gradeService.deleteGrade(matricula, materia);
        return deleted ? "La calificación se ha eliminado correctamente."
                : "No se encontró la calificación para eliminar.";
    }
}