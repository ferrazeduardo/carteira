package com.multi.carteira.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.math.BigDecimal;

@Entity
@Table(name = "Carteira")
public class Carteiras {
    @Id
    private Long id;

    private BigDecimal valor;

    @Version
    private Long version;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
