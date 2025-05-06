package br.univille.projfabsoftcashflow.service;

import java.util.List;

import br.univille.projfabsoftcashflow.entity.Simulacao;

public interface SimulacaoService {
    Simulacao save(Simulacao simulacao);
    List<Simulacao> getAll();
    Simulacao getById(Long id);
    Simulacao delete(Long id);
}
