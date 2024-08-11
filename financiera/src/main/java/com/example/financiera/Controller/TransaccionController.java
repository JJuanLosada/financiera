package com.example.financiera.Controller;


import com.example.financiera.Dto.TransaccionDto;
import com.example.financiera.Service.IService.ITransaccionService;


import com.example.financiera.entity.TransaccionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/transaccion")
public class TransaccionController {
    @Autowired
    private ITransaccionService iTransaccionService;

    @PostMapping("/consignacion")
    public ResponseEntity<?> consignacion(@RequestBody TransaccionDto transaccionDto){
        try {
            TransaccionEntity response=iTransaccionService.consignacion(transaccionDto);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/retiro")
    public ResponseEntity<?> retiro(@RequestBody TransaccionDto transaccionDto){
        try {
            TransaccionEntity response=iTransaccionService.retiro(transaccionDto);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/transferencia")
    public ResponseEntity<?> transferencia(@RequestBody TransaccionDto transaccionDto){
        try {
            TransaccionEntity response=iTransaccionService.transferencia(transaccionDto);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
