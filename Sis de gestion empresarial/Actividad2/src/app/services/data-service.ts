import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Inicio} from "../common/interface";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private http: HttpClient = inject(HttpClient);

  getComponentesInicio(): Observable<Inicio[]>{
    return this.http.get<Inicio[]>('assets/data/inicio.json');
  }
}
