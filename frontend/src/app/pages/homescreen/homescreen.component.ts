import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Meeting } from 'src/app/model/meeting';
import { ReservationApiService } from 'src/app/services/reservation-api.service';

@Component({
  selector: 'app-homescreen',
  templateUrl: './homescreen.component.html',
  styleUrls: ['./homescreen.component.css'],
})
export class HomescreenComponent implements OnInit {
  meeting: Meeting = new Meeting();

  meetingTypes: any[] = [];

  reserveRoomForm = new FormGroup({
    startHour: new FormControl(8),
    endHour: new FormControl(9),
    meetingDate: new FormControl(),
    collaboratorsNumber: new FormControl(),
    meetingTypeId: new FormControl(),
  });

  constructor(private reservationApiService: ReservationApiService) {}

  ngOnInit(): void {
    this.fetchMeetingTypes();

    this.reserveRoomForm
      .get('startHour')
      ?.valueChanges.subscribe((startHour: any) => {
        this.reserveRoomForm.get('endHour')?.setValue(startHour + 1);
      });
  }

  fetchMeetingTypes() {
    this.reservationApiService.getMeetingTypes().subscribe((data: any) => {
      this.meetingTypes = data;
    });
  }

  submitReservation(): void {
    var formValues = this.reserveRoomForm.value;
    if (
      !formValues.startHour ||
      !formValues.endHour ||
      !formValues.meetingDate ||
      !formValues.meetingTypeId ||
      !formValues.collaboratorsNumber
    ) {
      alert('veuillez remplir tout les champs');
    } else {
      const formattedDate = formValues.meetingDate.toLocaleDateString({
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
      });

      this.meeting.startHour = formValues.startHour ?? undefined;
      this.meeting.endHour = formValues.endHour ?? undefined;
      this.meeting.meetingDate = formattedDate;
      this.meeting.collaboratorsNumber =
        formValues.collaboratorsNumber ?? undefined;
      this.meeting.meetingTypeId = formValues.meetingTypeId ?? undefined;

      this.reservationApiService.reserve(this.meeting).subscribe(
        (result: any) => {
          alert('Salle ' + result.name + '  a  été reservée avec succes');
        },
        (err) => {
          alert(err.error);
        }
      );
    }
  }
}
