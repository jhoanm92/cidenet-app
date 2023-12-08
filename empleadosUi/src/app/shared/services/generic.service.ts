import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GenericService<T> {

  constructor(
    protected _http: HttpClient,
    @Inject(String) protected url: string
  ) { }

  getAll() {
    return this._http.get<T[]>(this.url);
  }

  getById(id: number) {
    return this._http.get<T>(`${this.url}/${id}`);
  }

  register(t: T) {
    return this._http.post<T>(this.url, t)
  }

  update(t: T) {
    return this._http.put<T>(this.url, t);
  }

  delete(id: number) {
    return this._http.delete(`${this.url}/${id}`)
  }
}
