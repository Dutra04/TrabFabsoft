package br.univille.projfabsoftcashflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoftcashflow.entity.Relatorio;
import br.univille.projfabsoftcashflow.service.RelatorioService;

@RestController
@RequestMapping("/api/v1/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    @GetMapping
    public ResponseEntity<List<Relatorio>> getRelatorios() {
        var listaRelatorios = service.getAll();
        return new ResponseEntity<>(listaRelatorios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Relatorio> postRelatorio(@RequestBody Relatorio relatorio) {
        if (relatorio == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(relatorio);
        return new ResponseEntity<>(relatorio, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> putRelatorio(@PathVariable long id, @RequestBody Relatorio relatorio) {
        if (id <= 0 || relatorio == null) {
            return ResponseEntity.badRequest().build();
        }

        var relatorioAntigo = service.getById(id);
        if (relatorioAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        relatorioAntigo.setSaldoTotal(relatorio.getSaldoTotal());
        relatorioAntigo.setSaldoPorCategoria(relatorio.getSaldoPorCategoria());
        relatorioAntigo.setSimulacao(relatorio.getSimulacao());

        service.save(relatorioAntigo);
        return new ResponseEntity<>(relatorioAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Relatorio> deleteRelatorio(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        var relatorioExcluido = service.getById(id);
        if (relatorioExcluido == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(relatorioExcluido, HttpStatus.OK);
    }
}
