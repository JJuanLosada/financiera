package com.example.financiera.Service.IService;



import com.example.financiera.Dto.MProductoDto;
import com.example.financiera.Dto.ProductoDto;
import com.example.financiera.entity.ProductoEntity;

public interface IProductoService {
    ProductoEntity crear(ProductoDto productoDto);
    ProductoEntity modificar(Long id, MProductoDto mProductoDto);
}
