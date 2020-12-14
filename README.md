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
## Como Utilizar a aplicação
1. Adicione um estado no botão Add estado
2. Digite um símbolo e clique no botão Add símbolo
3. Digite seu estado inicial e clique em ok
4. Digite seus estados finais e clique em ok
5. Digite seu estado atual 
6. Digite o símbolo do alfabeto que ira transitar 
7. Digite o estado em que o símbolo irá parar
8. Salve a transição no botão Salvar transição 
9. Assim salve o automato
10. Agora ele está pronto para testar

## Testando palavras
1. Digite a palavra que deseja, tem mais de 1 caractere, deve-se digitar "," para separar.
Ex. a,a,b,b
2. E clique em Ok
3. Você pode inserir um arquivo .txt colocando o caminho onde esse arquivo está inserido em sua máquina com a palavra que deseja, essa entrada está limitada a apenas uma.
4. Clique em arquivo 
5. O resultado irá aparecer em "resultado"

















