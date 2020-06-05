package tableTennisInstructor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.dto.response.UserHealthDTO;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.repository.UserHealthRepository;
import tableTennisInstructor.service.UserHealthService;

import java.util.Date;

@Service
public class UserHealthServiceImpl implements UserHealthService {

    @Autowired
    private UserHealthRepository userHealthRepository;

    @Override
    public UserHealth findUserHealthByUserId(Long userId) {
        return this.userHealthRepository.findUserHealthByUserId(userId)
                .orElseThrow(()-> new ApiRequestException("No userHealth for user with id: " + userId));
    }

    @Override
    public UserHealth updateUserHealth(UserHealthDTO userHealthDTO) {
        UserHealth updatedUserHealth = null;
        UserHealth oldUserHealth = this.findUserHealthByUserId(userHealthDTO.userId);
        if (oldUserHealth.getId().equals(userHealthDTO.getId())) {
            oldUserHealth.setDate(new Date());
            oldUserHealth.setDiastolic(userHealthDTO.getDiastolic());
            oldUserHealth.setSystolic(userHealthDTO.getSystolic());
            oldUserHealth.setHeartbeat(userHealthDTO.getHeartbeat());

            updatedUserHealth = this.userHealthRepository.save(oldUserHealth);
        }
        return updatedUserHealth;
    }

    @Override
    public UserHealth add(UserHealthDTO userHealthDTO, User user) {
        UserHealth userHealth = new UserHealth();
        userHealth.setUser(user);
        userHealth.setDate(new Date());
        userHealth.setDiastolic(userHealthDTO.getDiastolic());
        userHealth.setSystolic(userHealthDTO.getSystolic());
        userHealth.setHeartbeat(userHealthDTO.getHeartbeat());
        return this.userHealthRepository.save(userHealth);
    }
}
