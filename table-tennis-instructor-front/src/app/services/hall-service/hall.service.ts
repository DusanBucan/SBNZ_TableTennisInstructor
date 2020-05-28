import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';

const authHttpOptions = (token) => {
  return {
    headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Authorization': 'Bearer ' + token
   })
  }
}

@Injectable({
  providedIn: 'root'
})
export class HallService {

  private url: string;
  private places;

  constructor(
    private http: HttpClient,
    private router: Router
  ) { 
    this.url = 'http://localhost:8080/api';
  }

  public getHalls(placeID) {
    return this.http.get(this.url + "/placeHalls/" + placeID, authHttpOptions(localStorage.getItem("token")))
    .pipe(map(
      res => {
        return res;
      }
    ))
  }
}