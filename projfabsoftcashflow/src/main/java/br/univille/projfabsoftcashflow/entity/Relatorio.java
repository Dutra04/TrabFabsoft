package br.univille.projfabsoftcashflow.entity;

import java.math.BigDecimal;
import java.util.Map;

public class Relatorio {
    private BigDecimal saldoTotal;
    private Map<String, BigDecimal> saldoPorCategoria;

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