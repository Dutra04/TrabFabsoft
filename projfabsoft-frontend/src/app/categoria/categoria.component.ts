import { Component, ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap';
import { Categoria } from '../model/categoria';
import { CategoriaService } from '../service/categoria.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categoria',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './categoria.component.html',
  styleUrl: './categoria.component.css',
  providers: [CategoriaService, Router]
})
export class CategoriaComponent {
  listaCategorias: Categoria[] = [];

  constructor(
    private categoriaService: CategoriaService,
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['categorias/novo']);
  }

  ngOnInit() {
    this.categoriaService.getCategorias().subscribe(
      categorias => {
        this.listaCategorias = categorias;
      }
    );
  }

  alterar(categoria: Categoria) {
    this.router.navigate(['categorias/alterar', categoria.id]);
  }

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private categoriaSelecionada!: Categoria;

  abrirConfirmacao(categoria: Categoria) {
    this.categoriaSelecionada = categoria;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.categoriaService.excluirCategoria(this.categoriaSelecionada.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.categoriaService.getCategorias().subscribe(
          categorias => {
            this.listaCategorias = categorias;
          }
        );
      },
      erro => {
        console.error('Erro ao excluir categoria:', erro);
      }
    );
  }
}
