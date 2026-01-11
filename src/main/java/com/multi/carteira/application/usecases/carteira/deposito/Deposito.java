package com.multi.carteira.application.usecases.carteira.deposito;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import com.multi.carteira.domain.entities.Carteira;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Deposito {

    @Autowired
    private ICarteiraRepository _carteiraRepository;

    public void Handler(DepositoInput depositoInput){

        Carteira carteira = _carteiraRepository.getCarteira(depositoInput.id());
        _carteiraRepository.update(carteira);

    }
}
