import { Component, OnInit } from '@angular/core';
import { TrainingEntity } from 'src/app/models/training-model/training.model';
import { TrainingService } from 'src/app/services/training-service/training.service';

@Component({
  selector: 'app-list-training',
  templateUrl: './list-training.component.html',
  styleUrls: ['./list-training.component.scss']
})
export class ListTrainingComponent implements OnInit {

  trainings: TrainingEntity[];

  constructor(
    private trainingService: TrainingService
  ) { }

  ngOnInit() {
    this.trainingService.getAll().subscribe(
      (data: any) => {
        this.trainings = data as TrainingEntity[];
        console.log(this.trainings);
      }
    );
  }

}
