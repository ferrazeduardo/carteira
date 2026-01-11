package com.multi.carteira.infra.dao;

import com.multi.carteira.domain.entities.Carteira;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CarteiraDao extends JpaRepository<Carteira, Long> {
    Carteira findCarteiraById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Carteira findByIdToUpdate(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Modifying
    @Query("update Carteira c set c.valor = :valor where c.id = :id")
    int atualizarValor(@Param("id") Long id,
                       @Param("valor") BigDecimal valor);
}
