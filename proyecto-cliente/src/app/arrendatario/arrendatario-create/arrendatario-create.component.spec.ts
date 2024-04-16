import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArrendatarioCreateComponent } from './arrendatario-create.component';

describe('ArrendatarioCreateComponent', () => {
  let component: ArrendatarioCreateComponent;
  let fixture: ComponentFixture<ArrendatarioCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ArrendatarioCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ArrendatarioCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
