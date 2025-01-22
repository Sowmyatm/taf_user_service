package com.tekarch.tafUserService.Services.Interfaces;



import com.tekarch.tafUserService.DTO.UserDTO;
import java.util.List;

public interface UserServiceInterface {
    UserDTO registerUser(UserDTO userDTO);
//    UserDTO getUser(Long userId);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers(); // Added method for getting all users
    UserDTO updateUser(Long userId, UserDTO userDTO);
}

