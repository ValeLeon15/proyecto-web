import { Component, OnInit } from '@angular/core';
import { ArrendatarioService } from '../../services/arrendatario.service';
import { Arrendatario } from '../../model/arrendatario';

@Component({
  selector: 'app-arrendatario-create',
  templateUrl: './arrendatario-create.component.html',
  styleUrl: './arrendatario-create.component.css'
})
export class ArrendatarioCreateComponent {

arrendatarioCrear: Arrendatario = new Arrendatario(0, '', '', '', 0, '');
esCrear: boolean = true;

}
