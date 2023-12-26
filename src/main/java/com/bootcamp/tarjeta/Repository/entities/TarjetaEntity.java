package com.bootcamp.tarjeta.Repository.entities;

import com.bootcamp.tarjeta.model.entity.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "tarjeta")
public class TarjetaEntity {
    @Id
    private String id;
    private String numeroTarjeta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCaducidad;
    private String estadoTarjeta;

    public TarjetaEntity() {

    }
    public TarjetaEntity toTarjetaEntity(Tarjeta tarjeta) {
        TarjetaEntity tarjetaEntity = TarjetaEntity.builder().build();
        BeanUtils.copyProperties(tarjeta, tarjetaEntity);
        return tarjetaEntity;
    }
    public Tarjeta toTarjeta() {
        Tarjeta tarjeta = Tarjeta.builder().build();
        BeanUtils.copyProperties( this, tarjeta);
        return tarjeta;
    }
}
