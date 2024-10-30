package com.Cabrera.PNL.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "denuncias")
@EntityListeners(AuditingEntityListener.class)
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 150)
    private String ubicacion;

    @Column(length = 20)
    private String estado;

    @Column(length = 100)
    private String ciudadano;

    @Column(name= "telefono_ciudadano" , length = 15)
    private String telefonoCiudadano;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date fechaRegistro;
}
