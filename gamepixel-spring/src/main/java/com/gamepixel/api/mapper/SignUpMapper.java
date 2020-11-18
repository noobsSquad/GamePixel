package com.gamepixel.api.mapper;


import com.gamepixel.api.dto.auth.RegisterRequest;

import com.gamepixel.api.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface SignUpMapper {

    SignUpMapper INSTANCE = Mappers.getMapper(SignUpMapper.class);


    @Mapping(source = "registerRequest.email", target = "email")
    @Mapping(source = "registerRequest.firstName", target = "firstName")
    @Mapping(source = "registerRequest.lastName", target = "lastName")
    @Mapping(source = "registerRequest.username", target = "username")
    User mapSignUp(RegisterRequest registerRequest);

}
