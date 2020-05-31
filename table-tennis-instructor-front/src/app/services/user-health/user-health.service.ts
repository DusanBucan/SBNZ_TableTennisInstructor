import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { UserHealthEntity } from 'src/app/models/user-health-model/user-health.model';

@Injectable({
  providedIn: 'root'
})
export class UserHealthService {

  private userHealhtPath: string;

  constructor(
    private http: HttpClient,
  ) {
    this.userHealhtPath = environment.restPath + '/userHealth';
  }

  findUserHealthById(id: number) {
    return this.http.get(this.userHealhtPath + '/' + id);
  }

  updateUserHealth(uh: UserHealthEntity) {
    return this.http.put(this.userHealhtPath, uh);
  }

}
