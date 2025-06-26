import { Simulacao } from "./simulacao";

export class Relatorio {
    id: number;
    saldoTotal: number;
    simulacao?: Simulacao | null;
    saldoPorCategoria: { [key: string]: number };
}
