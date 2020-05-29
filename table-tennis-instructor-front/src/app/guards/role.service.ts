import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from '../services/auth-service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(
    public auth: AuthService,
    public router: Router
  ) { }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRoles: string = route.data.expectedRoles;
    const role = this.auth.getUserRole();
    const roles: string[] = expectedRoles.split('|', 2);

    if (roles.indexOf(role) === -1) {
      this.router.navigate(['/training']);
      return false;
    }
    return true;
  }
}
