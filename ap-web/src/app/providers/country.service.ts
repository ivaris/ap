import { Injectable } from '@angular/core';
import { Country } from '../domains/country';
import { COUNTRIES } from '../mocks/countries.mock';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class CountryService {
  constructor(private http: Http) { }
  getCountries(): Promise<Country[]> {
   return this.http.get("http://localhost:8080/ap-service/api/country/all")
                  .toPromise()
                  .then(response => response.json() as Country[])
                  .catch(this.handleError);
  }

  getCountriesMock(): Promise<Country[]> {
      return Promise.resolve(COUNTRIES);
    }

   private handleError(error: any): Promise<any> {
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
    }
}
