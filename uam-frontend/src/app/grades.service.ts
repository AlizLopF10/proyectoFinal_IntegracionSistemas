import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Grade {
  matricula: string;
  materia: string;
  calificacion: number;
  nota: string;
  profesor: string;
  trimestre: string;
}

@Injectable({
  providedIn: 'root'
})
export class GradeService {
  private apiUrl = 'http://localhost:8081/grades';

  constructor(private http: HttpClient) {}

  getAllGrades(): Observable<Grade[]> {
    return this.http.get<Grade[]>(this.apiUrl);
  }

  getGradesByMatricula(matricula: string): Observable<Grade[]> {
    return this.http.get<Grade[]>(`${this.apiUrl}/${matricula}`);
  }

  createGrade(grades:Grade): Observable<Grade> {
    return this.http.post<Grade>(this.apiUrl, grades);
  }

  updateGrade(grades: Grade): Observable<Grade> {
    return this.http.put<Grade>(`${this.apiUrl}/${grades.matricula}`,
    grades);
  }

  deleteGrade(matricula: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${matricula}`);
  }
}
