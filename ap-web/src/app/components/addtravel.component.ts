import { Component, OnInit } from '@angular/core';
import { Country } from '../domains/country';
import { CountryService }  from '../providers/country.service';

@Component({
  selector: 'fs-app',
  templateUrl: '../views/addtravel.view.html',
  styleUrls: ['../styles/addtravel.style.css'],
  providers: [CountryService]
})
export class AddTravelComponent implements OnInit {

  title = 'Travel Companion';
  countries: Country[];
  sourceCountry: {};
  destinationCountry: {};
  constructor(private countryService: CountryService) { }
  getCountries(): void {
    this.countryService.getCountriesMock().then(countries => this.countries = countries);
  }
  ngOnInit(): void {
    this.getCountries();
  }
  /*onSelect(country: Country): void {
    this.sourceCountry = country;
  }*/
}
