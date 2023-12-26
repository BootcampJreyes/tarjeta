package com.bootcamp.tarjeta.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Tarjeta {
    @Id
    private String id;
    private String numeroTarjeta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCaducidad;
    private String estadoTarjeta;
}
