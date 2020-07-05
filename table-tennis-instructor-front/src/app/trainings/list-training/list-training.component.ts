import { Component, OnInit } from '@angular/core';
import { TrainingEntity } from 'src/app/models/training-model/training.model';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth-service/auth.service';

@Component({
  selector: 'app-list-training',
  templateUrl: './list-training.component.html',
  styleUrls: ['./list-training.component.scss']
})
export class ListTrainingComponent implements OnInit {

  trainings: TrainingEntity[];
  displayedColumns: string[] = ['id', 'name', 'trainingLv', 'skillLvl', 'timeToExecute', 'actions'];
  dataSource;

  userRole;

  constructor(
    private trainingService: TrainingService,
    private router: Router,
    private auth: AuthService
  ) {
    this.dataSource = null;
  }

  ngOnInit() {
    this.userRole = this.auth.getUserRole();
    console.log(this.userRole);
    this.fillTable();
  }

  fillTable() {
    this.trainingService.getAll().subscribe(res => {
      this.trainings = res as TrainingEntity[];
      console.log(this.trainings);
      this.dataSource = new MatTableDataSource(
        this.trainings.map(t => {
          return {
            id : t.id,
            name: t.skill.name,
            trainingLv: t.trainingLevel,
            skillLvl: t.skill.skillLevel,
            timeToExecute : t.timeToExecute,
          };
        })
      );
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  deleteTraining(id: number) {
    this.trainingService.delete(id).subscribe(() => {
      this.fillTable();
    });
  }

  showDetails(id: number) {
    this.router.navigate(['training', id]);
  }

}
