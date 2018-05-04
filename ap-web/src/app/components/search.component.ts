import { Component } from '@angular/core';
import { Country } from '../domains/country';
import { CountryService }  from '../providers/country.service';

@Component({
  selector: 'search',
  templateUrl: '../views/search.component.html',
  styleUrls: ['../styles/search.component.css']
  providers: [CountryService]
})
export class SearchComponent {
  title = 'Search Airports';
  region = {};
  country = {};
  countries: Country[];
  sourceCountry: {};
  destinationCountry: {};
  constructor(private countryService: CountryService) { }

  getCountries(): void {
    this.countryService.getCountries().then(countries => this.countries = countries);
  }
  ngOnInit(): void {
    this.getCountries();

  }
  /*onSelect(country: Country): void {
    this.sourceCountry = country;
  }*/
  onClickSearch(value:string){
    console.log("search click value:"+value+":"+this.country);
    if(value=='country'){

    }else if(value=='region'){

    }else{
      console.log("comming soon...");
    }
  }
}
