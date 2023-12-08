import { PageResponse } from './../model/page-response';
import { Pageable } from './../model/pageable';
import { HttpClient, HttpParams } from '@angular/common/http';
import { GenericService } from './../../shared/services/generic.service';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { environment } from 'src/environments/environment';
import { Observable, Subject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService extends GenericService<Employee> {

  private listaCambio: Subject<boolean> = new Subject<boolean>();

  constructor(protected override _http: HttpClient) {
    super(
      _http,
      `${environment.HOST}/employees`
    )
  }

  public getPageAll(pageable: Pageable): Observable<PageResponse<Employee>> {
    let params = new HttpParams()
    .set('page', pageable.page)
    .set('size', pageable.size)
    .set('sort', pageable.sort);
    let url = `${environment.HOST}/employees/page?${params}`

    return this._http.get<PageResponse<Employee>>(url);
  }

  getListaCambio() {
    return this.listaCambio.asObservable();
  }

  setListaCambio() {
    this.listaCambio.next(true);
  }
}
