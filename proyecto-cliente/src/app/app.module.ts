import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArrentarioListComponent } from './arrendatario/arrendatario-list/arrendatario-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ArrendatarioCreateComponent } from './arrendatario/arrendatario-create/arrendatario-create.component';
import { FormComponent } from './shared/form/form.component';
import { SolicitudListComponent } from './solicitud-arrendamiento/solicitud-list/solicitud-list.component';
import { PropiedadListComponent } from './propiedad/propiedad-list/propiedad-list.component';
import { PropiedadViewComponent } from './propiedad/propiedad-view/propiedad-view.component';
import { ArrendadorListComponent } from './arrendador/arrendador-list/arrendador-list.component';
import { ArrendatarioEditComponent } from './arrendatario/arrendatario-edit/arrendatario-edit.component';
import { BarraComponent } from './shared/barra/barra.component';

@NgModule({
  declarations: [
    AppComponent,
    ArrentarioListComponent,
    ArrendatarioCreateComponent,
    FormComponent,
    SolicitudListComponent,
    PropiedadListComponent,
    PropiedadViewComponent,
    ArrendadorListComponent,
    ArrendatarioEditComponent,
    BarraComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
