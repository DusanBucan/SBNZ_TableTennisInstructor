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
import { AddEventComponent } from './core/add-event/add-event.component';

import { UserService } from './services/user-service/user.service';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { AuthService } from './services/auth-service/auth.service';
import { TicketService } from './services/ticket-service/ticket.service';
import { EventService } from './services/event-service/event.service';
import { HallService } from './services/hall-service/hall.service';
import { PlaceService } from './services/place-service/place.service';
import { DateFormatPipe } from './pipes/date-format.pipe';
import { ReservationComponent } from './events/reservation/reservation.component';
import { ListTrainingComponent } from './trainings/list-training/list-training.component';
import { TrainingService } from './services/training-service/training.service';



import { TrainingListItemComponent } from './trainings/training-list-item/training-list-item.component';
import { TrainingDetailsComponent } from './trainings/training-details/training-details.component';
import { FindTrainingComponent } from './trainings/find-training/find-training.component';
import { TokenInterceptor } from './interceptors/token.interceptor';
import { SkillService } from './services/skill-service/skill.service';
import { UserHealthComponent } from './core/user-health/user-health.component';
import { UserHealthService } from './services/user-health/user-health.service';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    AddEventComponent,
    DateFormatPipe,
    ReservationComponent,
    ListTrainingComponent,
    TrainingListItemComponent,
    TrainingDetailsComponent,
    FindTrainingComponent,
    UserHealthComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
  ],
  providers: [
    UserService,
    EventService,
    AuthService,
    TicketService,
    EventService,
    HallService,
    PlaceService,
    LoginGuard,
    RoleGuard,
    TrainingService,
    SkillService,
    UserHealthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
