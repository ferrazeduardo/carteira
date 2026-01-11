package com.multi.carteira.domain.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "NOME",length = 100,nullable = false)
    private String nome;

    @Column(name = "CPF",length = 11,nullable = false,unique = true)
    private String cpf;

    @Column(name = "DATANASCIMENTO",nullable = false)
    private Date dataNascimento;

    @OneToOne
    @JoinColumn(name = "ID_CARTEIRA")
    private Carteira carteira;
}
