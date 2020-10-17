package com.example.demo.Convert;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {
@Autowired
    private ModelMapper modelMapper;
@Autowired
private RoleRepository roleRepository;
public UserEntity dtoToEntity(UserDTO userDTO){
    UserEntity entity=new UserEntity();
    modelMapper.map(userDTO,entity);
    entity.setRoleEntity(roleRepository.findByCode(userDTO.getCode()));
    return entity;
}
public UserDTO entityToDto(UserEntity entity){
    UserDTO dto=new UserDTO();
    modelMapper.map(entity,dto);
    dto.setCode(entity.getRoleEntity().getCode());
    return dto;
}
}
