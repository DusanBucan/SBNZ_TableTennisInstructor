package tableTennisInstructor.service;

import tableTennisInstructor.dto.response.UserHealthDTO;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.UserHealth;

public interface UserHealthService {

    UserHealth findUserHealthByUserId(Long userId);

    UserHealth updateUserHealth(UserHealthDTO userHealthDTO);

    UserHealth add(UserHealthDTO userHealthDTO, User user);
}
