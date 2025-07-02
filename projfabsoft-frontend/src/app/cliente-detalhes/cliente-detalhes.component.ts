import { Component, ElementRef, ViewChild } from '@angular/core';
import { ClienteService } from '../service/cliente.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Cliente } from '../model/cliente';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import * as bootstrap from 'bootstrap';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cliente-detalhes',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './cliente-detalhes.component.html',
  styleUrl: './cliente-detalhes.component.css',
  providers: [ClienteService, Router]
})
export class ClienteDetalhesComponent {
  cliente: Cliente;

  tarefaRascunho: string;

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;


  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {
    const id = this.activeRouter.snapshot.paramMap.get('id');
    if (id) {
      this.clienteService.getClienteById(id).subscribe(cliente => {
        this.cliente = cliente;
      });
    }
  }


  adicionarTarefa() {
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharTarefa() {
    this.modal.hide();
  }

  confirmarTarefa() {
    this.cliente.tarefas.push(this.tarefaRascunho)
    this.tarefaRascunho = ""

    console.log(this.cliente.tarefas)

    this.clienteService.saveCliente(this.cliente)
      .subscribe(resultado => {

      });

    this.modal.hide();
  }

  excluirTarefa(index: number) {
    if(index > -1) {
      this.cliente.tarefas.splice(index, 1);
    }
    
    this.clienteService.saveCliente(this.cliente)
    .subscribe(resultado => {

    });
  }

}
