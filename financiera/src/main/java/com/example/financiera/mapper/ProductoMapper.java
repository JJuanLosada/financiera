package com.example.financiera.mapper;


import com.example.financiera.Dto.MProductoDto;
import com.example.financiera.Dto.ProductoDto;

import com.example.financiera.entity.ProductoEntity;

import java.time.LocalDate;
import java.util.Random;

public class ProductoMapper {

    public static ProductoEntity productoDtoToProductoEntity(ProductoDto productoDto, String AHORRO, String CORRIENTE){
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setSaldo(productoDto.getSaldo());
        productoEntity.setTipoCuenta(productoDto.getTipoCuenta());
        Random random = new Random();
        StringBuilder numerosAleatorios = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            numerosAleatorios.append(random.nextInt(10)); // Generar un dígito aleatorio (0-9)
        }
        if (CORRIENTE.equalsIgnoreCase(productoDto.getTipoCuenta())) {
            final String prefijo="33"+numerosAleatorios.toString();
            productoEntity.setNumeroCuenta(prefijo);
        } else if (AHORRO.equalsIgnoreCase(productoDto.getTipoCuenta())) {
            final String prefijo="53"+numerosAleatorios.toString();
            productoEntity.setNumeroCuenta(prefijo);
        }
        productoEntity.setEstado("ACTIVA");
        productoEntity.setExenta_gmf(productoDto.getExenta_gmf());
        productoEntity.setCreacion(LocalDate.now());
        productoEntity.setTipoCuenta(productoDto.getTipoCuenta());
        productoEntity.setCliente(productoDto.getIdClienteEntity());
        return productoEntity;
    }

    public static ProductoEntity MproductoDtoToProductoEntity(MProductoDto mproductoDto,String AHORRO,String CORRIENTE){
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setSaldo(mproductoDto.getSaldo());
        productoEntity.setTipoCuenta(mproductoDto.getTipoCuenta());

        Random random = new Random();
        StringBuilder numerosAleatorios = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            numerosAleatorios.append(random.nextInt(10)); // Generar un dígito aleatorio (0-9)
        }
        if (CORRIENTE.equalsIgnoreCase(mproductoDto.getTipoCuenta())) {
            final String prefijo="33"+numerosAleatorios.toString();
            productoEntity.setNumeroCuenta(prefijo);
        } else if (AHORRO.equalsIgnoreCase(mproductoDto.getTipoCuenta())) {
            final String prefijo="53"+numerosAleatorios.toString();
            productoEntity.setNumeroCuenta(prefijo);
        }
        productoEntity.setEstado(mproductoDto.getEstado());
        productoEntity.setExenta_gmf(mproductoDto.getExenta_gmf());
        productoEntity.setModificacion(LocalDate.now());
        productoEntity.setTipoCuenta(mproductoDto.getTipoCuenta());

        return productoEntity;
    }
}
