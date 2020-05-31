import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindTrainingComponent } from './find-training.component';

describe('FindTrainingComponent', () => {
  let component: FindTrainingComponent;
  let fixture: ComponentFixture<FindTrainingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindTrainingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
