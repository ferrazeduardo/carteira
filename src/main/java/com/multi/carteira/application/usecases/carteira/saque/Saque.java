package com.multi.carteira.application.usecases.carteira.saque;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Transactional
public class Saque {

    @Autowired
    private ICarteiraRepository _carteiraRepository;

    public void Handler(SaqueInput saqueInput){
        com.multi.carteira.domain.entities.Carteira carteira =  _carteiraRepository.getCarteira(saqueInput.id());

        if(saqueInput.valor().compareTo(BigDecimal.ZERO) < 0)
            throw new RuntimeException("Valor sacado não pode ser menor que zero");

        if(carteira.getValor().compareTo(saqueInput.valor()) < 0)
            throw new RuntimeException("Saldo insuficiente");



        carteira.Saque(saqueInput.valor());

        _carteiraRepository.update(carteira);
    }

}
