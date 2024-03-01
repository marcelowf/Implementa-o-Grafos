package br.com.tde.matriz_adjacências;

import br.com.tde.node.Node;

public class NodeMatrizDeAdjacencias extends Node{

	public NodeMatrizDeAdjacencias(String valorNode, boolean ponderado, boolean direcionado) {
		super(valorNode, ponderado, direcionado);
	}

    protected void adicionarRelacao(String valorDestino, int peso) {
    	
    }

    protected void removerRelacao(String valorDestino) {
    	
    }
}
