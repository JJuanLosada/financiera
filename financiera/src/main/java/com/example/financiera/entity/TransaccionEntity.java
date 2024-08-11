package com.example.financiera.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaccion")
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;

    @Column(name = "monto")
    private Float monto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id")
    private ProductoEntity cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id") // The account to which the money is deposited
    private ProductoEntity cuentaDestino;
}
