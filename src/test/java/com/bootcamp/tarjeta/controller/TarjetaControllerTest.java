package com.bootcamp.tarjeta.controller;

import com.bootcamp.tarjeta.businees.TarjetaService;
import com.bootcamp.tarjeta.infrastructure.controller.TarjetaController;
import com.bootcamp.tarjeta.model.entity.Tarjeta;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(TarjetaController.class)
class TarjetaControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private TarjetaService tarjetaService;

    @Test
    void findAll(){
        when(tarjetaService.findAll()).thenReturn(Flux.just(getTarjeta()));
        webTestClient.get()
                .uri("/tarjeta/findAll")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tarjeta.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void save(){
        when(tarjetaService.create(getTarjeta())).thenReturn(Mono.just(getTarjeta()));
        webTestClient.post()
                .uri("/tarjeta/save")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getTarjeta())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tarjeta.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void findAllBy(){
        when(tarjetaService.findAllBy("1")).thenReturn(Mono.just(getTarjeta()));
        webTestClient.get()
                .uri("/tarjeta/findAllBy?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tarjeta.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void update(){
        when(tarjetaService.update(getTarjeta())).thenReturn(Mono.just(getTarjeta()));
        webTestClient.put()
                .uri("/tarjeta/update")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getTarjeta())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tarjeta.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void deleteById() {
        when(tarjetaService.deleteById("1")).thenReturn(Mono.empty());
        webTestClient.delete()
                .uri("/tarjeta/delete?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }

    public Tarjeta getTarjeta(){
        return new Tarjeta("123823","87739916852124514", new Date(1994,03,17),"activo");
    }
}
