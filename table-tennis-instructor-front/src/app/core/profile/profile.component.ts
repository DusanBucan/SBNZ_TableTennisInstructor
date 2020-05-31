import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user-model/user.model';
import { FormBuilder, Validators, FormControl, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/services/user-service/user.service';
import { Router } from '@angular/router';
import { UserProfile } from 'src/app/models/user-model/user-profile.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profileForm;
  submitted;
  user: User;
  skills: any[];
  nameCntr: FormControl;
  surnameCntr: FormControl;
  emailCntr: FormControl;
  usernameCntr: FormControl;
  me: User;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {

    this.nameCntr = new FormControl({ value: '', disabled: false}, Validators.required );
    this.surnameCntr = new FormControl({ value: '', disabled: false}, Validators.required );
    this.emailCntr = new FormControl({ value: '', disabled: false}, Validators.required );
    this.usernameCntr = new FormControl({ value: '', disabled: true}, Validators.required );


    this.profileForm = this.formBuilder.group({
      name: this.nameCntr,
      surname: this.surnameCntr,
      email: this.emailCntr,
      username: this.usernameCntr
    });
  }


  ngOnInit() {
    this.me = this.userService.getUserFromLocalStorage();
    this.nameCntr.setValue(this.me.name);
    this.surnameCntr.setValue(this.me.surname);
    this.usernameCntr.setValue(this.me.username);
    this.emailCntr.setValue(this.me.email);
  }

  onSubmit(profileForm) {
    this.submitted = true;
    if (profileForm.status === 'VALID') {
      this.me.email = this.emailCntr.value;
      this.me.name = this.nameCntr.value;
      this.me.surname = this.surnameCntr.value;

      const userProf: UserProfile =
         new UserProfile(this.me.id,
            this.surnameCntr.value, this.nameCntr.value,
             this.emailCntr.value, this.me.username);

      this.userService.updateUserData(userProf).subscribe(res => {
        const user: User = new User(res);
        localStorage.setItem('user', JSON.stringify(user));
      });
    }
  }

  goToUserHealth() {
    this.router.navigate(['userHealth']);
  }


}
