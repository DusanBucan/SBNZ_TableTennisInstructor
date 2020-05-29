import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient
  ) { }

  login(auth: any): Observable<any> {
    return this.http.post(environment.restPath + '/auth/login', { username: auth.username, password: auth.password },
      { headers: this.headers, responseType: 'json' });
  }

  isLoggedIn(): boolean {
    if (!localStorage.getItem('token')) {
      return false;
    }
    return true;
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getUser() {
    return localStorage.getItem('user');
  }

  getUserRole() {
    const user = this.getUser();
    if (!user) {
      return 'GUEST';
    }
    const auth = JSON.parse(user).authorities;
    return auth[0];
  }
}
