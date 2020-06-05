import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RuleServiceService {

  private url: string;
  private findPlanUrl: string;

  constructor(
    private http: HttpClient
  ) {
    this.url = environment.restPath + '/rules';
  }

  addRule(data: File) {
      const fd = new FormData();
      fd.append('file', data);
      return this.http.post(this.url, fd);
  }
}
