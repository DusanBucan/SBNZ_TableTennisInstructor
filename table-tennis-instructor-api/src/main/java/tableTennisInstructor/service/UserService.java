package tableTennisInstructor.service;

import tableTennisInstructor.dto.response.UserDTO;
import tableTennisInstructor.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);
    UserDTO findById(Long id);
    UserDTO findByUsername(String username);
    List<UserDTO> findAll();
    UserDTO updateUser(UserDTO userDTO);
}
