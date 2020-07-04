import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { UserService } from 'src/app/services/user-service/user.service';
import {TrainingHistoryEntity} from 'src/app/models/training-history-model/training-history.model';
import { HttpErrorResponse } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material';
import { TrainingHistorySearchEntity } from 'src/app/models/training-history-search-model/training.history.search.model';
import { TrainingMarkType } from 'src/app/models/training-history-model/training.mark.enum';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';
import { SkillService } from 'src/app/services/skill-service/skill.service';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-training-history',
  templateUrl: './training-history.component.html',
  styleUrls: ['./training-history.component.scss']
})
export class TrainingHistoryComponent implements OnInit {

  trainingHistory: TrainingHistoryEntity[];
  displayedColumns: string[] = ['id', 'skill', 'skillLvl', 'trainingLvl', 'trainingMark', 'date'];
  dataSource;

  allSkills: SkillEntity[];
  trainingMarks: TrainingMarkType[];

  trainingSearchParams: TrainingHistorySearchEntity;

  searchTrainingForm: FormGroup;
  skillCntr: FormControl;
  trainingMarklCntr: FormControl;
  fromTimeCntr: FormControl;
  submitted = false;

  constructor(
    private trainingService: TrainingService,
    private userService: UserService,
    private skillService: SkillService,
    private formBuilder: FormBuilder
  ) {
    this.dataSource = null;
    this.fromTimeCntr = new FormControl({ value: '', disabled: false},
        [Validators.required, Validators.min(0)]);
    this.skillCntr = new FormControl({ value: '', disabled: false}, [Validators.required]);
    this.trainingMarklCntr = new FormControl({ value: '', disabled: false}, [Validators.required]);

    this.searchTrainingForm = this.formBuilder.group({
      skill: this.skillCntr,
      trainingMark: this.trainingMarklCntr,
      fromTime : this.fromTimeCntr
    });
   }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  search(skillForm: any) {
      this.submitted = true;
      if (skillForm.status === 'VALID') {
        console.log('validna forma');
        const userId = this.userService.getUserFromLocalStorage().id;
        this.trainingSearchParams =
            new TrainingHistorySearchEntity(userId, this.skillCntr.value.skillId, this.trainingMarklCntr.value, this.fromTimeCntr.value);
        this.trainingService.getTrainingHistotyByUserId(this.trainingSearchParams)
          .subscribe((data: TrainingHistoryEntity[]) => {
            this.trainingHistory = data;
            this.dataSource = new MatTableDataSource(
              this.trainingHistory.map(t => {
                return {
                  id : t.id,
                  skillName: t.training.skill.name,
                  skillLvl: t.training.skill.skillLevel,
                  trainingLvl : t.training.trainingLevel,
                  trainingMark: t.trainingMark,
                  date: t.date
                };
              })
            );
          }, (error: HttpErrorResponse) => {
            console.error(error.message);}
          );
      }
  }

  ngOnInit() {
      const userId = this.userService.getUserFromLocalStorage().id;
      this.trainingSearchParams =
        new TrainingHistorySearchEntity(userId, -1, TrainingMarkType.UNKNOWN, -1);
      this.trainingService.getTrainingHistotyByUserId(this.trainingSearchParams)
            .subscribe(
          (data: TrainingHistoryEntity[]) => {
            this.trainingHistory = data;
            this.dataSource = new MatTableDataSource(
              this.trainingHistory.map(t => {
                return {
                  id : t.id,
                  skillName: t.training.skill.name,
                  skillLvl: t.training.skill.skillLevel,
                  trainingLvl : t.training.trainingLevel,
                  trainingMark: t.trainingMark,
                  date: t.date
                };
              })
            );
          }
          , (error: HttpErrorResponse) => {
            console.error(error.message);
          },
          () => {
            this.trainingMarks = [];
            this.trainingMarks.push(TrainingMarkType.UNKNOWN);
            this.trainingMarks.push(TrainingMarkType.BAD);
            this.trainingMarks.push(TrainingMarkType.GOOD);
            this.trainingMarks.push(TrainingMarkType.EXCELLENT);
            this.skillService.getAll().subscribe(res => {
              this.allSkills = res as SkillEntity[];
              this.trainingMarklCntr.setValue(TrainingMarkType.UNKNOWN);
              this.allSkills.push(new SkillEntity(-1, 'all'));
              this.skillCntr.setValue(this.allSkills[this.allSkills.length - 1]);
              this.fromTimeCntr.setValue(12);
            });
          }
        );
    }
}
