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
        //i percorre de acordo com o tamanho da palavra
        for (int i = 0; i < palavra.length; i++) {
            
//Pega a as palavras do alfaabeto e coloca no estado inicial
//se no alfabeto conter a palavra na posição que i estiver
            if (alfabeto.contains(palavra[i])) {
                //se i estiver no início  estiver no inicio, 0
                if (i == 0) {
                    //se um estado for igual a estado criado
                    for (Estado estado : estado) {
                        //se estado se iniciou,o estadoAtual é o estado criado  
                        if (estado.isStart()) {
                            estadoAtual = estado;
                        }
                    }
                    
                    //
                    //se estado atual pegando a transicao Map<String, Estado> getTransition() pega a palavra for diferente de null 
                    //então estado atual é igual a estado atual pegando transição pegando a palavra
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
        //Se nessa transição o estado final conter o estado atual retorna true
        if (estadosFinais.contains(estadoAtual)) {
            return true;
            
        } else {
            return false;
        }
        

    }
public void emiteEstadosAlcancaveis(){
     inicializaEstadosInalcancaveis();   
    for(Estado estadO: estado){
            for(String simbolo: alfabeto){
                if(estadO.getTransition().get(simbolo) != null){
                  if(!estadosAlcancaveis.contains(estadO.getTransition().get(simbolo))){
                    estadosAlcancaveis.add(estadO.getTransition().get(simbolo));
               estadosInalcancaveis.remove(estadO.getTransition().get(simbolo));
                
                  }}
            }
        }
    }
public void inicializaEstadoMorto(){
    for(Estado e: estado){
        estadosMortos.add(e);
    }
}

public void inicializaEstadosInalcancaveis(){
    
    for(Estado e: estado){
        estadosInalcancaveis.add(e);
    }
}
public void emiteEstadoMorto(){
    inicializaEstadoMorto();
    estadosMortos.remove(estadoInicial);
    for(Estado e: estadosFinais){
        estadosMortos.remove(e);
        }
    for(Estado estado: estado){
        for(String simbolo: alfabeto){
       
            if(estado.getTransition().get(simbolo) != null && estado.getTransition().get(simbolo) != estado){
                    estadosMortos.remove(estado);}
        }
    }
     for(Estado e: estadosInalcancaveis){
        estadosInalcancaveis.remove(e);
        }
}




}
