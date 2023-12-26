package com.bootcamp.tarjeta.infrastructure.controller;

import com.bootcamp.tarjeta.businees.TarjetaService;
import com.bootcamp.tarjeta.model.entity.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(TarjetaController.TARJETA)
public class TarjetaController {
    public static final String TARJETA = "/tarjeta";
    public static final String FINDALL = "/findAll";
    public static final String SAVE = "/save";
    public static final String FINDALLBY = "/findAllBy";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    @Autowired
    private TarjetaService tarjetaService;

    @RequestMapping(FINDALL)
    private Flux<Tarjeta> findAll() {
        return tarjetaService.findAll();
    }

    @PostMapping(SAVE)
    private Mono<Tarjeta> create(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.create(tarjeta);
    }

    @GetMapping(FINDALLBY)
    private Mono<Tarjeta> findAllBy(@RequestParam("id") String id) throws Exception{
        return tarjetaService.findAllBy(id);
    }

    @PutMapping(UPDATE)
    private Mono<Tarjeta> update(@RequestBody Tarjeta tarjeta){
        return tarjetaService.update(tarjeta);
    }

    @DeleteMapping(DELETE)
    private Mono<Void> deleteById(@RequestParam("id") String id){
        return tarjetaService.deleteById(id);
    }
}
