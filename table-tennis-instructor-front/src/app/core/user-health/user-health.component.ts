import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user-service/user.service';
import { User } from 'src/app/models/user-model/user.model';
import { UserHealthService } from 'src/app/services/user-health/user-health.service';
import { FormControl, Validators, FormGroup, FormBuilder } from '@angular/forms';
import { UserHealthEntity } from 'src/app/models/user-health-model/user-health.model';
import { HttpErrorResponse } from '@angular/common/http';
import { stat } from 'fs';

@Component({
  selector: 'app-user-health',
  templateUrl: './user-health.component.html',
  styleUrls: ['./user-health.component.scss']
})
export class UserHealthComponent implements OnInit {

  private userHealth: UserHealthEntity;
  private userHealthForm: FormGroup;
  private heartbeatCntr: FormControl;
  private systolicCntr: FormControl;
  private diastolicCntr: FormControl;
  private submitted = false;
  firstTime = false;

  constructor(
    private userService: UserService,
    private userHealthService: UserHealthService,
    private formBuilder: FormBuilder) {

      this.heartbeatCntr = new FormControl({ value: '', disabled: false},
        [Validators.required, Validators.min(40), Validators.max(200)] );
      this.systolicCntr = new FormControl({ value: '', disabled: false},
        [Validators.required, Validators.min(40), Validators.max(200)]);
      this.diastolicCntr = new FormControl({ value: '', disabled: false},
        [Validators.required, Validators.min(40), Validators.max(200)] );

      this.userHealthForm = this.formBuilder.group({
        heartbeat: this.heartbeatCntr,
        systolic: this.systolicCntr,
        diastolic: this.diastolicCntr,
      });
    }

  ngOnInit() {
    const me: User = this.userService.getUserFromLocalStorage();
    this.userHealthService.findUserHealthById(me.id).subscribe(uh => {
      this.firstTime = false;
      this.userHealth = uh as UserHealthEntity;
      this.heartbeatCntr.setValue(this.userHealth.heartbeat);
      this.systolicCntr.setValue(this.userHealth.systolic);
      this.diastolicCntr.setValue(this.userHealth.diastolic);
    },
    (err: HttpErrorResponse) => {
      this.firstTime = true;
      this.userHealth = new UserHealthEntity();
    });
  }

  onSubmit(userHealthForm: any) {
    this.submitted = true;
    if (userHealthForm.status === 'VALID') {
      this.userHealth.heartbeat = this.heartbeatCntr.value;
      this.userHealth.systolic = this.systolicCntr.value;
      this.userHealth.diastolic = this.diastolicCntr.value;

      if (this.firstTime) {
        this.userHealthService.addUserHealth(this.userHealth).subscribe(status => {
          console.log(status);
        });
      } else {
        this.userHealthService.updateUserHealth(this.userHealth).subscribe(status => {
          console.log(status);
        });
      }
    }
  }

}
