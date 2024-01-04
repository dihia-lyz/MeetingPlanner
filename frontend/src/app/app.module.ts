import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomescreenComponent } from './pages/homescreen/homescreen.component';
import { HttpClientModule } from '@angular/common/http';
import { ReservationApiService } from './services/reservation-api.service';
import { ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_DATE_FORMATS, MatNativeDateModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RoomsComponent } from './pages/rooms/rooms.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomescreenComponent,
    RoomsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
  ],

  providers: [ReservationApiService],
  bootstrap: [AppComponent],
})
export class AppModule {}
