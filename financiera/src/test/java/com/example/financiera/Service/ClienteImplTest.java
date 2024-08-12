package com.example.financiera.Service;

import com.example.financiera.Dto.ClienteDto;
import com.example.financiera.IRepository.IClienteRepository;
import com.example.financiera.entity.ClienteEntity;
import com.example.financiera.mapper.ClienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;


class ClienteImplTest {

    @Mock
    private IClienteRepository iClienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteImpl clienteImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crear() {

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("JUAN SEBASTIAN");
        clienteDto.setApellido("LOSADA MOYANO");
        clienteDto.setNacimiento(LocalDate.of(1990, 1, 1));
        clienteDto.setCorreo("juan.perez@example.com");

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre("JUAN SEBASTIAN");
        clienteEntity.setApellido("LOSADA MOYANO");
        //clienteEntity.setNacimiento(clienteDto.getNacimiento());
        //clienteEntity.setCorreo(clienteDto.getCorreo());

        //Mockito.when(iClienteRepository.save(clienteEntity));
        Mockito.when(iClienteRepository.save(clienteEntity)).thenReturn(clienteEntity);

        ClienteEntity response = clienteImpl.crear(clienteDto);

        assertEquals("JUAN SEBASTIAN", clienteEntity.getNombre());
        //assertEquals("LOSADA MOYANO", response.getApellido());

    }

    @Test
    void modificar() {
        Long id=1L;
        ClienteDto clienteDto=new ClienteDto();
        ClienteEntity clienteEntity =new ClienteEntity();
        Mockito.when(iClienteRepository.findById(id)).thenReturn(Optional.of(clienteEntity));
        clienteDto.setNombre("Juan Prueba");
        clienteDto.setApellido("Losada");
        clienteDto.setNacimiento(LocalDate.of(1999,10,20));
        clienteDto.setCorreo("Juan@prueba.com");

        clienteEntity.setNombre("Juan Prueba");
        clienteEntity.setApellido("Losada");

        Mockito.when(iClienteRepository.save(clienteEntity)).thenReturn(clienteEntity);
        ClienteEntity response=clienteImpl.modificar(id,clienteDto);
        assertEquals("Losada",clienteEntity.getApellido());
    }

    @Test
    void eliminarClienteProducto() {

        //Arrange
        Long idCliente = 1L;

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre("JUAN");
        clienteEntity.setProducto(new ArrayList<>());

        //Actuar
        Mockito.when(iClienteRepository.findById(idCliente)).thenReturn(Optional.of(clienteEntity));

        doNothing().when(iClienteRepository).deleteById(idCliente);
        //Mockito.when(iClienteRepository.deleteById(idCliente));

        String response = clienteImpl.eliminarClienteProducto(idCliente);

        //Afirmar
        assertEquals("Borrado exitosamente", response);

    }
}