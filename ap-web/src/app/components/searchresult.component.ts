import { Component } from '@angular/core';
import { Airport } from '../domains/airport';
import { AirportService }  from '../providers/airport.service';

@Component({
  selector: 'search-result',
  templateUrl: '../views/search.view.html',
  styleUrls: ['../styles/search.style.css'],
  providers: [AirportService]

})
export class SearchComponent {
}