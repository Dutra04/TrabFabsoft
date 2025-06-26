import { Component, ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap';
import { Relatorio } from '../model/relatorio';
import { RelatorioService } from '../service/relatorio.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-relatorio',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './relatorio.component.html',
  styleUrl: './relatorio.component.css',
  providers: [RelatorioService, Router]
})
export class RelatorioComponent {
  listaRelatorios: Relatorio[] = [];

  constructor(
    private relatorioService: RelatorioService,
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['relatorios/novo']);
  }

  ngOnInit() {
    this.relatorioService.getRelatorios().subscribe(
      relatorios => {
        this.listaRelatorios = relatorios;
      }
    );
  }

  alterar(relatorio: Relatorio) {
    this.router.navigate(['relatorios/alterar', relatorio.id]);
  }

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private relatorioSelecionado!: Relatorio;

  abrirConfirmacao(relatorio: Relatorio) {
    this.relatorioSelecionado = relatorio;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.relatorioService.excluirRelatorio(this.relatorioSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.relatorioService.getRelatorios().subscribe(
          relatorios => {
            this.listaRelatorios = relatorios;
          }
        );
      },
      erro => {
        console.error('Erro ao excluir relatório:', erro);
      }
    );
  }
}
