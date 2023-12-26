package com.bootcamp.tarjeta.businees;

import com.bootcamp.tarjeta.model.entity.Tarjeta;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TarjetaService {
    Flux<Tarjeta> findAll();

    Mono<Tarjeta> create(Tarjeta tarjeta);

    Mono<Tarjeta> findAllBy(String id);
    Mono<Tarjeta> update(Tarjeta tarjeta);
    Mono<Void> deleteById(String id);

}
