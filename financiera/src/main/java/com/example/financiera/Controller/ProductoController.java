package com.example.financiera.Controller;


import com.example.financiera.Dto.MProductoDto;
import com.example.financiera.Dto.ProductoDto;
import com.example.financiera.Service.IService.IProductoService;
import com.example.financiera.entity.ProductoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/producto")
public class ProductoController {
    @Autowired
    private IProductoService iProductoService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ProductoDto productoDto){
        try {
            ProductoEntity response=iProductoService.crear(productoDto);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody MProductoDto mProductoDto) {
        try {
            ProductoEntity response = iProductoService.modificar(id, mProductoDto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
