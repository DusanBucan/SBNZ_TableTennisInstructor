import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { FormBuilder, Validators, FormControl } from '@angular/forms';
import { TrainingSearchEntity } from 'src/app/models/training-search-model/training-search.model';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { SkillService } from 'src/app/services/skill-service/skill.service';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';
import { TrainingEntity } from 'src/app/models/training-model/training.model';
import { MatTableDataSource } from '@angular/material/table';
import { HttpErrorResponse } from '@angular/common/http';
import { UserHealthService } from 'src/app/services/user-health/user-health.service';
import { UserService } from 'src/app/services/user-service/user.service';
import { SimulateTrainingEntity } from 'src/app/models/training-simulate-requst-model/training-simulate-request.model';

@Component({
  selector: 'app-find-training',
  templateUrl: './find-training.component.html',
  styleUrls: ['./find-training.component.scss']
})
export class FindTrainingComponent implements OnInit {

  findTraining;
  submitted;
  trainingSearch: TrainingSearchEntity;
  skills: any[];
  trainings: TrainingEntity[];

  trainingDurationCntr: FormControl;
  desiredSkillCntr: FormControl;
  dataSource;
  displayedColumns: string[] = ['id', 'name', 'trainingLvL', 'skillLvl', 'timeToExecute', 'actions'];

  constructor(
    private trainingService: TrainingService,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private skillService: SkillService,
    private userHealthService: UserHealthService,
    private userService: UserService
  ) {

    this.dataSource = null;

    this.trainingDurationCntr = new FormControl({ value: '', disabled: false},
       [Validators.required, Validators.min(0)]);

    this.desiredSkillCntr = new FormControl({ value: '', disabled: false}, Validators.required );

    this.findTraining = this.formBuilder.group({
      trainingDuration: this.trainingDurationCntr,
      desiredSkill: this.desiredSkillCntr
    });
  }

  ngOnInit() {
    this.skillService.getAll().subscribe(data => {
      this.skills = data as SkillEntity[];
      this.trainings = [];
    }, (err: HttpErrorResponse) => {
      console.log(err.message);
    });
  }

  get form() {
    return this.findTraining.controls;
  }

  onSubmit(findTraining) {
    this.submitted = true;
    this.trainings = [];
    if (findTraining.status === 'VALID') {
      const userId = JSON.parse(this.authService.getUser()).id;
      let haveUh = false;
      this.userHealthService.findUserHealthById(userId)
        .subscribe(res => {
            if (res !== null) {
              haveUh = true;
            }
        },
        (err: HttpErrorResponse) => {
          alert('morate prvo uneti podatke o UserHealt');
          console.log(err.message);
          console.log('greskaa');
        },
        () => {
          if (haveUh) {
            console.log('dosaoo');
            this.findTrainingHelper(userId);
          } else {
            alert('morate prvo uneti podatke o UserHealt');
          }
        });
      }
    }

  findTrainingHelper(userId: number) {
      this.trainingSearch =
      new TrainingSearchEntity(userId, null, this.desiredSkillCntr.value,
            this.trainingDurationCntr.value);

      console.log(this.trainingSearch);

      this.trainingService.findTrainingPlan(this.trainingSearch).subscribe(
        res => {
          console.log(res);
          this.trainings = res as TrainingEntity[];
          this.dataSource = new MatTableDataSource(
            this.trainings.map(t => {
              return {
                id : t.id,
                name: t.skill.name,
                trainingLvL: t.trainingLevel,
                skillLvl: t.skill.skillLevel,
                timeToExecute : t.timeToExecute,
              };
            })
          );
          console.log(this.dataSource);
      });
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  simulateTraining(trainingId: number) {
    console.log(trainingId);
    const userId = this.userService.getUserFromLocalStorage().id;
    this.trainingService.simulateTraining(new SimulateTrainingEntity(trainingId, userId))
    .subscribe(res => {
      console.log(res);
    });
  }

}
