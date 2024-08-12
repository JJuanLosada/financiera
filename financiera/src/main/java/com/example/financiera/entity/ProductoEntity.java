package com.example.financiera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "estado")
    private String estado;

    @Column(name = "saldo")
    private Float saldo;

    @Column(name = "exenta_gmf")
    private String exenta_gmf;

    @Column(name = "creacion")
    private LocalDate creacion;

    @Column(name = "modificacion")
    private LocalDate modificacion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;


}
