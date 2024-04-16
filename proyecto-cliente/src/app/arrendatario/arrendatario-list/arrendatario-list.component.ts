import { Component, OnInit } from '@angular/core';
import { Arrendatario } from '../../model/arrendatario';
import { ArrendatarioService } from '../../services/arrendatario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-arrentario-list',
  templateUrl: './arrendatario-list.component.html',
  styleUrl: './arrendatario-list.component.css',
})
export class ArrentarioListComponent implements OnInit {
  arrendatarios: Arrendatario[] = [];

  constructor(
    private arrendatarioService: ArrendatarioService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.arrendatarioService
      .listarArrendatarios()
      .subscribe((arrendatarios) => (this.arrendatarios = arrendatarios));
    console.log(this.arrendatarios);
  }

  borrarArrendatario(id: number): void {
    this.arrendatarioService.borrarArrendatario(id).subscribe();
    this.router.navigate(['/arrendatarios/list']);
  }
}
