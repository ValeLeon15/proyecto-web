import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { ArrentarioListComponent } from './arrendatario/arrentario-list/arrentario-list.component';

export const routes: Routes = [
    {path: 'arrendatarios', component:ArrentarioListComponent}
];

