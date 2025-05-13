# Fábrica de Software 2025/1

## Repositório dos alunos
- [Repos](https://gist.github.com/d4e37df9f6772173110603fc8bf90b84.git)

## Propostas de projeto

- Nome do sistema: Sistema de Gestão de Finanças
  - Registro de Transações: Adicionar entradas e saídas com valor, data, descrição e categoria
  - Categorização: Permitir que o usuário crie e gerencie categorias 
  - Relatórios: Exibir saldo total e gastos por categoria 
  - Armazenagem de Dados: Salvar os Dados em um arquivo 

<s>

## Livro Eng Software Moderna
[Eng. Soft Moderna - Requisitos](https://engsoftmoderna.info/cap3.html)

## Histórias de Usuário

- Como um **Usuário**, desejo cadastrar meus dados pessoais (nome, endereço, telefone, e-mail) para manter meu perfil atualizado.
- Como um **Usuário**, desejo registrar uma **Transação** informando valor, data, descrição e selecionar uma **Categoria** para controlar minhas finanças.
- Como um **Usuário**, desejo criar, editar e excluir **Categorias** para organizar melhor minhas transações.
- Como um **Usuário**, desejo visualizar uma lista de todas as minhas **Transações** para acompanhar meu histórico financeiro.
- Como um **Usuário**, desejo editar ou excluir uma **Transação** já registrada para corrigir informações ou remover lançamentos indevidos.
- Como um **Usuário**, desejo visualizar relatórios de saldo total e de gastos por **Categoria** para analisar minha situação financeira.
- Como um **Usuário**, desejo que meus dados e transações sejam salvos automaticamente e carregados ao abrir o sistema para não perder informações.
- Como um **Usuário**, desejo simular o impacto de um gasto extra em um mês específico para planejar melhor meu orçamento.

## Comandos do Git

### Instalação
[Git Bash](https://git-scm.com/downloads)

### Configuração inicial

```
git config --global user.name "NOME DO USUARIO NO GITHUB"
git config --global user.email "EMAIL DA CONTA DO GITHUB"
```
### Tipos de mensagens do commit

- feat: (new feature for the user, not a new feature for build script)
- fix: (bug fix for the user, not a fix to a build script)
- docs: (changes to the documentation)
- style: (formatting, missing semi colons, etc; no production code change)
- refactor: (refactoring production code, eg. renaming a variable)
- test: (adding missing tests, refactoring tests; no production code change)
- chore: (updating grunt tasks etc; no production code change)

### Commit e Push

```
git add .
git commit -m "tipo: o que foi feito"
git push -u origin main
```

### Ambiente de desenvolvimento JAVA
[Eclipse Adoptium](https://adoptium.net/)
[Microsoft OpenJDK](https://www.microsoft.com/openjdk)
[AWS CORRETTO](https://aws.amazon.com/pt/corretto/)
[VSCode](https://code.visualstudio.com/download)
[Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)


- JRE - Java Runtime Environment
   - Java Virtual Machine JVM 
     - java.exe / javaw.exe
- JDK - Java Development Kit
  - Compilar o java (javac.exe)
