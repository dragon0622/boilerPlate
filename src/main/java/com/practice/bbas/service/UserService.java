package com.practice.bbas.service;

import com.practice.bbas.dto.AddUserRequestDTO;
import com.practice.bbas.dto.AddUserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public AddUserResponseDTO saveUser(AddUserRequestDTO requestDTO) {

        AddUserResponseDTO addUserResponseDTO = new AddUserResponseDTO();

        return addUserResponseDTO;
    }
}
