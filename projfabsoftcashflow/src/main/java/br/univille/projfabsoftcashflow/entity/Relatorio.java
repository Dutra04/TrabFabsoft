package br.univille.projfabsoftcashflow.entity;

import java.math.BigDecimal;
import java.util.Map;

import jakarta.persistence.Entity;

@Entity
public class Relatorio {
    private Long id;
    private BigDecimal saldoTotal;
    private Map<String, BigDecimal> saldoPorCategoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Map<String, BigDecimal> getSaldoPorCategoria() {
        return saldoPorCategoria;
    }

    public void setSaldoPorCategoria(Map<String, BigDecimal> saldoPorCategoria) {
        this.saldoPorCategoria = saldoPorCategoria;
    }
}