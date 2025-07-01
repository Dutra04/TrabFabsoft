import { Routes } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { FormClienteComponent } from './form-cliente/form-cliente.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { FormCategoriaComponent } from './form-categoria/form-categoria.component';
import { TransacaoComponent } from './transacao/transacao.component';
import { FormTransacaoComponent } from './form-transacao/form-transacao.component';
import { RelatorioComponent } from './relatorio/relatorio.component';
import { FormRelatorioComponent } from './form-relatorio/form-relatorio.component';
import { SimulacaoComponent } from './simulacao/simulacao.component';
import { FormSimulacaoComponent } from './form-simulacao/form-simulacao.component';
import { ClienteDetalhesComponent } from './cliente-detalhes/cliente-detalhes.component';

export const routes: Routes = [
    {path: 'clientes', component: ClienteComponent},
    {path: 'clientes/novo', component: FormClienteComponent},
    {path: 'clientes/alterar/:id', component: FormClienteComponent},
    {path: 'clientes/detalhes/:id', component: ClienteDetalhesComponent},
    
    {path: 'categorias', component: CategoriaComponent},
    {path: 'categorias/novo', component: FormCategoriaComponent},
    {path: 'categorias/alterar/:id', component: FormCategoriaComponent},

    {path: 'transacao', component: TransacaoComponent},
    {path: 'transacoes/novo', component: FormTransacaoComponent},
    {path: 'transacoes/alterar/:id', component: FormTransacaoComponent},

    {path: 'relatorios', component: RelatorioComponent},
    {path: 'relatorios/novo', component: FormRelatorioComponent},
    {path: 'relatorios/alterar/:id', component: FormRelatorioComponent},

    {path: 'simulacoes', component: SimulacaoComponent},
    {path: 'simulacoes/novo', component: FormSimulacaoComponent},
    {path: 'simulacoes/alterar/:id', component: FormSimulacaoComponent},
];
