import { Component, OnInit } from '@angular/core';
import { StudentService, Student } from '../student.service';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-studentscontrol',
  standalone: true,
  imports: [CommonModule, MatCardModule],
  templateUrl: './studentscontrol.component.html',
  styleUrl: './studentscontrol.component.css'
})
export class StudentscontrolComponent implements OnInit {
  students: Student[] = [];

  constructor(private studentService: StudentService) {}

  ngOnInit() {
    this.studentService.getAllStudents().subscribe(
      
      (data: Student[]) => {
        this.students = data;
    });
  }
}
