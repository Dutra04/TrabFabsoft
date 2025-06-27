import { Component } from '@angular/core';
import { Simulacao } from '../model/simulacao';
import { SimulacaoService } from '../service/simulacao.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-simulacao',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-simulacao.component.html',
  styleUrl: './form-simulacao.component.css',
  providers: [SimulacaoService, Router]
})
export class FormSimulacaoComponent {
    simulacao: Simulacao = new Simulacao();

    constructor(
      private simulacaoService: SimulacaoService,
      private router: Router,
      private activeRouter: ActivatedRoute
    ) {
        const id = this.activeRouter.snapshot.paramMap.get('id');
        if (id) {
          this.simulacaoService.getSimulacaoById(id).subscribe(simulacao => {
            this.simulacao = simulacao;
          });
        }
    }

    salvar() {
      this.simulacaoService.saveSimulacao(this.simulacao)
        .subscribe(resultado => {
          this.router.navigate(['simulacoes']);
        });
    }
}
