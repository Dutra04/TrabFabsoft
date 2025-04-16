package br.univille.projfabsoftcashflow.entity;

import java.math.BigDecimal;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    private BigDecimal saldoTotal;
    private Map<String, BigDecimal> saldoPorCategoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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