import { Injectable } from '@angular/core';
import { Transacao } from '../model/transacao';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TransacaoService {
  apiURL = "http://localhost:8080/api/v1/transacoes";

  constructor(private http: HttpClient) { }

  getTransacoes() {
    return this.http.get<Transacao[]>(this.apiURL);
  }

  saveTransacao(transacao: Transacao) {
    if (transacao.id) {
      return this.http.put(this.apiURL + '/' + transacao.id, transacao);
    }
    return this.http.post(this.apiURL, transacao);
  }

  getTransacaoById(id: any) {
    return this.http.get<Transacao>(this.apiURL + '/' + id);
  }

  excluirTransacao(id: any) {
    return this.http.delete<Transacao>(this.apiURL + '/' + id);
  }
}
