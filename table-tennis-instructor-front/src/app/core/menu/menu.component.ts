import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { NavigationEnd, Router, Event} from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  role: string;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationEnd) {
        this.role = this.authService.getUserRole();
      }
    });
  }

  ngOnInit() {
  }

  toTrainings() {
    this.router.navigateByUrl('/training');
  }
  toSkills() {
    this.router.navigateByUrl('/skills');
  }
  newSkill() {
    this.router.navigateByUrl('/newSkill');
  }
  newTraining() {
    this.router.navigateByUrl('/newTraining');
  }
  newRule() {
    this.router.navigateByUrl('/newRule');
  }
  myHistory() {
    this.router.navigateByUrl('/trainingHistory');
  }
  findTraining() {
    this.router.navigateByUrl('/findTrainig');
  }

}
