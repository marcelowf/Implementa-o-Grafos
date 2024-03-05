package br.com.tde.matriz_adjacências;

import br.com.tde.node.Node;

public class NodeMatrizDeAdjacencias extends Node {
	private int[][] matrizAdjacencias;
	private String[] nodes;

	public NodeMatrizDeAdjacencias(String valorNode, boolean ponderado, boolean direcionado, int tamanho) {
		super(valorNode, ponderado, direcionado);
		this.matrizAdjacencias = new int[tamanho][tamanho];
		this.nodes = new String[tamanho];

		for (int i = 0; i < tamanho; i++) {
			nodes[i] = "";
		}
	}

	public void adicionarRelacao(String valorOrigem, String valorDestino, int peso) {
		int origem = encontrarIndiceNode(valorOrigem);
		int destino = encontrarIndiceNode(valorDestino);

		if (origem != -1 && destino != -1) {
			if (getPonderado()) {
				matrizAdjacencias[origem][destino] = peso;
			} else {
				matrizAdjacencias[origem][destino] = 1;
			}
		}
	}

	public void removerRelacao(String valorOrigem, String valorDestino) {
		int origem = encontrarIndiceNode(valorOrigem);
		int destino = encontrarIndiceNode(valorDestino);

		if (origem != -1 && destino != -1) {
			matrizAdjacencias[origem][destino] = -1;
		}
	}

	public int getPesoRelacao(String valorOrigem, String valorDestino) {
		int origem = encontrarIndiceNode(valorOrigem);
		int destino = encontrarIndiceNode(valorDestino);

		if (origem != -1 && destino != -1) {
			return matrizAdjacencias[origem][destino];
		}
		return -1;
	}

	private int encontrarIndiceNode(String valorNode) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].equals(valorNode)) {
				return i;
			}
		}
		return -1;
	}
}
