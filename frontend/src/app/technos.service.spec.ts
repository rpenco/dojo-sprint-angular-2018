import { TestBed, inject } from '@angular/core/testing';

import { TechnosService } from './technos.service';

describe('TechnosService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TechnosService]
    });
  });

  it('should be created', inject([TechnosService], (service: TechnosService) => {
    expect(service).toBeTruthy();
  }));
});
