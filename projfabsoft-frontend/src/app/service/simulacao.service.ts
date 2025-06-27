import { Injectable } from '@angular/core';
import { Simulacao } from '../model/simulacao';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SimulacaoService {
  apiURL = "http://localhost:8080/api/v1/simulacoes";

  constructor(private http: HttpClient) { }

  getSimulacoes() {
    return this.http.get<Simulacao[]>(this.apiURL);
  }

  saveSimulacao(simulacao: Simulacao) {
    if (simulacao.id) {
      return this.http.put(this.apiURL + '/' + simulacao.id, simulacao);
    }
    return this.http.post(this.apiURL, simulacao);
  }

  getSimulacaoById(id: any) {
    return this.http.get<Simulacao>(this.apiURL + '/' + id);
  }

  excluirSimulacao(id: any) {
    return this.http.delete<Simulacao>(this.apiURL + '/' + id);
  }
}
