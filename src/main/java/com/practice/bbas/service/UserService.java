package com.practice.bbas.service;

import com.practice.bbas.dto.AddUserRequestDTO;
import com.practice.bbas.entity.User;
import com.practice.bbas.repository.UserRepository;
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
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
