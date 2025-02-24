package com.practice.music.service;

import com.practice.music.dto.AddUserRequestDTO;
import com.practice.music.entity.User;
import com.practice.music.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    public AddUserResponseDTO saveUser(AddUserRequestDTO requestDTO) {
//
//        AddUserResponseDTO addUserResponseDTO = new AddUserResponseDTO();
//
//        return addUserResponseDTO;
//    }

    public void saveUser(AddUserRequestDTO requestDTO){
        String name = requestDTO.getName();
        String password = requestDTO.getPassword();

        Boolean isExist = userRepository.existsByName(name);

        if (isExist){
            return;
        }
        User data = new User();

        data.setName(name);
        data.setEmail(requestDTO.getEmail());
        data.setPosition(requestDTO.getPosition());
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
