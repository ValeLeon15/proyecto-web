import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { Propiedad } from '../model/propiedad';

@Injectable({
  providedIn: 'root'
})
export class PropiedadService {
  constructor(
    private http: HttpClient
  ) { }
  
  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarPropiedadesPorArrendador(id: number): Observable<Propiedad[]> {
    return this.http.get<Propiedad[]>(`${environment.serverUrl}/progrupo14/propiedad/arrendador/${id}`);
  }
  buscarPropiedad(id: number): Observable<Propiedad> {
    return this.http.get<Propiedad>(`${environment.serverUrl}/progrupo14/propiedad/${id}`);
  }

}
