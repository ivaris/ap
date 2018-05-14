import { Component,Input,OnChanges } from '@angular/core';
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
export class SearchResultComponent implements OnChanges{
    airports: Airport[];
    @Input()
    country: Country;
    @Input()
    region: Region;
    constructor(private airportService: AirportService) { 
      console.log("SearchResultComponent:"+this.country+":"+this.region);
      this.country = null;
      this.region = null;
    }

    ngOnChanges(): void {
      console.log("SearchResultComponent:"+this.country+":"+this.region);
     this.getAirports();
    }

    getAirports(): void {
      this.airportService.getAirports(this.country,this.region).then(airports => this.airports = airports);
    }

    




}