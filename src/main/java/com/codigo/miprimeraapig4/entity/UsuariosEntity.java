package com.codigo.miprimeraapig4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuariosEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombres;
    //@Column(name = "apell_dos_pat", nullable = false, length = 100)
    private String apellidos;
    private Integer estado;

}
