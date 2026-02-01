package com.multi.carteira.application.usecases.carteira.transferencia;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import com.multi.carteira.domain.entities.Carteira;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class Transferencia {

    @Autowired
    private ICarteiraRepository _cateiraRespository;

    public void Handler(TransferenciaInput transferenciaInput) {

        Carteira carteiraOrigem = _cateiraRespository.getCarteiraByUpdate(transferenciaInput.contaOrigem());
        Carteira carteiraDestino = _cateiraRespository.getCarteiraByUpdate(transferenciaInput.contaDestino());

        if(transferenciaInput.valor().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor deve ser maior que zero");

        if(carteiraOrigem.getValor().compareTo(transferenciaInput.valor()) < 0)
            throw new RuntimeException("Origem deve ser menor que zero");


        carteiraOrigem.Saque(transferenciaInput.valor());

        carteiraDestino.DepositoValor(transferenciaInput.valor());

        _cateiraRespository.update(carteiraOrigem);
        _cateiraRespository.update(carteiraDestino);

    }
}
