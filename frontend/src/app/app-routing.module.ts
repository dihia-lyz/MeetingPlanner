import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomescreenComponent } from './pages/homescreen/homescreen.component';
import { RoomsComponent } from './pages/rooms/rooms.component';

const routes: Routes = [
  { path: '', component: HomescreenComponent },
  { path: 'salles', component: RoomsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
