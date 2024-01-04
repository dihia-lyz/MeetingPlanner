import { Component, OnInit } from '@angular/core';
import { ReservationApiService } from 'src/app/services/reservation-api.service';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css'],
})
export class RoomsComponent implements OnInit {
  rooms: any[] = [];

  constructor(private reservationApiService: ReservationApiService) {}

  ngOnInit(): void {
    this.reservationApiService.getRooms().subscribe((result) => {
      this.rooms = result;
    });
  }
}
