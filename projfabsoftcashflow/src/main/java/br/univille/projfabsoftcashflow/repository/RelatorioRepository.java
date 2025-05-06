package br.univille.projfabsoftcashflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftcashflow.entity.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

}
