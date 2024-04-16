import { Component, Input } from '@angular/core';
import { PropiedadService } from '../../services/propiedad.service';
import { Propiedad } from '../../model/propiedad';

@Component({
  selector: 'app-propiedad-view',
  templateUrl: './propiedad-view.component.html',
  styleUrl: './propiedad-view.component.css'
})
export class PropiedadViewComponent {
  constructor(private propiedadService: PropiedadService) {

  }

  propiedad: Propiedad = new Propiedad(0, "", "", "", "", "", 0, false, false, false, 0, 0);
  @Input()
  set id(id: number) {
    console.log("id", id)
    this.propiedadService.buscarPropiedad(id).subscribe(propiedad => this.propiedad = propiedad);
  }

  
}
