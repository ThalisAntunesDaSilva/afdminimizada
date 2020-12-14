package controler;

import java.util.ArrayList;
import java.util.List;
import model.Estado;

public class TransitionControler {

    private List<Estado> estado;
    private List<String> alfabeto;
    private Estado estadoInicial;
    private List<Estado> estadosFinais;
    private List<Estado> estadosAlcancaveis;
    private List<Estado> estadosMortos;
    private List<Estado> estadosInalcancaveis;

    public TransitionControler() {
        estado = new ArrayList<>();
        alfabeto = new ArrayList<>();
        estadosFinais = new ArrayList<>();
        estadosAlcancaveis = new ArrayList<>();
        estadosMortos = new ArrayList<>();
        estadosInalcancaveis = new ArrayList<>();
    }

    public List<Estado> getEstado() {
        return estado;
    }

    public List<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(List<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public List<Estado> getEstadosFinais() {
        return estadosFinais;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    public void setEstadosFinais(List<Estado> estadosFinais) {
        this.estadosFinais = estadosFinais;
    }

    private void emiteEstadoInicial() {
        for (Estado estado : estado) {
            if (estado.isStart()) {
                estadoInicial = estado;
            }
        }
    }

    private void emiteEstadosFinais() {
        for (Estado estado : estado) {
            if (estado.isEnd()) {
                estadosFinais.add(estado);
            }
        }
    }

    public boolean transicao(String[] palavra) {
        emiteEstadoInicial();
        emiteEstadosFinais();
        Estado estadoAtual = null;
        //i percorre as palavras do alfabeto
        for (int i = 0; i < palavra.length; i++) {
//Pega as palavras do alfaabeto e coloca no estado inicial
//se no alfabeto conter a palavra e ela estiver no inicio = 0, então cada estado que ele pegar da lista e esse estado
// for estado inicial o sistema reconhece que esse é o estado atual, onde inicia
            if (alfabeto.contains(palavra[i])) {
                if (i == 0) {
                    for (Estado estado : estado) {
                        if (estado.isStart()) {
                            estadoAtual = estado;
                        }
                    }
//Em transição o estado atual confere se tem um simbolo, entao ele transita para o proximo estado
//que o usuário solicitou   
                    if (estadoAtual.getTransition().get(palavra[i]) != null) {
                        estadoAtual = estadoAtual.getTransition().get(palavra[i]);
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        //Para finalizar se durante a transição chegar em um estado final com o alfabeto solicitado ele aceita
        if (estadosFinais.contains(estadoAtual)) {
            return true;

        } else {
            return false;
        }

    }
   //Adiociona estados incansaveis em uma lista
    public void inicializaEstadosInalcansaveis() {

        for (Estado e : estado) {
            estadosInalcancaveis.add(e);
        }
    }
   //pra todo estado que conter o simbolo, toda vez que transição tiver um simbolo
    //se na lista de alcansaveis nao tiver o estado que recebe o simbolo encontrado
    //então esse estado é um alncansavel e entra na lsita
    
  public void emiteEstadosAlcancaveis() {
        inicializaEstadosInalcansaveis();
        for (Estado estadO : estado) {
            for (String simbolo : alfabeto) {
                if (estadO.getTransition().get(simbolo) != null) {
                    if (!estadosAlcancaveis.contains(estadO.getTransition().get(simbolo))) {
                        estadosAlcancaveis.add(estadO.getTransition().get(simbolo));
                     } estadosInalcancaveis.remove(estadO.getTransition().get(simbolo));
                }
            }
        }
    }

    public void inicializaEstadoMorto() {
        for (Estado e : estado) {
            estadosMortos.add(e);
        }
    }
        public void emiteEstadoMorto() {
        inicializaEstadoMorto();
        estadosMortos.remove(estadoInicial);
        for (Estado e : estadosFinais) {
            estadosMortos.remove(e);
        }
        for (Estado estado : estado) {
            for (String simbolo : alfabeto) {

                if (estado.getTransition().get(simbolo) != null && estado.getTransition().get(simbolo) != estado) {
                    estadosMortos.remove(estado);
                }
            }
        }
        for (Estado e : estadosInalcancaveis) {
            estadosInalcancaveis.remove(e);
        }
    }

}
