package com.multi.carteira.infra.repository;

import com.multi.carteira.application.gateways.repository.ICarteiraRepository;
import com.multi.carteira.domain.entities.Carteira;
import com.multi.carteira.infra.dao.CarteiraDao;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CarteiraRepository implements ICarteiraRepository {

    private final CarteiraDao _carteiraDao;

    public CarteiraRepository(CarteiraDao carteiraDao){
        _carteiraDao = carteiraDao;
    }


    @Override
    public Carteira getCarteira(Long id) {
        return _carteiraDao.findCarteiraById(id);

    }

    @Override
    public Carteira getCarteiraByUpdate(Long id) {
        return _carteiraDao.findByIdToUpdate(id);
    }

    @Override
    public void update(Carteira carteira) {
        _carteiraDao.atualizarValor(carteira.getId(),carteira.getValor());
    }

}
