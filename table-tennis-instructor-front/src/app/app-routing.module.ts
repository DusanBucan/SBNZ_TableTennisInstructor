import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './core/login/login.component';
import { RegisterComponent } from './core/register/register.component';
import { ProfileComponent } from './core/profile/profile.component';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { ListTrainingComponent } from './trainings/list-training/list-training.component';
import { TrainingDetailsComponent } from './trainings/training-details/training-details.component';
import { FindTrainingComponent } from './trainings/find-training/find-training.component';
import { UserHealthComponent } from './core/user-health/user-health.component';
import { TrainingHistoryComponent } from './trainings/training-history/training-history.component';
import { SkillListComponent } from './skills/skill-list/skill-list.component';
import { SkillAddComponent } from './skills/skill-add/skill-add.component';
import { TrainingAddComponent } from './trainings/training-add/training-add.component';
import { AddRuleComponent } from './rules/add-rule/add-rule.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent, canActivate: [LoginGuard] },
  { path: 'register', component: RegisterComponent, canActivate: [LoginGuard] },
  { path: 'profile', component: ProfileComponent, canActivate: [RoleGuard], data: {expectedRoles: 'ROLE_ADMIN|ROLE_REGULAR'}},
  { path: 'training', component: ListTrainingComponent },
  { path: 'newTraining', component: TrainingAddComponent, canActivate: [RoleGuard], data: {expectedRoles: 'ROLE_ADMIN|'}},
  { path: 'skills', component: SkillListComponent},
  { path: 'newSkill', component: SkillAddComponent, canActivate: [RoleGuard], data: {expectedRoles: 'ROLE_ADMIN|'}},
  { path: 'newRule', component: AddRuleComponent, canActivate: [RoleGuard], data: {expectedRoles: 'ROLE_ADMIN|'}},
  { path: 'training/:id', component: TrainingDetailsComponent },
  { path: 'findTrainig', component: FindTrainingComponent, canActivate: [RoleGuard], data: {expectedRoles: 'ROLE_ADMIN|ROLE_REGULAR'}},
  { path: 'userHealth', component: UserHealthComponent, canActivate: [RoleGuard], data: {expectedRoles: 'ROLE_ADMIN|ROLE_REGULAR'}},
  { path: 'trainingHistory', component: TrainingHistoryComponent,
        canActivate: [RoleGuard], data: {expectedRoles: 'ROLE_ADMIN|ROLE_REGULAR'}},
  { path: '**', redirectTo: 'training'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppRoutingModule { }
