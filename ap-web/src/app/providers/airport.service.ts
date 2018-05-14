import { Injectable } from '@angular/core';
import { Airport } from '../domains/airport';
import { Country } from '../domains/country';
import { Region } from '../domains/region';
import { AIRPORTS } from '../mocks/airports.mock';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { NULL_INJECTOR } from '@angular/core/src/render3/component';

@Injectable()
export class AirportService {
  constructor(private http: Http) { }
  getAllAirports(): Promise<Airport[]> {
   return this.http.get("http://localhost:8080/ap-service/api/airport/all")
                  .toPromise()
                  .then(response => response.json() as Airport[])
                  .catch(this.handleError);
  }

  getAirports(country : Country, region: Region): Promise<Airport[]> {
    if(country==null && region==null){
      return this.getAllAirports();
    }
    if(country!=null && region==null){
      return this.http.get("http://localhost:8080/ap-service/api/airport/country/"+country.code)
                   .toPromise()
                   .then(response => response.json() as Airport[])
                   .catch(this.handleError);
    }
    return this.http.get("http://localhost:8080/ap-service/api/airport/country/"+country.code+"/region/"+region.code)
                   .toPromise()
                   .then(response => response.json() as Airport[])
                   .catch(this.handleError);
   }

  getAirportsMock(): Promise<Airport[]> {
      return Promise.resolve(AIRPORTS);
    }

   private handleError(error: any): Promise<any> {
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
    }
}
