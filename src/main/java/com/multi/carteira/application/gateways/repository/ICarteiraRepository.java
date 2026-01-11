package com.multi.carteira.application.gateways.repository;

import com.multi.carteira.domain.entities.Carteira;

public interface ICarteiraRepository {
    Carteira getCarteira(Long id);
}
