import { Component, ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap';
import { Simulacao } from '../model/simulacao';
import { SimulacaoService } from '../service/simulacao.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-simulacao',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './simulacao.component.html',
  styleUrl: './simulacao.component.css',
  providers: [SimulacaoService, Router]
})
export class SimulacaoComponent {
  listaSimulacoes: Simulacao[] = [];

  constructor(
    private simulacaoService: SimulacaoService,
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['simulacoes/novo']);
  }

  ngOnInit() {
    this.simulacaoService.getSimulacoes().subscribe(
      simulacoes => {
        this.listaSimulacoes = simulacoes;
      }
    );
  }

  alterar(simulacao: Simulacao) {
    this.router.navigate(['simulacoes/alterar', simulacao.id]);
  }

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private simulacaoSelecionada!: Simulacao;

  abrirConfirmacao(simulacao: Simulacao) {
    this.simulacaoSelecionada = simulacao;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.simulacaoService.excluirSimulacao(this.simulacaoSelecionada.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.simulacaoService.getSimulacoes().subscribe(
          simulacoes => {
            this.listaSimulacoes = simulacoes;
          }
        );
      },
      erro => {
        console.error('Erro ao excluir simulação:', erro);
      }
    );
  }
}
