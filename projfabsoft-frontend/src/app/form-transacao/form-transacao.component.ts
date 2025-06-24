import { Component } from '@angular/core';
import { Transacao } from '../model/transacao';
import { TransacaoService } from '../service/transacao.service';
import { Cliente } from '../model/cliente';
import { Categoria } from '../model/categoria';
import { ClienteService } from '../service/cliente.service';
import { CategoriaService } from '../service/categoria.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-transacao',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-transacao.component.html',
  styleUrl: './form-transacao.component.css',
  providers: [TransacaoService, ClienteService, CategoriaService, Router]
})
export class FormTransacaoComponent {
    transacao: Transacao = new Transacao();
    listaClientes: Cliente[] = [];
    listaCategorias: Categoria[] = [];

    constructor(
      private transacaoService: TransacaoService,
      private clienteService: ClienteService,
      private categoriaService: CategoriaService,
      private router: Router,
      private activeRouter: ActivatedRoute
    ) {
        const id = this.activeRouter.snapshot.paramMap.get('id');
        if (id) {
          this.transacaoService.getTransacaoById(id).subscribe(transacao => {
            this.transacao = transacao;
          });
        }

        this.clienteService.getClientes().subscribe(clientes => {
          this.listaClientes = clientes;
        });

        this.categoriaService.getCategorias().subscribe(categorias => {
          this.listaCategorias = categorias;
        });
    }

    salvar() {
      this.transacaoService.saveTransacao(this.transacao)
        .subscribe(resultado => {
          this.router.navigate(['transacoes']);
        });
    }
}
