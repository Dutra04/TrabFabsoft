import { Component } from '@angular/core';
import { Relatorio } from '../model/relatorio';
import { RelatorioService } from '../service/relatorio.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-relatorio',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-relatorio.component.html',
  styleUrl: './form-relatorio.component.css',
  providers: [RelatorioService, Router]
})
export class FormRelatorioComponent {
    relatorio: Relatorio = new Relatorio();

    constructor(
      private relatorioService: RelatorioService,
      private router: Router,
      private activeRouter: ActivatedRoute
    ) {
        const id = this.activeRouter.snapshot.paramMap.get('id');
        if (id) {
          this.relatorioService.getRelatorioById(id).subscribe(relatorio => {
            this.relatorio = relatorio;
          });
        }
    }

    salvar() {
      this.relatorioService.saveRelatorio(this.relatorio)
        .subscribe(resultado => {
          this.router.navigate(['relatorios']);
        });
    }
}
