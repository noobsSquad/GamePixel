package com.gamepixel.api.mapper;

import com.gamepixel.api.dto.auth.RegisterRequest;
import com.gamepixel.api.models.Gamer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SignUpMapper {

    SignUpMapper INSTANCE = Mappers.getMapper(SignUpMapper.class);

    @Mapping(source = "gamerDto.email", target = "email")
    @Mapping(source = "gamerDto.firstName", target = "firstName")
    @Mapping(source = "gamerDto.lastName", target = "lastName")
    @Mapping(source = "gamerDto.username", target = "username")
    @Mapping(source = "gamerDto.password", target = "password")
    Gamer mapSignUp(RegisterRequest gamerDto);

}
