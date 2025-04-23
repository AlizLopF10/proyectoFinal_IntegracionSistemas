import { Component, OnInit, Input } from '@angular/core';
import { GradeService, Grade } from '../grades.service';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-grades-list',
  standalone: true,
  imports: [CommonModule, MatCardModule],
  templateUrl: './grades-list.component.html',
  styleUrls: ['./grades-list.component.css']
})

export class GradesListComponent implements OnInit {
  @Input() matricula: string = '';  
  grades: Grade[] = []; 

  constructor(private gradeService: GradeService) {} 

  ngOnInit() {
    if (this.matricula) {
      this.gradeService.getGradesByMatricula(this.matricula).subscribe(data => {  
        this.grades = data; 
      });
    }
  }
}
