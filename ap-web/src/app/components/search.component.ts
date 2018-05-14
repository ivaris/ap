import { Component } from '@angular/core';
import { Country } from '../domains/country';
import { Region } from '../domains/region';
import { CountryService }  from '../providers/country.service';
import { RegionService }  from '../providers/region.service';

@Component({
  selector: 'search',
  templateUrl: '../views/search.view.html',
  styleUrls: ['../styles/search.style.css'],
  providers: [CountryService, RegionService]

})
export class SearchComponent {
  title = 'Search';
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
    //alert(this.country);
    this.regionService.getRegionsByCountry(this.country).then(regions => this.regions = regions);
  }

  ngOnInit(): void {
    this.getCountries();
    //this.getRegions();
  }
  onSelectCountry() {
    //this.sourceCountry = country;
    console.log("country selected :"+this.country);
    this.getRegionsByCountry();
  }
  onClickSearch(){
    console.log("search clicked values[Country,Region]=["+this.country.name+","+this.region.name);
    
  }
}
