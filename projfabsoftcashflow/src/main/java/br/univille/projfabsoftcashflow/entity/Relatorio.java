package br.univille.projfabsoftcashflow.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Map;
import jakarta.persistence.ElementCollection;

@Entity
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    private float saldoTotal;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Simulacao simulacao;
    @ElementCollection
    private Map<String, Float> saldoPorCategoria;

    public Simulacao getSimulacao() {
        return simulacao;
    }

    public void setSimulacao(Simulacao simulacao) {
        this.simulacao = simulacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(float saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Map<String, Float> getSaldoPorCategoria() {
        return saldoPorCategoria;
    }

    public void setSaldoPorCategoria(Map<String, Float> saldoPorCategoria) {
        this.saldoPorCategoria = saldoPorCategoria;
    }
}