package br.com.tde.lista_adjacências;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.tde.node.Node;

public class NodeListaDeAdjacencias extends Node {
    private Map<String, Integer> relacoesPonderada;
    private List<String> relacoesNaoPonderada;

    public NodeListaDeAdjacencias(String valorNode, boolean ponderado, boolean direcionado) {
        super(valorNode, ponderado, direcionado);
        iniciarLista();
    }

    protected Object getRelacoes() {
        if (getPonderado()) {
            return relacoesPonderada;
        } else {
            return relacoesNaoPonderada;
        }
    }

    protected void adicionarRelacao(String valorDestino, int peso) {
    	if (!relacaoExistente(valorDestino)) {
            if (getPonderado()) {
                relacoesPonderada.put(valorDestino, peso);
            } else {
                relacoesNaoPonderada.add(valorDestino);
            }
    	}
    }

    protected void removerRelacao(String valorDestino) {
    	if (relacaoExistente(valorDestino)) {
	        if (getPonderado()) {
	            relacoesPonderada.remove(valorDestino);
	        } else {
	            relacoesNaoPonderada.remove(valorDestino);
	        }
    	}
    }

    private boolean relacaoExistente(String valorDestino) {
    	if (getPonderado()) {
    		return relacoesPonderada.containsKey(valorDestino);
    	}
    	return relacoesNaoPonderada.contains(valorDestino);
    }
    
    private void iniciarLista() {
        if (getPonderado()) {
            this.relacoesPonderada = new HashMap<>();
            this.relacoesNaoPonderada = null;
        } else {
            this.relacoesNaoPonderada = new ArrayList<>();
            this.relacoesPonderada = null;
        }
    }
}
