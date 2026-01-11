package com.multi.carteira.application.usecases.carteira.saldo;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import com.multi.carteira.domain.entities.Carteira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Saldo {

    @Autowired
    private ICarteiraRepository _carteiraRepository;


    public BigDecimal Handler(Long id){
        Carteira carteira = _carteiraRepository.getCarteira(id);

        return carteira.getValor();
    }

}
