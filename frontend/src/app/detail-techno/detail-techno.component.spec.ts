import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailTechnoComponent } from './detail-techno.component';

describe('DetailTechnoComponent', () => {
  let component: DetailTechnoComponent;
  let fixture: ComponentFixture<DetailTechnoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailTechnoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailTechnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
