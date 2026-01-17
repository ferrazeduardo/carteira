package com.multi.carteira.application.usecases.carteira.deposito;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import com.multi.carteira.domain.entities.Carteira;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Transactional
public class Deposito {

    @Autowired
    private ICarteiraRepository _carteiraRepository;

    public void Handler(DepositoInput depositoInput){
        if(depositoInput.valor().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor deve ser maior que zero");


        Carteira carteira = _carteiraRepository.getCarteira(depositoInput.id());
        carteira.DepositoValor(depositoInput.valor());
        _carteiraRepository.update(carteira);

    }
}
