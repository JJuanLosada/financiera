package com.example.financiera.Controller;


import com.example.financiera.Dto.ClienteDto;
import com.example.financiera.Service.IService.IClienteService;
import com.example.financiera.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/crear")
    public ResponseEntity<?>crear(@RequestBody ClienteDto clienteDto){
        try {
            ClienteEntity response=iClienteService.crear(clienteDto);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody ClienteDto clienteDto) {

        try {
            ClienteEntity response=iClienteService.modificar(id,clienteDto);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


    @DeleteMapping("/clienteDelete/{id}")
    public String deleteClienteProducto(@PathVariable("id") Long idCliente) {
        return iClienteService.eliminarClienteProducto(idCliente);

        //return ResponseEntity.ok(deleteClientes);
    }



}

