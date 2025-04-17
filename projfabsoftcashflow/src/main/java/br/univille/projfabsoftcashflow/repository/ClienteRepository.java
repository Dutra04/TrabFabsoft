package br.univille.projfabsoftcashflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftcashflow.entity.Cliente;

@Repository
public interface ClienteRepository
    extends JpaRepository<Cliente,Long> {
        
}
