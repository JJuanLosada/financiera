package com.example.financiera;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import com.example.financiera.Dto.ClienteDto;
import com.example.financiera.entity.ClienteEntity;
import com.example.financiera.mapper.ClienteMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ClienteMapperTest {

    /*
    @Test
    public void testClienteDtoToClienteEntity() {
        // Crear un objeto ClienteDto de ejemplo
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("John");
        clienteDto.setApellido("Doe");
        clienteDto.setCorreo("john.doe@example.com");
        clienteDto.setTipoIdentificacion("CC");
        clienteDto.setNumeroIdentificacion("123456789");
        clienteDto.setNacimiento(LocalDate.of(1990, 1, 1));

        // Invocar el método a probar
        ClienteEntity clienteEntity = ClienteMapper.clienteDtoToClienteEntity(clienteDto);

        // Verificar los resultados
        assertEquals(clienteDto.getNombre(), clienteEntity.getNombre());
        assertEquals(clienteDto.getApellido(), clienteEntity.getApellido());
        assertEquals(clienteDto.getCorreo(), clienteEntity.getCorreo());
        assertEquals(clienteDto.getTipoIdentificacion(), clienteEntity.getTipoIdentificacion());
        assertEquals(clienteDto.getNumeroIdentificacion(), clienteEntity.getNumeroIdentificacion());
        assertEquals(clienteDto.getNacimiento(), clienteEntity.getNacimiento());
        assertEquals(LocalDate.now(), clienteEntity.getCreacion());
    }

    @Test
    public void testMclienteDtoToClienteEntity() {
        // Crear un objeto ClienteDto de ejemplo
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("Jane");
        clienteDto.setApellido("Doe");
        clienteDto.setCorreo("jane.doe@example.com");
        clienteDto.setTipoIdentificacion("TI");
        clienteDto.setNumeroIdentificacion("987654321");
        clienteDto.setNacimiento(LocalDate.of(1995, 5, 5));

        // Invocar el método a probar
        ClienteEntity clienteEntity = ClienteMapper.MclienteDtoToClienteEntity(clienteDto);

        // Verificar los resultados
        assertEquals(clienteDto.getNombre(), clienteEntity.getNombre());
        assertEquals(clienteDto.getApellido(), clienteEntity.getApellido());
        assertEquals(clienteDto.getCorreo(), clienteEntity.getCorreo());
        assertEquals(clienteDto.getTipoIdentificacion(), clienteEntity.getTipoIdentificacion());
        assertEquals(clienteDto.getNumeroIdentificacion(), clienteEntity.getNumeroIdentificacion());
        assertEquals(clienteDto.getNacimiento(), clienteEntity.getNacimiento());
        assertEquals(LocalDate.now(), clienteEntity.getModificacion());
    }

     */

}

