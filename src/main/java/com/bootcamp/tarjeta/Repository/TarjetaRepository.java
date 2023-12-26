package com.bootcamp.tarjeta.Repository;

import com.bootcamp.tarjeta.Repository.entities.TarjetaEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends ReactiveMongoRepository<TarjetaEntity, String> {

}
