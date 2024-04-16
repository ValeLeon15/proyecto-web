import { SolicitudArrendamientoService } from './../../services/solicitud-arrendamiento.service';
import { solicitudArrendamiento } from './../../model/solicitudArrendamiento';
import { Component, Input } from '@angular/core';
import { Router } from 'express';
import { ArrendatarioService } from '../../services/arrendatario.service';

@Component({
  selector: 'app-solicitud-list',
  templateUrl: './solicitud-list.component.html',
  styleUrl: './solicitud-list.component.css'
})
export class SolicitudListComponent {

  solicitudes: solicitudArrendamiento[] = [];
  arrendatarioId: number = 0;

  constructor(
    private solicitudService: SolicitudArrendamientoService,
  ){}

  @Input()
  set id(id: number) {
    this.arrendatarioId = id;
    console.log("id", id)
    this.solicitudService.listarSolicitudesPorArrendatario(id).subscribe(
      solicitudes => {
        this.solicitudes = solicitudes;
        console.log("solicitudes",this.solicitudes);
      }
    );
  }
}
