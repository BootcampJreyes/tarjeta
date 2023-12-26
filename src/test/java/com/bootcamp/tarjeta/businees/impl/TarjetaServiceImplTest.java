package com.bootcamp.tarjeta.businees.impl;

import com.bootcamp.tarjeta.Repository.TarjetaRepository;
import com.bootcamp.tarjeta.Repository.entities.TarjetaEntity;
import com.bootcamp.tarjeta.model.entity.Tarjeta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TarjetaServiceImplTest {
    @Mock
    private TarjetaRepository tarjetaRepository;
    @InjectMocks
    private TarjetaServiceImpl tarjetaServiceImpl;


    @Test
    void findAll() {
        when(tarjetaRepository.findAll()).thenReturn(Flux.just(getTarjetaEntity()));
        when(tarjetaServiceImpl.findAll()).thenReturn(Flux.just(getTarjeta()));

        Flux<Tarjeta> resultado = tarjetaServiceImpl.findAll();
        StepVerifier.create(resultado)
                .expectNext(getTarjeta())
                .expectComplete()
                .verify();
    }

    @Test
    void save() {
        when(tarjetaRepository.save(getTarjetaEntity())).thenReturn(Mono.just(getTarjetaEntity()));
        when(tarjetaServiceImpl.create(getTarjeta())).thenReturn(Mono.just(getTarjeta()));

        Mono<Tarjeta> resultado = tarjetaServiceImpl.create(getTarjeta());

        StepVerifier.create(resultado)
                .expectNext(getTarjeta())
                .expectComplete()
                .verify();
    }

    @Test
    void findAllBy() {
        when(tarjetaRepository.findById(anyString())).thenReturn(Mono.just(getTarjetaEntity()));
        when(tarjetaServiceImpl.findAllBy(anyString())).thenReturn(Mono.just(getTarjeta()));

        Mono<Tarjeta> resultado = tarjetaServiceImpl.findAllBy("1");

        StepVerifier.create(resultado)
                .expectNext(getTarjeta())
                .expectComplete()
                .verify();
    }

    @Test
    void update() {
        when(tarjetaRepository.save(any())).thenReturn(Mono.just(getTarjetaEntity()));
        when(tarjetaServiceImpl.update(any())).thenReturn(Mono.just(getTarjeta()));

        Mono<Tarjeta> resultado = tarjetaServiceImpl.update(getTarjeta());

        StepVerifier.create(resultado)
                .expectNext(getTarjeta())
                .expectComplete()
                .verify();
    }

    @Test
    void deleteById() {
        when(tarjetaRepository.deleteById(anyString())).thenReturn(Mono.empty());
        when(tarjetaServiceImpl.deleteById(anyString())).thenReturn(Mono.empty());

        Mono<Void> resultado = tarjetaServiceImpl.deleteById("1");

        StepVerifier.create(resultado)
                .expectComplete()
                .verify();
    }

    public TarjetaEntity getTarjetaEntity(){
        return new TarjetaEntity("123823","87739916852124514", new Date(1994,03,17),"activo");
    }
    public Tarjeta getTarjeta(){
        return new Tarjeta("123823","87739916852124514", new Date(1994,03,17),"activo");
    }
}
