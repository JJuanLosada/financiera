package com.example.financiera.Service.IService;


import com.example.financiera.Dto.TransaccionDto;
import com.example.financiera.entity.TransaccionEntity;

public interface ITransaccionService   {
    TransaccionEntity consignacion(TransaccionDto transaccionDto);
    TransaccionEntity retiro(TransaccionDto transaccionDto);
    TransaccionEntity transferencia(TransaccionDto transaccionDto);
}
