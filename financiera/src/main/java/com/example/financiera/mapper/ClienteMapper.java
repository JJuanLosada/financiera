package com.example.financiera.mapper;

import com.example.financiera.Dto.ClienteDto;
import com.example.financiera.entity.ClienteEntity;

import java.time.LocalDate;

public class ClienteMapper {

    public static ClienteEntity clienteDtoToClienteEntity(ClienteDto clienteDto){
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre(clienteDto.getNombre());
        clienteEntity.setApellido(clienteDto.getApellido());
        clienteEntity.setCorreo(clienteDto.getCorreo());
        clienteEntity.setTipoIdentificacion(clienteDto.getTipoIdentificacion());
        clienteEntity.setNumeroIdentificacion(clienteDto.getNumeroIdentificacion());
        clienteEntity.setNacimiento(clienteDto.getNacimiento());
        clienteEntity.setCreacion(LocalDate.now());
        return clienteEntity;
    }
    public static ClienteEntity MclienteDtoToClienteEntity(ClienteDto clienteDto){
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre(clienteDto.getNombre());
        clienteEntity.setApellido(clienteDto.getApellido());
        clienteEntity.setCorreo(clienteDto.getCorreo());
        clienteEntity.setTipoIdentificacion(clienteDto.getTipoIdentificacion());
        clienteEntity.setNumeroIdentificacion(clienteDto.getNumeroIdentificacion());
        clienteEntity.setNacimiento(clienteDto.getNacimiento());
        clienteEntity.setModificacion(LocalDate.now());
        return clienteEntity;
    }
}
