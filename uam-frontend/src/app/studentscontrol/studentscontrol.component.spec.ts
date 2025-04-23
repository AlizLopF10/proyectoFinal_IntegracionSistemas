import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentscontrolComponent } from './studentscontrol.component';

describe('StudentscontrolComponent', () => {
  let component: StudentscontrolComponent;
  let fixture: ComponentFixture<StudentscontrolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentscontrolComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StudentscontrolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
