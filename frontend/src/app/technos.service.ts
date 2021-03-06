import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

// Generated by https://quicktype.io

export interface TechnoLight {
  id:          string;
  name:        string;
}

export interface Techno extends TechnoLight {
  version:     string;
  createdDate: string;
}

export class Techno {
  public id:          string;
  public name:        string;
  public version:     string;
  public createdDate: string;
}


@Injectable()
export class TechnosService {

  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public getTechnos(): Observable<Array<TechnoLight>> {
    return this.httpClient.get<Array<TechnoLight>>('/api/technos');

  }

  public getTechno(id: string): Observable<Techno> {
    return this.httpClient.get<Techno>(`/api/technos/${id}`);

  }

}
