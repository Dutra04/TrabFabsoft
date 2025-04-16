package br.univille.projfabsoftcashflow.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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