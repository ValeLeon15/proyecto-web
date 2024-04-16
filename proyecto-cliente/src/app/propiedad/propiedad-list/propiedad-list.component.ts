import { Component, Input, OnInit } from '@angular/core';
import { Propiedad } from '../../model/propiedad';
import { PropiedadService } from '../../services/propiedad.service';

@Component({
  selector: 'app-propiedad-list',
  templateUrl: './propiedad-list.component.html',
  styleUrl: './propiedad-list.component.css'
})
export class PropiedadListComponent{

  propiedades: Propiedad[] = [];
  arrendadorId: number = 0;

  constructor(
    private propiedadService: PropiedadService,
  ){}


  @Input()
  set id(id: number) {
    this.arrendadorId = id;
    console.log("id", id)
    this.propiedadService.listarPropiedadesPorArrendador(id).subscribe(
          propiedades => this.propiedades = propiedades
        )
        console.log(this.propiedades)
      }
  }


