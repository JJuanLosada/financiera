package com.example.financiera.Dto;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MProductoDto {
    private  Long Id;
    private Float saldo;
    private String tipoCuenta;
    private String estado;
    private String exenta_gmf;

}
