package com.multi.carteira.infra.repository;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import com.multi.carteira.domain.entities.Carteira;
import org.springframework.stereotype.Repository;

@Repository
public class CarteiraRepository implements ICarteiraRepository {



    @Override
    public Carteira getCarteira(Long id) {
        return null;
    }
}
