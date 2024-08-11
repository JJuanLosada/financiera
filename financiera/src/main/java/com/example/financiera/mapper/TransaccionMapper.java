package com.example.financiera.mapper;

import com.example.financiera.Dto.TransaccionDto;

import com.example.financiera.IRepository.IProductoRepository;
import com.example.financiera.constante.MensajeRespuestaGenerico;
import com.example.financiera.entity.ProductoEntity;
import com.example.financiera.entity.TransaccionEntity;

import java.time.LocalDate;

public class TransaccionMapper {
    public static TransaccionEntity ConsignacionToTransaccionEntity(TransaccionDto transaccionDto, ProductoEntity productoEntity, IProductoRepository iProductoRepository) {
        TransaccionEntity transaccionEntity = new TransaccionEntity();
        transaccionEntity.setMonto(transaccionDto.getMonto());
        transaccionEntity.setCuentaOrigen(productoEntity);
        productoEntity.setSaldo((float) (productoEntity.getSaldo() + transaccionDto.getMonto()));
        iProductoRepository.save(productoEntity);
        transaccionEntity.setFecha(LocalDate.now());
        transaccionEntity.setTipoTransaccion("Consignacion");
        return transaccionEntity;
    }
        public static TransaccionEntity RetiroToTransaccionEntity(TransaccionDto transaccionDto, ProductoEntity productoEntity, IProductoRepository iProductoRepository){
            TransaccionEntity transaccionEntity=new TransaccionEntity();
            transaccionEntity.setMonto(transaccionDto.getMonto());
            transaccionEntity.setCuentaOrigen(productoEntity);
            productoEntity.setSaldo((float) (productoEntity.getSaldo()- transaccionDto.getMonto()));
            if (productoEntity.getSaldo()- transaccionDto.getMonto()<0){
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_PRODUCTO_SALDO_INSUFICIENTE);
            }
            iProductoRepository.save(productoEntity);
            transaccionEntity.setFecha(LocalDate.now());
            transaccionEntity.setTipoTransaccion("Retiro");
            return transaccionEntity;
    }
    public static TransaccionEntity TransferenciaToTransaccionEntity(TransaccionDto transaccionDto, ProductoEntity productoEntity, IProductoRepository iProductoRepository){
        TransaccionEntity transaccionEntity=new TransaccionEntity();
        transaccionEntity.setMonto(transaccionDto.getMonto());
       transaccionEntity.setCuentaOrigen(productoEntity);
        productoEntity.setSaldo((float) (productoEntity.getSaldo()- transaccionDto.getMonto()));
        if (productoEntity.getSaldo()<0){
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_PRODUCTO_SALDO_INSUFICIENTE);
        }
        iProductoRepository.save(productoEntity);
        productoEntity=iProductoRepository.findById(transaccionDto.getCuentaDestino())
                .orElseThrow(() -> new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_PRODUCTO));
        productoEntity.setSaldo((float) (productoEntity.getSaldo()+ transaccionDto.getMonto()));
        transaccionEntity.setCuentaDestino(productoEntity);
        iProductoRepository.save(productoEntity);
        transaccionEntity.setFecha(LocalDate.now());
        transaccionEntity.setTipoTransaccion("Transferencia");
        return transaccionEntity;
    }
}
