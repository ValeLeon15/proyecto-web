import { Component, Input, OnInit } from '@angular/core';
import { Arrendatario } from '../../model/arrendatario';
import { ArrendatarioService } from '../../services/arrendatario.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit{

  @Input() esCrear: boolean | undefined;
  arrendatarioCrearOActualizar: Arrendatario = new Arrendatario(0, '', '', '', 0, '');

  constructor(private arrendatarioService: ArrendatarioService) { 

  }
  ngOnInit(): void {
    if(!this.esCrear){
      this 
    }
  }
  crearArrendatario() {
    console.log('crear Arrendatario', this.arrendatarioCrearOActualizar);
    this.arrendatarioService.crearArrendatario(this.arrendatarioCrearOActualizar).subscribe(
      arrendatario => {
        console.log('Arrendatario creado', arrendatario);
        this.arrendatarioCrearOActualizar = new Arrendatario(0, '', '', '', 0, '');
      }
    );
    }

    actualizarArrendatario() {
      console.log('Actualizar Arrendatario', this.arrendatarioCrearOActualizar);
      this.arrendatarioService.actualizarArrendatario(this.arrendatarioCrearOActualizar).subscribe(
        arrendatario => {
          console.log('Arrendatario actualizado', arrendatario);
          this.arrendatarioCrearOActualizar = new Arrendatario(0, '', '', '', 0, '');
        }
      );
    }
  
}
