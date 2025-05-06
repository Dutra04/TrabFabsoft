package br.univille.projfabsoftcashflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoftcashflow.entity.Categoria;
import br.univille.projfabsoftcashflow.service.CategoriaService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias() {
        var listaCategorias = service.getAll();
        return new ResponseEntity<>(listaCategorias, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
        if (categoria == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(categoria);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> putCategoria(@PathVariable long id, @RequestBody Categoria categoria) {
        if (id <= 0 || categoria == null) {
            return ResponseEntity.badRequest().build();
        }

        var categoriaAntiga = service.getById(id);
        if (categoriaAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        categoriaAntiga.setNome(categoria.getNome());
        service.save(categoriaAntiga);
        return new ResponseEntity<>(categoriaAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> deleteCategoria(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        var categoriaExcluida = service.getById(id);
        if (categoriaExcluida == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(categoriaExcluida, HttpStatus.OK);
    }
}
