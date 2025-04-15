package br.univille.projfabsoftcashflow.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Simulacao {
    private long id;
    private BigDecimal impactoGastoExtra;
    private LocalDate mesReferencia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getImpactoGastoExtra() {
        return impactoGastoExtra;
    }

    public void setImpactoGastoExtra(BigDecimal impactoGastoExtra) {
        this.impactoGastoExtra = impactoGastoExtra;
    }

    public LocalDate getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(LocalDate mesReferencia) {
        this.mesReferencia = mesReferencia;
    }
}