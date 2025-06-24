import { Component, ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap';
import { Transacao } from '../model/transacao';
import { TransacaoService } from '../service/transacao.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transacao',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './transacao.component.html',
  styleUrl: './transacao.component.css',
  providers: [TransacaoService, Router]
})
export class TransacaoComponent {
  listaTransacoes: Transacao[] = [];

  constructor(
    private transacaoService: TransacaoService,
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['transacoes/novo']);
  }

  ngOnInit() {
    this.transacaoService.getTransacoes().subscribe(
      transacoes => {
        this.listaTransacoes = transacoes;
      }
    );
  }

  alterar(transacao: Transacao) {
    this.router.navigate(['transacoes/alterar', transacao.id]);
  }

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private transacaoSelecionada!: Transacao;

  abrirConfirmacao(transacao: Transacao) {
    this.transacaoSelecionada = transacao;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.transacaoService.excluirTransacao(this.transacaoSelecionada.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.transacaoService.getTransacoes().subscribe(
          transacoes => {
            this.listaTransacoes = transacoes;
          }
        );
      },
      erro => {
        console.error('Erro ao excluir transação:', erro);
      }
    );
  }
}
