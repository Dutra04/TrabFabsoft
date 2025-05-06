package br.univille.projfabsoftcashflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoftcashflow.entity.Transacao;
import br.univille.projfabsoftcashflow.service.TransacaoService;

@RestController
@RequestMapping("/api/v1/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public ResponseEntity<List<Transacao>> getTransacoes() {
        var listaTransacoes = service.getAll();
        return new ResponseEntity<>(listaTransacoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transacao> postTransacao(@RequestBody Transacao transacao) {
        if (transacao == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(transacao);
        return new ResponseEntity<>(transacao, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> putTransacao(@PathVariable long id, @RequestBody Transacao transacao) {
        if (id <= 0 || transacao == null) {
            return ResponseEntity.badRequest().build();
        }

        var transacaoAntiga = service.getById(id);
        if (transacaoAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        transacaoAntiga.setValor(transacao.getValor());
        transacaoAntiga.setData(transacao.getData());
        transacaoAntiga.setDescricao(transacao.getDescricao());
        transacaoAntiga.setCliente(transacao.getCliente());
        transacaoAntiga.setCategoria(transacao.getCategoria());

        service.save(transacaoAntiga);
        return new ResponseEntity<>(transacaoAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transacao> deleteTransacao(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        var transacaoExcluida = service.getById(id);
        if (transacaoExcluida == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(transacaoExcluida, HttpStatus.OK);
    }
}
