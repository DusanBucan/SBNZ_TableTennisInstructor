import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../auth-service/auth.service';
import { environment } from 'src/environments/environment';
import { TrainingSearchEntity } from 'src/app/models/training-search-model/training-search.model';
import { TrainingEntity } from 'src/app/models/training-model/training.model';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  private url: string;
  private findPlanUrl: string;

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {
    this.url = environment.restPath + '/training';
    this.findPlanUrl = environment.restPath + '/trainingChoose';
  }

  getAll() {
    return this.http.get(this.url + '/getAll');
  }

  getTrainingDetails(id: string) {
    return this.http.get(this.url + '/getDetails/' + id);
  }

  getTrainingHistotyByUserId(id: number) {
    return this.http.get(this.url + '/getTrainingHistory/' + id);
  }

  findTrainingPlan(userData: TrainingSearchEntity) {
    return this.http.post(this.findPlanUrl + '/find', userData);
  }

  add(training: TrainingEntity) {
    return this.http.post(this.url, training);
  }

  delete(id: number) {
    return this.http.delete(this.url + '/' + id);
  }


}
