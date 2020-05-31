package tableTennisInstructor.service.impl;

import tableTennisInstructor.dto.response.UserDTO;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.User;
import tableTennisInstructor.repository.UserRepository;
import tableTennisInstructor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return  userRepository.findById(id).
                orElseThrow(()-> new ApiRequestException("User with id '" + id + "' doesn't exist."));
    }

    @Override
    public UserDTO findById(Long id) throws ApiRequestException {
        try {
            User user = userRepository.findById(id).get();
            return new UserDTO(user);
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("User with id '" + id + "' doesn't exist.");
        }
    }

    @Override
    public UserDTO findByUsername(String username) throws ApiRequestException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new ApiRequestException("User with username '" + username + "' doesn't exist."));
        return new UserDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User oldUser = this.getById(userDTO.getId());
        oldUser.setLastName(userDTO.getLastName());
        oldUser.setFirstName(userDTO.getFirstName());
        oldUser.setEmail(userDTO.getEmail());
        User updatedUser = this.userRepository.save(oldUser);
        return new UserDTO(updatedUser);
    }
}
