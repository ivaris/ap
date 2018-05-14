import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RoutingModule }     from './routing.module';
import { HttpModule }    from '@angular/http'

import { MainComponent } from './components/main.component';
import { SearchComponent} from './components/search.component';
import { SearchResultComponent} from './components/searchresult.component';
import { CountryService }  from './providers/country.service';
import { RegionService }  from './providers/region.service';
import { AirportService } from './providers/airport.service';

@NgModule({
  declarations: [
    MainComponent,
    SearchComponent,
    SearchResultComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RoutingModule
  ],
  providers: [
  CountryService,
  RegionService,
  AirportService
  ],
  bootstrap: [MainComponent]
})
export class AppModule { }
