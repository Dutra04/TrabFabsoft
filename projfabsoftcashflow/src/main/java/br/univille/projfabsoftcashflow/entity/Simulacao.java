package br.univille.projfabsoftcashflow.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Simulacao {
    private BigDecimal impactoGastoExtra;
    private LocalDate mesReferencia;

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