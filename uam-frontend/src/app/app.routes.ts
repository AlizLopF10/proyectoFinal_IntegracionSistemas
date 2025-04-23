import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentscontrolComponent } from './studentscontrol/studentscontrol.component';  
import { GradesListComponent } from './grades-list/grades-list.component';  

export const routes: Routes = [
  { path: '', redirectTo: 'students', pathMatch: 'full' },  
  { path: 'students', component: StudentscontrolComponent },  
  { path: 'grades', component: GradesListComponent }  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
