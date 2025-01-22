package com.tekarch.tafUserService.Controllers;



import com.tekarch.tafUserService.DTO.UserDTO;
import com.tekarch.tafUserService.Services.Interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final  UserServiceInterface userService;

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }
//public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
//    UserDTO savedUser = userService.registerUser(userDTO);
//    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//}
    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        return userService.updateUser(userId, userDTO);
    }
}

