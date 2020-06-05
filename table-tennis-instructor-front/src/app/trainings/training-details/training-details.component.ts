import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { TrainingEntity } from 'src/app/models/training-model/training.model';
import { HttpErrorResponse } from '@angular/common/http';
import { TrainingDrillEntity } from '../../models/training-model/training-drill.model';
import { TrainingMistakeEntity } from '../../models/training-model/training-mistake.model';

@Component({
  selector: 'app-training-details',
  templateUrl: './training-details.component.html',
  styleUrls: ['./training-details.component.scss']
})
export class TrainingDetailsComponent implements OnInit {

  training: TrainingEntity;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private trainingService: TrainingService,
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.trainingService.getTrainingDetails(id).subscribe(
        (data: TrainingEntity) => {
          this.training = data;
          console.log(this.training);
        }
        , (error: HttpErrorResponse) => {
          console.error(error.message);
        }
      );
      }
    }

  startTraining() {
    console.log('begin simulation');
  }


}
