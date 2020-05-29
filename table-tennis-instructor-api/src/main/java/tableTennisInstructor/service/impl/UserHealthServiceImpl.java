package tableTennisInstructor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.repository.UserHealthRepository;
import tableTennisInstructor.service.UserHealthService;

@Service
public class UserHealthServiceImpl implements UserHealthService {

    @Autowired
    private UserHealthRepository userHealthRepository;

    @Override
    public UserHealth findUserHealthByUserId(Long userId) {
        return this.userHealthRepository.findUserHealthByUserId(userId)
                .orElseThrow(()-> new ApiRequestException("No userHealth for user with id: " + userId));
    }
}
