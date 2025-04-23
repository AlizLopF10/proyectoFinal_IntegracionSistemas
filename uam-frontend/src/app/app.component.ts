import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { StudentService, Student } from './student.service';
import { GradeService, Grade } from './grades.service';
import { MatCardModule } from '@angular/material/card';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatListModule } from '@angular/material/list'; // para mostrar lista de calificaciones
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, MatCardModule, MatExpansionModule, MatListModule, MatIconModule, MatTabsModule],
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  studentsWithGrades: { student:Student; grades: Grade[] }[] = [];

  constructor(
    private studentService: StudentService,
    private gradeService: GradeService
  ) {}

  ngOnInit() {
    this.studentService.getAllStudents().subscribe(students => {
      
      students.forEach(student => {
        this.gradeService.getGradesByMatricula(student.matricula).subscribe(grades => {
          this.studentsWithGrades.push({ student, grades });
        });
      });
    });
  }
  
}