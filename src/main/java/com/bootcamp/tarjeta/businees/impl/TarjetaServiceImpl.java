package com.bootcamp.tarjeta.businees.impl;

import com.bootcamp.tarjeta.Repository.TarjetaRepository;
import com.bootcamp.tarjeta.Repository.entities.TarjetaEntity;
import com.bootcamp.tarjeta.businees.TarjetaService;
import com.bootcamp.tarjeta.model.entity.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public Flux<Tarjeta> findAll() {
        return this.tarjetaRepository
                .findAll()
                .map(TarjetaEntity::toTarjeta);
    }

    @Override
    public Mono<Tarjeta> create(Tarjeta tarjeta) {
        return tarjetaRepository.save(new TarjetaEntity().toTarjetaEntity(tarjeta))
                .map(TarjetaEntity::toTarjeta);
    }

    @Override
    public Mono<Tarjeta> findAllBy(String id){
        return tarjetaRepository.findById(id)
                .map(TarjetaEntity::toTarjeta);
    }
    @Override
    public Mono<Tarjeta> update(Tarjeta cuenta){
        return tarjetaRepository.save(new TarjetaEntity().toTarjetaEntity(cuenta))
                .map(TarjetaEntity::toTarjeta);
    }
    @Override
    public Mono<Void> deleteById(String id){
        return tarjetaRepository.deleteById(id);
    }
}
