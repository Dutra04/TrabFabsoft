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
- Como um Usuário, eu gostaria de registrar os meus dados do como: nome, endereço, telefone, email
- Como um Usuário, eu gostaria de registrar os dados de Transações como: valores de entradas, valores de saídas, data, descrição e categoria
- Como um Usuário, eu gostaria de criar e gerenciar as categorias
- Como um Usuário, eu gostaria extrair relatório do saldo total
- Como um Usuário, eu gostaria de visualizar todas as transações registradas em uma lista
- Como um Usuário, eu gostaria de editar ou excluir uma transação já registrada
- Como um Usuário, eu gostaria de ver o saldo detalhado por categoria em um relatório
- Como um Usuário, eu gostaria de carregar os dados salvos ao abrir o programa
- Como um Usuário, eu gostaria de simular o impacto de um gasto extra no meu saldo em um mês específico

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
