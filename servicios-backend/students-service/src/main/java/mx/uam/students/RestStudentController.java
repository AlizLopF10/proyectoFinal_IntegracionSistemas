package mx.uam.students;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/students")
public class RestStudentController {

    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("2183076782", "Jennifer", "Segura", "Tapia", "jennifer.segura@cua.uam.mx", "Tecnologías y Sistemas de Información"));
        students.add(new Student("2183087810", "Eduardo", "Hernandez", "Soto", "eduardo.hernandez@cua.uam.mx", "Ingeniería en Computación"));
        students.add(new Student("2183076522", "Alfonso", "Rojas", "Martinez", "alfonso.rojas@cua.uam.mx", "Tecnologías y Sistemas de Información"));
        students.add(new Student("2183076451", "Irving", "Sanchez", "Sedas", "irving.sanchez@cua.uam.mx", "Ingeniería en Computación"));
        students.add(new Student("2223027818", "Alicia", "López", "Flores", "alicia.lopez@cua.uam.mx", "Tecnologías y Sistemas de Información"));
        students.add(new Student("2173033702", "Daniel", "Aldama", "Barrera", "daniel.aldama@cua.uam.mx", "Ingeniería en Computación"));
        students.add(new Student("2183077449", "Vivian", "Reynoso", "Sanchez", "vivian.reynoso@cua.uam.mx", "Tecnologías y Sistemas de Información"));
        students.add(new Student("2183076764", "Agustin", "Mejia", "Lagos", "agustin.mejia@cua.uam.mx", "Ingeniería en Computación"));
        students.add(new Student("2223027532", "Patricia", "López", "Flores", "patricia.lopez@cua.uam.mx", "Tecnologías y Sistemas de Información"));
    }


    @GetMapping("/")
    public String home(){
        return "Esta es la página de inicio de la API de Estudiantes.";
    }

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{matricula}")
    public Student getStudent(@PathVariable String matricula) {
        return students.stream()
                .filter(student -> student.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{matricula}")
    public String deleteStudent(@PathVariable String matricula) {
        Student student = students.stream()
                .filter(e -> e.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
        if (student != null) {
            students.remove(student);
            return "El Estudiante se ha eliminado con éxito.";
        } else {
            return "Estudiante no encontrado.";
        }
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        boolean exists = students.stream()
                .anyMatch(e -> e.getMatricula().equals(student.getMatricula()));

        if (exists) {
            return "Ya existe un estudiante con esa matrícula.";
        }

        students.add(student);
        return "El estudiante se ha agregado con éxito.";
    }

    @PutMapping("/{matricula}")
    public String updateStudent(@PathVariable String matricula, @RequestBody Student student) {
        Student studentToUpdate = students.stream()
                .filter(e -> e.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);

        if (studentToUpdate != null) {
            studentToUpdate.setNombre(student.getNombre());
            studentToUpdate.setApellidoP(student.getApellidoP());
            studentToUpdate.setApellidoM(student.getApellidoM());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setLicenciatura(student.getLicenciatura());
            return "El estudiante se ha actualizado con éxito.";
        } else {
            return "Estudiante no encontrado.";
        }
    }
}