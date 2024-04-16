import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropiedadViewComponent } from './propiedad-view.component';

describe('PropiedadViewComponent', () => {
  let component: PropiedadViewComponent;
  let fixture: ComponentFixture<PropiedadViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PropiedadViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PropiedadViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
