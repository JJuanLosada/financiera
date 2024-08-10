package com.example.financiera.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",length = 70)
    private String nombre;

    @Column(name = "apellido",length = 70)
    private String apellido;

    @Column(name = "correo",length = 200)
    private String correo;

    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @Column(name ="numero_identificacion",length = 10)
    private String numeroIdentificacion;

    @Column(name = "nacimiento")
    private LocalDate nacimiento;

    @Column(name = "creacion")
    private LocalDate creacion;

    @Column(name = "modificacion")
    private LocalDate modificacion;

   @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
   private List<ProductoEntity> producto;

}
