import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Meeting } from '../model/meeting';

@Injectable({
  providedIn: 'root',
})
export class ReservationApiService {
  constructor(private http: HttpClient) {}

  getMeetingTypes(): Observable<any> {
    return this.http.get(`api/v1/meetingType`);
  }

  reserve(meeting: Meeting): Observable<any> {
    return this.http.post(`api/v1/reservation`, meeting);
  }

  getRooms(): Observable<any> {
    return this.http.get(`api/v1/reservation`);
  }
}
