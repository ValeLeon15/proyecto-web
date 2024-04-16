import { ArrentarioListComponent } from './arrendatario/arrendatario-list/arrendatario-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArrendatarioCreateComponent } from './arrendatario/arrendatario-create/arrendatario-create.component';
import { SolicitudListComponent } from './solicitud-arrendamiento/solicitud-list/solicitud-list.component';
import { PropiedadListComponent } from './propiedad/propiedad-list/propiedad-list.component';
import { PropiedadViewComponent } from './propiedad/propiedad-view/propiedad-view.component';
import { ArrendadorListComponent } from './arrendador/arrendador-list/arrendador-list.component';

const routes: Routes = [
  { path: 'arrendatarios/list', component: ArrentarioListComponent },
  { path: 'arrendatarios/create', component: ArrendatarioCreateComponent},
  { path: 'propiedades/arrendador/:id', component: PropiedadListComponent},
  { path: 'propiedad/view/:id', component: PropiedadViewComponent},
  { path: 'arrendadores/list', component: ArrendadorListComponent},
  { path: 'solicitudarrendamiento/arrendatario/:id', component: SolicitudListComponent},
  { path: '', pathMatch: 'full', redirectTo: 'arrendatarios/list' }, //siempre va a redirigir a arrendatarios/list cuando no se ponga nada como path en la url
];

@NgModule({
  imports: [RouterModule.forRoot(routes,
    {
      bindToComponentInputs: true, // Para poder usar @Input en rutas https://angular.io/guide/router
      onSameUrlNavigation: 'reload' // https://stackoverflow.com/a/52512361
    })], 
  exports: [RouterModule]
})
export class AppRoutingModule { }
