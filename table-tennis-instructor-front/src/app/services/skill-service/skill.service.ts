import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private url: string;

  constructor(
    private http: HttpClient,
  ) {
    this.url = environment.restPath + '/skill';
  }

  getAll() {
    return this.http.get(this.url + '/getAll');
  }
}
