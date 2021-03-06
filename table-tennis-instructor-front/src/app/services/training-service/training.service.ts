import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../auth-service/auth.service';
import { environment } from 'src/environments/environment';
import { TrainingSearchEntity } from 'src/app/models/training-search-model/training-search.model';
import { TrainingEntity } from 'src/app/models/training-model/training.model';
import { SimulateTrainingEntity } from 'src/app/models/training-simulate-requst-model/training-simulate-request.model';
import { TrainingHistorySearchEntity } from 'src/app/models/training-history-search-model/training.history.search.model';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  private url: string;
  private findPlanUrl: string;
  private monitorTrainingUrl: string;
  private trainigReportsUrl: string;

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {
    this.url = environment.restPath + '/training';
    this.findPlanUrl = environment.restPath + '/trainingChoose';
    this.monitorTrainingUrl = environment.restPath + '/trainingMonitor';
    this.trainigReportsUrl = environment.restPath + '/trainingReports';
  }

  getAll() {
    return this.http.get(this.url + '/getAll');
  }

  getTrainingDetails(id: string) {
    return this.http.get(this.url + '/getDetails/' + id);
  }

  getTrainingHistotyByUserId(data: TrainingHistorySearchEntity) {
    return this.http.post(this.trainigReportsUrl + '/getTrainingHistory', data);
  }

  findTrainingPlan(userData: TrainingSearchEntity) {
    return this.http.post(this.findPlanUrl + '/find', userData);
  }

  simulateTraining(data: SimulateTrainingEntity) {
    return this.http.post(this.monitorTrainingUrl + '/trainingSimulation', data);
  }

  uploadTrainingData(trainingId: number, trainingData: File) {
    const fd = new FormData();
    fd.append('file', trainingData);
    return this.http.post(this.monitorTrainingUrl + '/processTrainingData/' + trainingId,
      fd
    );
  }

  add(training: TrainingEntity) {
    return this.http.post(this.url, training);
  }

  delete(id: number) {
    return this.http.delete(this.url + '/' + id);
  }


}
