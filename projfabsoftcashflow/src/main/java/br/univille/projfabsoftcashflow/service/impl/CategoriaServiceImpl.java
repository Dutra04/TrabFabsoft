package br.univille.projfabsoftcashflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftcashflow.entity.Categoria;
import br.univille.projfabsoftcashflow.repository.CategoriaRepository;
import br.univille.projfabsoftcashflow.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public List<Categoria> getAll() {
        return repository.findAll();
    }

    @Override
    public Categoria getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Categoria delete(Long id) {
        Categoria categoria = getById(id);
        if (categoria != null) {
            repository.deleteById(id);
        }
        return categoria;
    }
}
