package com.example.financiera.Service;



import com.example.financiera.Dto.MProductoDto;
import com.example.financiera.Dto.ProductoDto;
import com.example.financiera.IRepository.IClienteRepository;
import com.example.financiera.IRepository.IProductoRepository;
import com.example.financiera.Service.IService.IProductoService;
import com.example.financiera.constante.MensajeRespuestaGenerico;
import com.example.financiera.entity.ClienteEntity;
import com.example.financiera.entity.ProductoEntity;

import com.example.financiera.mapper.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class ProductoImpl implements IProductoService {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public ProductoEntity crear(ProductoDto productoDto) {
        Long clienteId = productoDto.getIdCliente();
        ClienteEntity clienteEntity = iClienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_ASOCIADO_PRODUCTO));



            final String AHORRO="ahorro";
            final String CORRIENTE="corriente";



            if(!AHORRO.equalsIgnoreCase(productoDto.getTipoCuenta())&&!CORRIENTE.equalsIgnoreCase(productoDto.getTipoCuenta())){
                throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_TIPO_CUENTA_PRODUCTO);
            } else if (AHORRO.equalsIgnoreCase(productoDto.getTipoCuenta())&& productoDto.getSaldo()<0) {
                throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_SALDO_PRODUCTO);
            }
            ProductoEntity clienteEntitySave = ProductoMapper.productoDtoToProductoEntity(productoDto,AHORRO,CORRIENTE,clienteEntity);
            return iProductoRepository.save(clienteEntitySave);


            


    }

    @Override
    public ProductoEntity modificar( Long id,MProductoDto mProductoDto) {
        Long clienteId = mProductoDto.getIdCliente();
        ClienteEntity clienteEntity = iClienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_ID));

        ProductoEntity productoEntity = iProductoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_ASOCIADO_PRODUCTO));




                final String AHORRO = "ahorro";
                final String CORRIENTE = "corriente";
                final String ACTIVA = "activa";
                final String INACTIVA = "inactiva";
                final String CANCELADA = "cancelada";

                if (!AHORRO.equalsIgnoreCase(mProductoDto.getTipoCuenta()) && !CORRIENTE.equalsIgnoreCase(mProductoDto.getTipoCuenta())) {
                    throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_TIPO_CUENTA_PRODUCTO);
                } else if (AHORRO.equalsIgnoreCase(mProductoDto.getTipoCuenta()) && mProductoDto.getSaldo() < 0) {
                    throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_SALDO_PRODUCTO);
                } else if (!ACTIVA.equalsIgnoreCase(mProductoDto.getEstado()) && !INACTIVA.equalsIgnoreCase(mProductoDto.getEstado()) && !CANCELADA.equalsIgnoreCase(mProductoDto.getEstado())) {
                    throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_ESTADO_PRODUCTO);
                }   else if (CANCELADA.equalsIgnoreCase(mProductoDto.getEstado())&&mProductoDto.getSaldo()==0) {
                    throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_CANCELAR_PRODUCTO);
                }
            ProductoEntity clienteEntityUpdate = ProductoMapper.MproductoDtoToProductoEntity(mProductoDto,AHORRO,CORRIENTE,clienteEntity,productoEntity);
            return iProductoRepository.save(clienteEntityUpdate);







    }


}
