package com.example.financiera.Service;

import com.example.financiera.Dto.ClienteDto;
import com.example.financiera.IRepository.IClienteRepository;
import com.example.financiera.IRepository.IProductoRepository;
import com.example.financiera.Service.IService.IClienteService;
import com.example.financiera.constante.MensajeRespuestaGenerico;
import com.example.financiera.entity.ClienteEntity;
import com.example.financiera.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.regex.Pattern;


@Service
public class ClienteImpl implements IClienteService {
    @Autowired
    private IClienteRepository iClienteRepository;

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public ClienteEntity crear(ClienteDto clienteDto) {



        LocalDate ahora = LocalDate.now();
        LocalDate nacimiento = clienteDto.getNacimiento();
        Period edad = Period.between(nacimiento, ahora);



        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (clienteDto.getNombre().length() < 2 || clienteDto.getApellido().length() < 2 ) {
          throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_NOMBRE_CLIENTE) ;
        } else if (edad.getYears() < 18) {
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_EDAD_CLIENTE);
        } else if (!pattern.matcher(clienteDto.getCorreo()).matches()) {
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_CORREO_CLIENTE);
        } else {
            ClienteEntity clienteEntitySave = ClienteMapper.clienteDtoToClienteEntity(clienteDto);
            return iClienteRepository.save(clienteEntitySave);
        }
    }

    @Override
    public ClienteEntity modificar(Long id, ClienteDto clienteDto) {

        Optional<ClienteEntity> existe=iClienteRepository.findById(id);


        if(!existe.isPresent()){
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_ID);
        }

        LocalDate ahora = LocalDate.now();
        LocalDate nacimiento = clienteDto.getNacimiento();
        Period edad = Period.between(nacimiento, ahora);



        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (clienteDto.getNombre().length() < 2 || clienteDto.getApellido().length() < 2 ) {
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_NOMBRE_CLIENTE) ;
        } else if (edad.getYears() < 18) {
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_EDAD_CLIENTE);
        } else if (!pattern.matcher(clienteDto.getCorreo()).matches()) {
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_CORREO_CLIENTE);
        } else {
            ClienteEntity clienteEntityUpdate = ClienteMapper.MclienteDtoToClienteEntity(clienteDto);
            return iClienteRepository.save(clienteEntityUpdate);
        }

    }






    @Override
    public String eliminarClienteProducto(Long idCliente) {
        Optional<ClienteEntity> clienteOptional = iClienteRepository.findById(idCliente);
        if (clienteOptional.isPresent()){
            if (clienteOptional.get().getProducto().isEmpty()){
                iClienteRepository.deleteById(idCliente);
                return "Borrado exitosamente";
            }
            throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_BORRADO_CLIENTE);
        }
        throw new IllegalArgumentException(MensajeRespuestaGenerico.MENSAJE_ERROR_ID);
    }




}
