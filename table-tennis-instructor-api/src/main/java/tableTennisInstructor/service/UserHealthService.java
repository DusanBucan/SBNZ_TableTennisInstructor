package tableTennisInstructor.service;

import tableTennisInstructor.model.drools.facts.UserHealth;

public interface UserHealthService {

    UserHealth findUserHealthByUserId(Long userId);
}
