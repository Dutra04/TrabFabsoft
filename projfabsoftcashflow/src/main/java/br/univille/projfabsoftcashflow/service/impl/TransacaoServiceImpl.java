package br.univille.projfabsoftcashflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftcashflow.entity.Transacao;
import br.univille.projfabsoftcashflow.repository.TransacaoRepository;
import br.univille.projfabsoftcashflow.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Override
    public Transacao save(Transacao transacao) {
        return repository.save(transacao);
    }

    @Override
    public List<Transacao> getAll() {
        return repository.findAll();
    }

    @Override
    public Transacao getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Transacao delete(Long id) {
        Transacao transacao = getById(id);
        if (transacao != null) {
            repository.deleteById(id);
        }
        return transacao;
    }
}
