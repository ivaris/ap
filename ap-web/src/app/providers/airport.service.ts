import { Injectable } from '@angular/core';
import { Airport } from '../domains/airport';
import { AIRPORTS } from '../mocks/airports.mock';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class AirportService {
  constructor(private http: Http) { }
  getAirports(): Promise<Airport[]> {
   return this.http.get("http://localhost:8080/ap-service/api/airport/all")
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
