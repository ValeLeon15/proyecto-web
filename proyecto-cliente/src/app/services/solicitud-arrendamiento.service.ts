import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { solicitudArrendamiento } from '../model/solicitudArrendamiento';

@Injectable({
  providedIn: 'root'
})
export class SolicitudArrendamientoService {

  constructor(
    private http: HttpClient
  ) { }
  
  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarSolicitudesPorArrendatario(id: number): Observable<solicitudArrendamiento[]> {
    return this.http.get<solicitudArrendamiento[]>(`${environment.serverUrl}/progrupo14/solicitudarrendamiento/arrendatario/${id}`)
  }
}
