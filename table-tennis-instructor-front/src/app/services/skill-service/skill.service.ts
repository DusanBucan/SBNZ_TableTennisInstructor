import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';

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

  add(skill: SkillEntity) {
    return this.http.post(this.url, skill);
  }

  deleteSkill(id: number) {
    return this.http.delete(this.url + '/' + id);
  }
}
