package com.example.financiera.Service.IService;

import com.example.financiera.Dto.ClienteDto;
import com.example.financiera.entity.ClienteEntity;

public interface IClienteService  {
    ClienteEntity crear(ClienteDto clienteDto);
    ClienteEntity modificar(Long id, ClienteDto ClienteDto);
    String eliminarClienteProducto(Long idCliente);


}
