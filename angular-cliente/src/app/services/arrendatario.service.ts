import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Arrendatario } from '../model/arrendatario';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ArrendatarioService {

  constructor(
    private http: HttpClient
  ) { }
  
  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarArrendatarios(): Observable<Arrendatario[]> {
    return this.http.get<Arrendatario[]>(`${environment.serverUrl}/progrupo14/arrendatarios`)
  }
}

