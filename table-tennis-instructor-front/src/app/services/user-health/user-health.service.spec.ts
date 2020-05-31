import { TestBed } from '@angular/core/testing';

import { UserHealthService } from './user-health.service';

describe('UserHealthService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserHealthService = TestBed.get(UserHealthService);
    expect(service).toBeTruthy();
  });
});
