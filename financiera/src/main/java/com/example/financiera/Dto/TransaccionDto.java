package com.example.financiera.Dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransaccionDto {

    private Float monto;
    private Long cuentaOrigen;
    private Long cuentaDestino;

}
