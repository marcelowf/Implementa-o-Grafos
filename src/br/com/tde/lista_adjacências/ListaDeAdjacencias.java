package br.com.tde.lista_adjacências;

import java.util.ArrayList;
import java.util.List;

import br.com.tde.node.Node;

public class ListaDeAdjacencias {
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
			for (Node node : nodes) {
				if (node != nodeParaRemover) {
					((NodeListaDeAdjacencias) node).removerRelacao(valorNode);
				}
			}
			nodes.remove(nodeParaRemover);
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
			((NodeListaDeAdjacencias) origem).relacaoExistente(valorDestino);
			return true;
		}
		return false;
	}

	public int CalculoIndegree(String valorNode) {
		return -1;
	}

	public int CalculoOutdegree(String valorNode) {
		return -1;
	}

	public int CalculoDegree(String valorNode) {
		return -1;
	}

	public boolean definirAtualizarPeso(String valorOrigem, String valorDestino) {
		return true;
	}

	public double RecuperarPeso(String valorOrigem, String valorDestino) {
		return -1.0;
	}

	// plotar

	private Node getNodeByValue(String valorNode) {
		for (Node node : nodes) {
			if (node.getValorNode().equals(valorNode)) {
				return node;
			}
		}
		return null;
	}

//	public void printNodes() {
//		for (Node node : nodes) {
//			System.out.println("Node: " + node.getValorNode());
//		}
//	}
//
//	public void printRelacoes() {
//		for (Node node : nodes) {
//			System.out.println("Node: " + node.getValorNode());
//			Object relacoes = ((NodeListaDeAdjacencias) node).getRelacoes();
//			System.out.println(relacoes);
//		}
//	}
}
