import { TestBed } from '@angular/core/testing';

import { SolicitudArrendamientoService } from './solicitud-arrendamiento.service';

describe('SolicitudArrendamientoService', () => {
  let service: SolicitudArrendamientoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SolicitudArrendamientoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
