import { Cliente } from './cliente';
import { Categoria } from './categoria';

export class Transacao {
    id: number;
    valor: number;
    data: Date;
    descricao: string;
    cliente: Cliente;
    categoria: Categoria;
}
