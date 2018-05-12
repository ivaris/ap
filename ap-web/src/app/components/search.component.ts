import { Component } from '@angular/core';
import { Country } from '../domains/country';
import { Region } from '../domains/region';
import { CountryService }  from '../providers/country.service';
import { RegionService }  from '../providers/region.service';

@Component({
  selector: 'search',
  templateUrl: '../views/search.component.html',
  styleUrls: ['../styles/search.component.css'],
  providers: [CountryService, RegionService]

})
export class SearchComponent {
  title = 'Search Airports';
  region = null;
  regions : Region[];
  country = null;
  countries: Country[];
 
  constructor(private countryService: CountryService, private regionService: RegionService) { }

  getCountries(): void {
    this.countryService.getCountries().then(countries => this.countries = countries);
  }

  getRegions(): void {
    this.regionService.getRegions().then(regions => this.regions = regions);
  }

  getRegionsByCountry(): void {
    this.regionService.getRegionsByCountry(this.country).then(regions => this.regions = regions);
  }

  ngOnInit(): void {
    this.getCountries();
    this.getRegions();
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
