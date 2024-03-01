package br.com.tde.lista_adjacências;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAdjacencias {
    private boolean direcionado;
    private boolean ponderado;
    private List<Node> nodes;

    public ListaDeAdjacencias(boolean direcionado, boolean ponderado, boolean possuiPeso) {
        this.direcionado = direcionado;
        this.ponderado = ponderado;
        this.nodes = new ArrayList<>();
    }

    public boolean getDirecionado() {
        return direcionado;
    }

    public boolean getPonderado() {
        return ponderado;
    }

    public boolean adicionarNode(String valorNode) {
        Node nodeParaAdicionar = getNodeByValue(valorNode);

        if (nodeParaAdicionar == null) {
            nodes.add(nodeParaAdicionar);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletarNode(String valorNode) {
        Node nodeParaDeletar = getNodeByValue(valorNode);
        
        if (nodeParaDeletar != null) {
            nodes.remove(nodeParaDeletar);
            return true;
        } else {
            return false;
        }
    }

    public boolean adicionarRelacao(String valorOrigem, String valorDestino, int peso) {
        Node nodeOrigem = getNodeByValue(valorOrigem);
        Node nodeDestino = getNodeByValue(valorDestino);
        
        if (nodeOrigem == null || nodeDestino == null) {
            System.out.println("Nó de origem ou destino não encontrado.");
            return false;
        }
        
        if (direcionado) {
            nodeOrigem.adicionarRelacao(valorDestino, peso, ponderado);
        }
        else {
            nodeOrigem.adicionarRelacao(valorDestino, peso, ponderado);
            nodeDestino.adicionarRelacao(valorOrigem, peso, ponderado);
        }
        return true;
    }

    private boolean removerRelacao () {
    	return true;
    }
    
    private Node getNodeByValue(String valorNode) {
    	for (Node node: nodes) {
    		if (node.getValorNode() == valorNode) {
    			return node;
    		}
    	}
    	return null;
    }
}
