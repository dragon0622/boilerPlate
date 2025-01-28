package com.practice.bbas.controller;

import com.practice.bbas.dto.AddUserRequestDTO;
import com.practice.bbas.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@ResponseBody
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/api/signup")
//    public AddUserResponseDTO signup(@RequestBody AddUserRequestDTO requestDTO){
//        return userService.saveUser(requestDTO);
//    }
//
//    @PostMapping("/api/login")
//    public AddUserResponseDTO login(@RequestBody AddUserRequestDTO requestDTO){
//        return userService.saveUser(requestDTO);
//    }

    @PostMapping("/api/signUp")
    public String signUp(AddUserRequestDTO requestDTO){
        System.out.println(requestDTO.getUserName());
        userService.saveUser(requestDTO);

        return "ok";
    }
}
