package com.example.financiera.Dto;



import com.example.financiera.entity.ClienteEntity;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProductoDto {


    private String tipoCuenta;


    private Float saldo;
    private String exenta_gmf;
    private Long idCliente;
}
