package com.practice.bbas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequestDTO {

    private String name;
    private String password;
    private String email;
    private String position;
}
