package com.example.demo.Convert;

import com.example.demo.DTO.RoleDTO;
import com.example.demo.Entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConvert {
    @Autowired
    private ModelMapper modelMapper;
    public RoleDTO entityToDto(RoleEntity entity){
        RoleDTO dto=new RoleDTO();
        modelMapper.map(entity,dto);
        return dto;
    }
    public RoleEntity dtoToEntity(RoleDTO roleDTO){
        RoleEntity entity=new RoleEntity();
        modelMapper.map(roleDTO,entity);
        return entity;
    }
}
