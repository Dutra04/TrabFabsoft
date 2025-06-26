import { Injectable } from '@angular/core';
import { Relatorio } from '../model/relatorio';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RelatorioService {
  apiURL = "http://localhost:8080/api/v1/relatorios";

  constructor(private http: HttpClient) { }

  getRelatorios() {
    return this.http.get<Relatorio[]>(this.apiURL);
  }

  saveRelatorio(relatorio: Relatorio) {
    if (relatorio.id) {
      return this.http.put(this.apiURL + '/' + relatorio.id, relatorio);
    }
    return this.http.post(this.apiURL, relatorio);
  }

  getRelatorioById(id: any) {
    return this.http.get<Relatorio>(this.apiURL + '/' + id);
  }

  excluirRelatorio(id: any) {
    return this.http.delete<Relatorio>(this.apiURL + '/' + id);
  }
}
