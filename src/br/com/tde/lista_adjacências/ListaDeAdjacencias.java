package br.com.tde.lista_adjacências;

import java.util.ArrayList;
import java.util.List;

import br.com.tde.node.Node;

public class ListaDeAdjacencias implements Grafo {
    private boolean direcionado;
    private boolean ponderado;
    private List<Node> nodes;

    public ListaDeAdjacencias(boolean ponderado, boolean direcionado) {
        this.direcionado = direcionado;
        this.ponderado = ponderado;
        this.nodes = new ArrayList<>();
    }

    public boolean adicionarNode(String valorNode) {
        Node nodeParaAdicionar = getNodeByValue(valorNode);

        if (nodeParaAdicionar == null) {
            Node novoNode = new NodeListaDeAdjacencias(valorNode, ponderado, direcionado);

            nodes.add(novoNode);
            return true;
        }
        return false;
    }

    public boolean deletarNode(String valorNode) {
        Node nodeParaRemover = getNodeByValue(valorNode);

        if (nodeParaRemover != null) {
            nodes.remove(nodeParaRemover);

            for (Node node : nodes) {
                ((NodeListaDeAdjacencias) node).removerRelacao(valorNode);
            }

            return true;
        }
        return false;
    }


    public boolean adicionarRelacao(String valorOrigem, String valorDestino, int peso) {
        Node origem = getNodeByValue(valorOrigem);
        Node destino = getNodeByValue(valorDestino);

        if (origem != null && destino != null) {
            ((NodeListaDeAdjacencias) origem).adicionarRelacao(valorDestino, peso);

            if (!direcionado) {
                ((NodeListaDeAdjacencias) destino).adicionarRelacao(valorOrigem, peso);
            }
            return true;
        }
        return false;
    }

    public boolean removerRelacao(String valorOrigem, String valorDestino) {
        Node origem = getNodeByValue(valorOrigem);
        Node destino = getNodeByValue(valorDestino);

        if (origem != null && destino != null) {
            ((NodeListaDeAdjacencias) origem).removerRelacao(valorDestino);

            if (!direcionado) {
                ((NodeListaDeAdjacencias) destino).removerRelacao(valorOrigem);
            }
            return true;
        }
        return false;
    }

    public boolean verificarRelacao(String valorOrigem, String valorDestino) {
        Node origem = getNodeByValue(valorOrigem);
        Node destino = getNodeByValue(valorDestino);
        
        if (origem != null && destino != null) {
            return ((NodeListaDeAdjacencias) origem).relacaoExistente(valorDestino);
        }
        return false;
    }

    public int calculoIndegree(String valorNode) {
        Node node = getNodeByValue(valorNode);
        
        if (node != null && direcionado) {
            int indegree = 0;
            for (Node n : nodes) {
                if (n != node) {
                    if (((NodeListaDeAdjacencias) n).relacaoExistente(valorNode)) {
                        indegree++;
                    }
                }
            }
            return indegree;
        }
        return -1;
    }

    public int calculoOutdegree(String valorNode) {
        Node node = getNodeByValue(valorNode);
        
        if (node != null && direcionado) {
            return ((NodeListaDeAdjacencias) node).getRelacoes().size();
        }
        return -1;
    }

    public int calculoDegree(String valorNode) {
        int indegree = calculoIndegree(valorNode);
        int outdegree = calculoOutdegree(valorNode);
        
        if (indegree != -1 && outdegree != -1) {
            return indegree + outdegree;
        }
        return -1;
    }

    private Node getNodeByValue(String valorNode) {
        for (Node node : nodes) {
            if (node.getValorNode().equals(valorNode)) {
                return node;
            }
        }
        return null;
    }

	public void printNodes() {
		for (Node node : nodes) {
			System.out.println("Node: " + node.getValorNode());
		}
	}

	public void printRelacoes() {
		for (Node node : nodes) {
			System.out.println("Node: " + node.getValorNode());
			Object relacoes = ((NodeListaDeAdjacencias) node).getRelacoes();
			System.out.println(relacoes);
		}
	}
}
