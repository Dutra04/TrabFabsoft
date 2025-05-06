package br.univille.projfabsoftcashflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftcashflow.entity.Simulacao;
import br.univille.projfabsoftcashflow.repository.SimulacaoRepository;
import br.univille.projfabsoftcashflow.service.SimulacaoService;

@Service
public class SimulacaoServiceImpl implements SimulacaoService {

    @Autowired
    private SimulacaoRepository repository;

    @Override
    public Simulacao save(Simulacao simulacao) {
        return repository.save(simulacao);
    }

    @Override
    public List<Simulacao> getAll() {
        return repository.findAll();
    }

    @Override
    public Simulacao getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Simulacao delete(Long id) {
        Simulacao simulacao = getById(id);
        if (simulacao != null) {
            repository.deleteById(id);
        }
        return simulacao;
    }
}
