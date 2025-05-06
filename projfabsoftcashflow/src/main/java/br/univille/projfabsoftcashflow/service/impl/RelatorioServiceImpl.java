package br.univille.projfabsoftcashflow.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftcashflow.entity.Relatorio;
import br.univille.projfabsoftcashflow.repository.RelatorioRepository;
import br.univille.projfabsoftcashflow.service.RelatorioService;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    @Override
    public Relatorio save(Relatorio relatorio) {
        return repository.save(relatorio);
    }

    @Override
    public List<Relatorio> getAll() {
        return repository.findAll();
    }

    @Override
    public Relatorio getById(Long id) {
        Optional<Relatorio> retorno = repository.findById(id);
        return retorno.orElse(null);
    }

    @Override
    public Relatorio delete(Long id) {
        Relatorio relatorio = getById(id);
        if (relatorio != null) {
            repository.deleteById(id);
        }
        return relatorio;
    }
}
