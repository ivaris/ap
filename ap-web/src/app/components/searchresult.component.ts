import { Component } from '@angular/core';
import { Airport } from '../domains/airport';
import { AirportService }  from '../providers/airport.service';

@Component({
  selector: 'search-result',
  templateUrl: '../views/searchresult.view.html',
  styleUrls: ['../styles/searchresult.style.css'],
  providers: [AirportService]

})
export class SearchResultComponent {
}