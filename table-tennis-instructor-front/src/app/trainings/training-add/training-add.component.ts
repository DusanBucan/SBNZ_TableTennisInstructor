import { Component, OnInit, Inject } from '@angular/core';
import { TrainingEntity } from 'src/app/models/training-model/training.model';
import { TrainingLevelType } from 'src/app/models/training-model/training-level.enum';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';
import { SkillService } from 'src/app/services/skill-service/skill.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TrainingDrillEntity } from 'src/app/models/training-model/training-drill.model';
import { TrainingMistakeEntity } from 'src/app/models/training-model/training-mistake.model';


@Component({
  selector: 'app-training-add',
  templateUrl: './training-add.component.html',
  styleUrls: ['./training-add.component.scss']
})
export class TrainingAddComponent implements OnInit {

  newTraining: TrainingEntity;
  trainingLevels: TrainingLevelType[];
  allSkills: SkillEntity[];

  trainingDrills: TrainingDrillEntity[];
  trainingMistakes: TrainingMistakeEntity[];

  addTrainingForm: FormGroup;
  skillCntr: FormControl;
  trainingLevelCntr: FormControl;
  timeToExecuteCntr: FormControl;
  submitted = false;

  constructor(private trainingService: TrainingService,
              private skillService: SkillService,
              public dialog: MatDialog,
              private formBuilder: FormBuilder) {
    this.timeToExecuteCntr = new FormControl({ value: '', disabled: false},
        [Validators.required, Validators.min(0)]);
    this.skillCntr = new FormControl({ value: '', disabled: false}, [Validators.required]);
    this.trainingLevelCntr = new FormControl({ value: '', disabled: false}, [Validators.required]);

    this.addTrainingForm = this.formBuilder.group({
      skill: this.skillCntr,
      trainingLevel: this.trainingLevelCntr,
      skillLevel : this.trainingLevelCntr,
      timeToExecute : this.timeToExecuteCntr
    });
  }

  ngOnInit() {
    this.trainingDrills = [];
    this.trainingMistakes = [];

    this.trainingLevels = [];
    this.trainingLevels.push(TrainingLevelType.BEGINER);
    this.trainingLevels.push(TrainingLevelType.INTERMEDIATE);
    this.trainingLevels.push(TrainingLevelType.ADVANCED);
    this.skillService.getAll().subscribe(res => {
      this.allSkills = res as SkillEntity[];
    });
  }

  onSubmit(skillForm: any) {
    this.submitted = true;

    console.log(this.trainingMistakes);
    console.log(this.trainingDrills);

    if (skillForm.status === 'VALID') {
      this.newTraining = new TrainingEntity(null,
         this.skillCntr.value, this.trainingLevelCntr.value,
        this.timeToExecuteCntr.value, this.trainingDrills, this.trainingMistakes);

      this.trainingService.add(this.newTraining).subscribe( () => {
        console.log('uspesno dodato');
      },
        (err: HttpErrorResponse) => {
          console.log(err.message);
      });
    }
  }


  // Methods and class for Modal dialogs below

  showModalTrainingDrill(): void {
    const dialogRef = this.dialog.open(TrainingDrillDialog, {
      width: '250px',
      data: new TrainingDrillEntity()
    });

    dialogRef.afterClosed().subscribe(result => {
      const params = result as TrainingDrillEntity;
      const drill = new TrainingDrillEntity(null, params.description, params.repetitons );
      if (drill && drill.description !== '' && drill.repetitons !== '') {
        this.trainingDrills.push(drill);
      }
    });
  }


  showModalTrainingMistake() {
    const dialogRef = this.dialog.open(TrainingMistakeDialog, {
      width: '250px',
      data: new TrainingMistakeEntity()
    });

    dialogRef.afterClosed().subscribe(result => {
      const params = result as TrainingMistakeEntity;
      const mistake = new TrainingMistakeEntity(null, params.description, params.solution);
      if (mistake && mistake.description !== '' && mistake.solution !== '') {
        this.trainingMistakes.push(mistake);
      }
    });

  }

  removeDrill(drill: TrainingDrillEntity) {
    const indx = this.trainingDrills.findIndex(d => {
       return d.description === drill.description &&
              d.repetitons === drill.repetitons;
      });
    this.trainingDrills.splice(indx, 1);
  }

  removeMistake(drill: TrainingMistakeEntity) {
    const indx = this.trainingMistakes.findIndex(d => {
       return d.description === drill.description &&
              d.solution === drill.solution;
      });
    this.trainingMistakes.splice(indx, 1);
  }

}

@Component({
  selector: 'training-drill-dialog',
  templateUrl: './training-add-drill.modal.html',
})
// tslint:disable-next-line: component-class-suffix
export class TrainingDrillDialog {

  constructor(
    public dialogRef: MatDialogRef<TrainingDrillDialog>,
    @Inject(MAT_DIALOG_DATA) public data: TrainingDrillEntity) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}

@Component({
  selector: 'training-mistake-dialog',
  templateUrl: './training-add-mistake.modal.html',
})
// tslint:disable-next-line: component-class-suffix
export class TrainingMistakeDialog {

  constructor(
    public dialogRef: MatDialogRef<TrainingMistakeDialog>,
    @Inject(MAT_DIALOG_DATA) public data: TrainingMistakeEntity) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
