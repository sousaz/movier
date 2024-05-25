package com.desafio.backend.dto.mapper;

import com.desafio.backend.dto.UserLoginRequestDTO;
import com.desafio.backend.dto.UserLoginResponseDTO;
import com.desafio.backend.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    public Users toEntity(UserLoginRequestDTO userDTO){
        if(userDTO == null)
            return null;
        Users user = new Users();
        user.setId(userDTO.id());
        user.setUsername(userDTO.username());
        user.setPassword(userDTO.password());
        return user;
    }

    public UserLoginResponseDTO toDTO(Users user){
        if(user == null)
            return null;
        return new UserLoginResponseDTO(user.getId(), user.getUsername());
    }
}
