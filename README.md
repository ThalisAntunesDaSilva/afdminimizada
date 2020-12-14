# Programa  que  Simula  um  AFD :computer: 

![Badge](https://img.shields.io/static/v1?label=Java&message=AFD&color=red&style=for-the-badge&logo=JAVA) 

> Status do projeto: concluído :heavy_check_mark:

@author Emanuelle Alves

@author Thalis Antunes

## Descrição

<p align="justify"> O Trabalho foi desenvolvido em java versão 8, utilizando o NetBeans IDE para implementar um programa  que  simula  um  Autômato  Finito  Determinıstico e permite reconhecer cadeias de entrada de uma determinada linguagem. O programa retorna o autômato minimizado, mostrando quais são os estados inalcançáveis e mortos.
Em outras palavras, dada uma especificação de um AFD, é possível minimizá-lo quando os estados inúteis são removidos e/ou a combinação de estados são equivalentes.</p>

<p align="justify">A entrada do AFD será a descrição formal dele, ou seja:</p>

- Alfabeto;
- Estados do autômato;
- Função de transiçao;
- Estado inicial;
- Conjunto de estados finais.

<p align="justify"> Após a leitura da entrada, o programa pode receber uma ou mais palavras e mostrar ́e aceita ou rejeitada pelo autômato.</p>

## Linux - como executar o programa sem o Netbeans compilando as classes pelo terminal?

```
O projeto não possui nenhum binário associado para execução. Para isso, você precisará compilar todos os códigos antes de executar a aplicação. 
Abra o terminal do linux, navegue até o diretório principal e executar os seguintes comandos:
```

``` 
$ cd src
$ javac br/ufla/dcc/lfa/automato/*.java
$ javac br/ufla/dcc/lfa/arquivo/*.java
$ javac br/ufla/dcc/lfa/principal/*.java
$ java br/ufla/dcc/lfa/principal/Main <descricao-afd> <arquivo-saida-tabela> <arquivo-saida-afd-minimizado> 
```
Após isto, é só verificar os arquivos de saída.

















