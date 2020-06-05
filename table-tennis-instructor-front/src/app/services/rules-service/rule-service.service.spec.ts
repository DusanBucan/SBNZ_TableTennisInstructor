import { TestBed } from '@angular/core/testing';

import { RuleServiceService } from './rule-service.service';

describe('RuleServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RuleServiceService = TestBed.get(RuleServiceService);
    expect(service).toBeTruthy();
  });
});
