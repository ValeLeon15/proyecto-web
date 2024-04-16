import { Component, OnInit } from '@angular/core';
import { Arrendador } from '../../model/arrendador';
import { Router } from '@angular/router';
import { ArrendadorService } from '../../services/arrendador.service';

@Component({
  selector: 'app-arrendador-list',
  templateUrl: './arrendador-list.component.html',
  styleUrl: './arrendador-list.component.css'
})
export class ArrendadorListComponent implements OnInit {

  arrendadores: Arrendador[] = [];

  constructor(
    private arrendadorService: ArrendadorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.arrendadorService
      .listarArrendadores()
      .subscribe((arrendadores) => (this.arrendadores = arrendadores));
    console.log(this.arrendadores);
  }

  borrarArrendador(arrendadorId: number) {
    //lo implementan ustedes
    }
}
