import { Component } from '@angular/core';
import { Categoria } from '../model/categoria';
import { CategoriaService } from '../service/categoria.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-categoria',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-categoria.component.html',
  styleUrl: './form-categoria.component.css',
  providers: [CategoriaService, Router]
})
export class FormCategoriaComponent {
    categoria: Categoria = new Categoria();

    constructor(
      private categoriaService: CategoriaService,
      private router: Router,
      private activeRouter: ActivatedRoute
    ) {
        const id = this.activeRouter.snapshot.paramMap.get('id');
        if (id) {
          this.categoriaService.getCategoriaById(id).subscribe(categoria => {
            this.categoria = categoria;
          });
        }
    }

    salvar() {
      this.categoriaService.saveCategoria(this.categoria)
        .subscribe(resultado => {
          this.router.navigate(['categorias']);
        });
    }
}
