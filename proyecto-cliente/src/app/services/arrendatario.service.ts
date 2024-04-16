import { Arrendatario } from './../model/arrendatario';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { Propiedad } from '../model/propiedad';
import { solicitudArrendamiento } from '../model/solicitudArrendamiento';

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
  

  //Como no recibimos nada por parte del servidor una vez solicitamos borrar
  //un arrendatario, no es necesario retornar nada.
  borrarArrendatario(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.serverUrl}/progrupo14/arrendatarios/${id}`)
  }

  crearArrendatario(arrendatario : Arrendatario) : Observable<Arrendatario>{
    return this.http.post<Arrendatario>(`${environment.serverUrl}/progrupo14/arrendatarios`, arrendatario, { headers: this.headers })
  }

  actualizarArrendatario(arrendatario: Arrendatario) : Observable<Arrendatario>{ {
    return this.http.post<Arrendatario>(`${environment.serverUrl}/progrupo14/arrendatarios`, arrendatario, { headers: this.headers })
  }
}
}

