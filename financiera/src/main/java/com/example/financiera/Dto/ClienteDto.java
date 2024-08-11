package com.example.financiera.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter

public class ClienteDto {

    private String nombre;
    private String apellido;
    private String correo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private LocalDate nacimiento;
}
