package com.multi.carteira.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.math.BigDecimal;

@Entity
@Table(name = "Carteira")
public class Carteira {
    @Id
    private Long id;
    private BigDecimal valor;

    @Version
    private Integer version;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void DepositoValor(BigDecimal valorAdicionar){
        this.valor = valorAdicionar.add(this.valor);
    }


    public void Saque(BigDecimal valorSacar) {
        this.valor = this.valor.subtract(valorSacar);
    }
}
