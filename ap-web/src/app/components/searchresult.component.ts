import { Component,Input } from '@angular/core';
import { Airport } from '../domains/airport';
import { AirportService }  from '../providers/airport.service';
import { Country } from '../domains/country';
import { Region } from '../domains/region';

@Component({
  selector: 'search-result',
  templateUrl: '../views/searchresult.view.html',
  styleUrls: ['../styles/searchresult.style.css'],
  providers: [AirportService]

})
export class SearchResultComponent {
    airports: Airport[];
    @Input() country: Country;
    @Input() region: Region;
    constructor(private airportService: AirportService) { }

}