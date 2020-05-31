import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { FormBuilder, Validators, FormControl } from '@angular/forms';
import { TrainingSearchEntity } from 'src/app/models/training-search-model/training-search.model';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { SkillService } from 'src/app/services/skill-service/skill.service';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';
import { TrainingEntity } from 'src/app/models/training-model/training.model';

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

  constructor(
    private trainingService: TrainingService,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private skillService: SkillService
  ) {

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

      this.trainingSearch =
         new TrainingSearchEntity(userId, null, this.desiredSkillCntr.value,
                this.trainingDurationCntr.value);

      console.log(this.trainingSearch);

      this.trainingService.findTrainingPlan(this.trainingSearch).subscribe(
        res => {
          console.log(res);
          this.trainings = res as TrainingEntity[];
      });
    }
  }

}
