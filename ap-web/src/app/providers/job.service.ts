import { Injectable } from '@angular/core';
import { Job } from '../domains/job';
import { JOBS } from '../mocks/jobs.mock';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class JobService {
  constructor(private http: Http) { }
  getJobs(): Promise<Job[]> {
   return this.http.get("")
                  .toPromise()
                  .then(response => response.json().data as Job[])
                  .catch(this.handleError);
  }

  getJobsMock(): Promise<Job[]> {
      return Promise.resolve(JOBS);
    }

   private handleError(error: any): Promise<any> {
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
    }
}
