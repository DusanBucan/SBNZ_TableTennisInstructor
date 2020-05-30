import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { FormBuilder, Validators } from '@angular/forms';
import { TrainingSearchEntity } from 'src/app/models/training-search-model/training-search.model';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { SkillService } from 'src/app/services/skill-service/skill.service';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';

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

  constructor(
    private trainingService: TrainingService,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private skillService: SkillService
  ) {
    this.findTraining = this.formBuilder.group({
      trainingDuration: ['', Validators.required],
      desiredSkill: ['', Validators.required],
    });
  }

  ngOnInit() {
    this.skillService.getAll().subscribe(data => {
      this.skills = data as SkillEntity[];
    });
  }

  get form() {
    return this.findTraining.controls;
  }

  onSubmit(findTraining) {
    this.submitted = true;
    if (findTraining.valid) {
      const userId = JSON.parse(this.authService.getUser()).id;

      this.trainingSearch =
         new TrainingSearchEntity(userId, null, findTraining.desiredSkill, findTraining.trainingDuration);
      console.log(this.trainingSearch);

      this.trainingService.findTrainingPlan(this.trainingSearch).subscribe(
        res => {
          console.log(res);
      });
    }
  }

}
