import { Country } from './../model/country';
import { GenericService } from './../../shared/services/generic.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CountryService extends GenericService<Country> {

  constructor(protected override _http: HttpClient) {
    super(
      _http,
      `${environment.HOST}/countries`
    )
   }
}
