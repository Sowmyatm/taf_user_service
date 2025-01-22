package com.tekarch.tafUserService.Services;



import com.tekarch.tafUserService.DTO.UserDTO;
import com.tekarch.tafUserService.Services.Interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
//import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//@Service
//
//public class UserServiceImpl implements UserServiceInterface {
//
//
//    private final RestTemplate restTemplate;
//    @Autowired
//    public UserServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    private static final String url  = "http://localhost:8080/datastore"; // TafDatastoreService URL
//
//    @Override
//    public UserDTO registerUser(UserDTO userDTO) {
//        return restTemplate.postForObject(url, userDTO, UserDTO.class);
//    }
//
//    @Override
//    public UserDTO getUser(Long userId) {
//        return restTemplate.getForObject(url + "/{userId}", UserDTO.class, userId);
//    }
//
//    @Override
//    public List<UserDTO> getAllUsers() {
//        UserDTO[] users = restTemplate.getForObject(url, UserDTO[].class);
//        return Arrays.asList(users);
//    }
//
//    @Override
//    public void updateUser(Long userId, UserDTO userDTO) {
//        restTemplate.put(url,"/{userId}", userDTO, userId);
//    }
//}
@Service
public class UserServiceImpl implements UserServiceInterface {

    private final RestTemplate restTemplate;

    private final String DATASTORE_SERVICE_URL = "http://localhost:8080/datastore/users";

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<UserDTO> getAllUsers() {
        UserDTO[] users = restTemplate.getForObject(DATASTORE_SERVICE_URL, UserDTO[].class);
        return Arrays.asList(users);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        return restTemplate.postForObject(DATASTORE_SERVICE_URL, userDTO, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return restTemplate.getForObject(DATASTORE_SERVICE_URL + "/" + userId, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        restTemplate.put(DATASTORE_SERVICE_URL + "/" + userId, userDTO);
        return userDTO;
    }
}

