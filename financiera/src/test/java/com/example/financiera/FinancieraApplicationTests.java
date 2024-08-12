package com.example.financiera;

import com.example.financiera.Dto.ClienteDto;
import com.example.financiera.Service.ClienteImpl;
import com.example.financiera.entity.ClienteEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class FinancieraApplicationTests {

	/*
	@Autowired
	ClienteImpl cliente;
	@Test
	void contextLoads() {
		// Formato de fecha correcto
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nacimiento = LocalDate.parse("27/07/1999", formatter);

		// Crear ClienteDto y configurarlo
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNombre("juan");
		clienteDto.setApellido("los");
		clienteDto.setCorreo("djudf@prueba.com");
		clienteDto.setTipoIdentificacion("CC");
		clienteDto.setNumeroIdentificacion("182237");
		clienteDto.setNacimiento(nacimiento);

		// Llamada al método `crear`
		ClienteEntity clienteEntity = cliente.crear(clienteDto);
		System.out.print(clienteDto);
		
	}

	 */

}
