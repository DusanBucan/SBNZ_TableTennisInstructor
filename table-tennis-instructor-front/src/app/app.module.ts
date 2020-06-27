import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';

import { HeaderComponent } from './core/header/header.component';
import { MenuComponent } from './core/menu/menu.component';
import { LoginComponent } from './core/login/login.component';
import { RegisterComponent } from './core/register/register.component';
import { ProfileComponent } from './core/profile/profile.component';

import { UserService } from './services/user-service/user.service';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { AuthService } from './services/auth-service/auth.service';
import { DateFormatPipe } from './pipes/date-format.pipe';
import { ListTrainingComponent } from './trainings/list-training/list-training.component';
import { TrainingService } from './services/training-service/training.service';



import { TrainingDetailsComponent } from './trainings/training-details/training-details.component';
import { FindTrainingComponent } from './trainings/find-training/find-training.component';
import { TokenInterceptor } from './interceptors/token.interceptor';
import { SkillService } from './services/skill-service/skill.service';
import { UserHealthComponent } from './core/user-health/user-health.component';
import { UserHealthService } from './services/user-health/user-health.service';
import { TrainingHistoryComponent } from './trainings/training-history/training-history.component';
import { SkillListComponent } from './skills/skill-list/skill-list.component';
import { SkillAddComponent } from './skills/skill-add/skill-add.component';
import { TrainingAddComponent, TrainingDrillDialog, TrainingMistakeDialog } from './trainings/training-add/training-add.component';
import { MatDialogModule, MatListModule } from '@angular/material';
import { AddRuleComponent } from './rules/add-rule/add-rule.component';
import { RuleServiceService } from './services/rules-service/rule-service.service';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    DateFormatPipe,
    ListTrainingComponent,
    TrainingDetailsComponent,
    FindTrainingComponent,
    UserHealthComponent,
    TrainingHistoryComponent,
    SkillListComponent,
    SkillAddComponent,
    TrainingAddComponent,
    TrainingDrillDialog,
    TrainingMistakeDialog,
    AddRuleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    MatDialogModule,
    MatListModule
  ],
  providers: [
    UserService,
    AuthService,
    LoginGuard,
    RoleGuard,
    TrainingService,
    SkillService,
    UserHealthService,
    RuleServiceService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  entryComponents: [
    TrainingDrillDialog,
    TrainingMistakeDialog
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
