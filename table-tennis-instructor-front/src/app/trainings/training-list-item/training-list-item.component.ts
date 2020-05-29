import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { TrainingEntity } from 'src/app/models/training-model/training.model';

@Component({
  selector: 'app-training-list-item',
  templateUrl: './training-list-item.component.html',
  styleUrls: ['./training-list-item.component.scss']
})
export class TrainingListItemComponent implements OnInit {

  @Input() training: TrainingEntity;

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  showDetails() {
    this.router.navigate(['/training/' + this.training.id]);
  }

}
