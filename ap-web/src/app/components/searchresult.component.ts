import { Component,Input } from '@angular/core';
import { Airport } from '../domains/airport';
import { AirportService }  from '../providers/airport.service';
import { Country } from '../domains/country';
import { Region } from '../domains/region';

@Component({
  selector: 'search-result',
  templateUrl: '../views/searchresult.view.html',
  styleUrls: ['../styles/searchresult.style.css'],
  inputs: ['country', 'region'],
  providers: [AirportService]

})
export class SearchResultComponent {
    airports: Airport[];
    country: Country;
    region: Region;
    constructor(private airportService: AirportService) { 
      console.log("SearchResultComponent:"+this.country+":"+this.region);
      this.country = null;
      this.region = null;
    }

    ngOnInit(): void {
     this.getAirports();
    }

    getAirports(): void {
      this.airportService.getAirports(this.country,this.region).then(airports => this.airports = airports);
    }

    




}