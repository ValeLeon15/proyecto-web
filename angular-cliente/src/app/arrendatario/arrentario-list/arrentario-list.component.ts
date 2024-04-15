import { Component, OnInit } from '@angular/core';
import { Arrendatario } from '../../model/arrendatario';
import { ArrendatarioService } from '../../services/arrendatario.service';

@Component({
  selector: 'app-arrentario-list',
  standalone: true,
  imports: [],
  templateUrl: './arrentario-list.component.html',
  styleUrl: './arrentario-list.component.css'
})
export class ArrentarioListComponent implements OnInit{
  arrendatarios : Arrendatario[] = [];
  constructor(
    private arrendatarioService: ArrendatarioService
  ) {

  }
  ngOnInit(): void {
    this.arrendatarioService.listarArrendatarios().subscribe(
     arrendatarios => this.arrendatarios = arrendatarios
    )
  }
}
