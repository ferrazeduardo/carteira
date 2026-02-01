package com.multi.carteira.application.usecases.carteira.transferencia;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import com.multi.carteira.domain.entities.Carteira;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Transactional
public class Transferencia {

    @Autowired
    private ICarteiraRepository _carteiraRepository;

    public void Handler(TransferenciaInput transferenciaInput) {

        Carteira carteiraOrigem = _carteiraRepository.getCarteiraByUpdate(transferenciaInput.contaOrigem());
        Carteira carteiraDestino = _carteiraRepository.getCarteiraByUpdate(transferenciaInput.contaDestino());

        if(transferenciaInput.valor().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor deve ser maior que zero");

        if(carteiraOrigem.getValor().compareTo(transferenciaInput.valor()) < 0)
            throw new RuntimeException("Origem deve ser menor que zero");


        carteiraOrigem.Saque(transferenciaInput.valor());

        carteiraDestino.DepositoValor(transferenciaInput.valor());

        _carteiraRepository.update(carteiraOrigem);
        _carteiraRepository.update(carteiraDestino);

    }
}
