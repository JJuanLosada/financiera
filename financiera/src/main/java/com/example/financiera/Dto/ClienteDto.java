package com.example.financiera.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter

public class ClienteDto {
    @NotBlank(message = "No se puede dejar vacio este campo")
    private String nombre;
    private String apellido;
    private String correo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private LocalDate nacimiento;
}
