package br.univille.projfabsoftcashflow.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float impactoGastoExtra;
    @Temporal(TemporalType.TIMESTAMP)    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date mesReferencia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getImpactoGastoExtra() {
        return impactoGastoExtra;
    }

    public void setImpactoGastoExtra(float impactoGastoExtra) {
        this.impactoGastoExtra = impactoGastoExtra;
    }

    public Date getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(Date mesReferencia) {
        this.mesReferencia = mesReferencia;
    }
}