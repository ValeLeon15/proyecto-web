import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArrentarioListComponent } from './arrendatario-list.component';

describe('ArrentarioListComponent', () => {
  let component: ArrentarioListComponent;
  let fixture: ComponentFixture<ArrentarioListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArrentarioListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ArrentarioListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
