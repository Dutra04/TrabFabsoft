package br.univille.projfabsoftcashflow.service;

import java.util.List;

import br.univille.projfabsoftcashflow.entity.Categoria;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    List<Categoria> getAll();
    Categoria getById(Long id);
    Categoria delete(Long id);
}