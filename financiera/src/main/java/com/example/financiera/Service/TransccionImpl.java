package com.example.financiera.Service;

import com.example.financiera.Dto.TransaccionDto;
import com.example.financiera.IRepository.IProductoRepository;
import com.example.financiera.IRepository.ITransaccionRepository;
import com.example.financiera.Service.IService.ITransaccionService;
import com.example.financiera.constante.MensajeRespuestaGenerico;
import com.example.financiera.entity.ProductoEntity;
import com.example.financiera.entity.TransaccionEntity;
import com.example.financiera.mapper.TransaccionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransccionImpl implements ITransaccionService {
    @Autowired
    private ITransaccionRepository iTransaccionRepository;

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public TransaccionEntity consignacion(TransaccionDto transaccionDto) {
      ProductoEntity productoEntity=iProductoRepository.findById(transaccionDto.getCuentaOrigen())
              .orElseThrow(() -> new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_PRODUCTO));
        TransaccionEntity ConsignacionTransaccion= TransaccionMapper.ConsignacionToTransaccionEntity(transaccionDto,productoEntity,iProductoRepository);

        return iTransaccionRepository.save(ConsignacionTransaccion);
    }

    @Override
    public TransaccionEntity retiro(TransaccionDto transaccionDto) {
        ProductoEntity productoEntity=iProductoRepository.findById(transaccionDto.getCuentaOrigen())
                .orElseThrow(() -> new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_PRODUCTO));
                TransaccionEntity RetiroTransaccion=TransaccionMapper.RetiroToTransaccionEntity(transaccionDto,productoEntity,iProductoRepository);
                return iTransaccionRepository.save(RetiroTransaccion);
    }

    @Override
    public TransaccionEntity transferencia(TransaccionDto transaccionDto) {
        ProductoEntity productoEntity=iProductoRepository.findById(transaccionDto.getCuentaOrigen())
                .orElseThrow(() -> new IllegalArgumentException("hola"));
        TransaccionEntity TransferenciaTransaccion=TransaccionMapper.TransferenciaToTransaccionEntity(transaccionDto,productoEntity,iProductoRepository);
        return iTransaccionRepository.save(TransferenciaTransaccion);
    }


}
