import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { UserService } from 'src/app/services/user-service/user.service';
import {TrainingHistoryEntity} from 'src/app/models/training-history-model/training-history.model';
import { HttpErrorResponse } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material';
import { TrainingHistorySearchEntity } from 'src/app/models/training-history-search-model/training.history.search.model';
import { TrainingMarkType } from 'src/app/models/training-history-model/training.mark.enum';

@Component({
  selector: 'app-training-history',
  templateUrl: './training-history.component.html',
  styleUrls: ['./training-history.component.scss']
})
export class TrainingHistoryComponent implements OnInit {

  trainingHistory: TrainingHistoryEntity[];
  displayedColumns: string[] = ['id', 'skill', 'skillLvl', 'trainingLvl', 'trainingMark', 'date'];
  dataSource;

  trainingSearchParams: TrainingHistorySearchEntity;

  constructor(
    private trainingService: TrainingService,
    private userService: UserService
  ) {
    this.dataSource = null;
   }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
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
          }
        );
    }
}
