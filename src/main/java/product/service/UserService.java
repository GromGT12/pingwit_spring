package product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import product.controller.productDTO.UserDTO;
import product.controller.productDTO.UserFilterDTO;


import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getById(Integer id);

    Integer createUser(UserDTO userDTO);

    void deleteById(Integer id);

    List<UserDTO> searchByName(String name);

    UserDTO updateUser(Integer id, UserDTO userToUpdate);

    List<UserDTO> search(UserFilterDTO filter);

    Page<UserDTO> getPage(Pageable pageable);
}
