package br.univille.projfabsoftcashflow.service;

import java.util.List;

import br.univille.projfabsoftcashflow.entity.Transacao;

public interface TransacaoService {
    Transacao save(Transacao transacao);
    List<Transacao> getAll();
    Transacao getById(Long id);
    Transacao delete(Long id);
}
