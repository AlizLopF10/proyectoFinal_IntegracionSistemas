import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Student {
  matricula: string;
  nombre: string;
  apellidoP: string;
  apellidoM: string;
  email: string;
  licenciatura: string;
}

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private apiUrl = 'http://localhost:8080/students';

  constructor(private http: HttpClient) {}

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.apiUrl);
  }

  getStudent(matricula: string): Observable<Student> {
    return this.http.get<Student>(`${this.apiUrl}/${matricula}`);
  }

  createStudent(student:Student): Observable<Student> {
    return this.http.post<Student>(this.apiUrl, student);
  }

  updateStudent(student: Student): Observable<Student> {
    return this.http.put<Student>(`${this.apiUrl}/${student.matricula}`,student);
  }

  deleteEmployee(matricula: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${matricula}`);
  }
}
