package br.univille.projfabsoftcashflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoftcashflow.entity.Simulacao;
import br.univille.projfabsoftcashflow.service.SimulacaoService;

@RestController
@RequestMapping("/api/v1/simulacoes")
public class SimulacaoController {

    @Autowired
    private SimulacaoService service;

    @GetMapping
    public ResponseEntity<List<Simulacao>> getSimulacoes() {
        var listaSimulacoes = service.getAll();
        return new ResponseEntity<>(listaSimulacoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Simulacao> postSimulacao(@RequestBody Simulacao simulacao) {
        if (simulacao == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(simulacao);
        return new ResponseEntity<>(simulacao, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Simulacao> putSimulacao(@PathVariable long id, @RequestBody Simulacao simulacao) {
        if (id <= 0 || simulacao == null) {
            return ResponseEntity.badRequest().build();
        }

        var simulacaoAntiga = service.getById(id);
        if (simulacaoAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        simulacaoAntiga.setImpactoGastoExtra(simulacao.getImpactoGastoExtra());
        simulacaoAntiga.setMesReferencia(simulacao.getMesReferencia());

        service.save(simulacaoAntiga);
        return new ResponseEntity<>(simulacaoAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Simulacao> deleteSimulacao(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        var simulacaoExcluida = service.getById(id);
        if (simulacaoExcluida == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(simulacaoExcluida, HttpStatus.OK);
    }
}
