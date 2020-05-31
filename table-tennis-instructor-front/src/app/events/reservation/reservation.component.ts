import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../../services/event-service/event.service';
import { EventEntity } from 'src/app/models/event-model/event.model';
import { HttpErrorResponse } from '@angular/common/http';
import { TicketService } from 'src/app/services/ticket-service/ticket.service';
import { Ticket } from 'src/app/models/ticket-model/ticket.model';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {

  event: EventEntity = new EventEntity();
  hall: any = {};
  hallChoosen = false;
  sector: any = {};
  sectorChoosen = false;
  tickets: any = [];

  constructor(
    private route: ActivatedRoute,
    private eventService: EventService,
    private ticketService: TicketService) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.eventService.getEvent(id).subscribe(
        (data: EventEntity) => {
          this.event = data;
        }
        , (error: HttpErrorResponse) => {
        },
        () => {
          console.log(this.event);
        }
      );
    }
  }

  chooseHall(hallId: number) {
    if (hallId !== -1) {
      this.hallChoosen = true;
      this.hall = this.event.halls.find(h => h.id === hallId);
    } else {
      this.hallChoosen = false;
      this.hall = {};
    }
  }

  // treba da se proveri sta je zauzeto u sektoru..
  chooseSector(sectorId: number) {
    if (sectorId !== -1) {
      this.sectorChoosen = true;
      this.sector = this.hall.sectors.find(s => s.id === sectorId);
    } else {
      this.sectorChoosen = false;
      this.sector = {};
    }
  }

  // ticket vec postoji da li postoji nacin da ih dobavim 
  reserveTicket(ticket: Ticket) {
    this.ticketService.makeReservation(ticket);


  }

  buyTicket() {}


}
