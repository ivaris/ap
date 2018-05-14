import { Injectable } from '@angular/core';
import { Region } from '../domains/region';
import { Country } from '../domains/country';
import { REGIONS } from '../mocks/regions.mock';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class RegionService {
  constructor(private http: Http) { }
  getRegions(): Promise<Region[]> {
   return this.http.get("http://localhost:8080/ap-service/api/region/all")
                  .toPromise()
                  .then(response => response.json() as Region[])
                  .catch(this.handleError);
  }

  getRegionsByCountry(country:Country): Promise<Region[]> {
    return this.http.get("http://localhost:8080/ap-service/api/region/country/"+country.code)
                   .toPromise()
                   .then(response => response.json() as Region[])
                   .catch(this.handleError);
   }

  getRegionsMock(): Promise<Region[]> {
      return Promise.resolve(REGIONS);
    }

   private handleError(error: any): Promise<any> {
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
    }
}
