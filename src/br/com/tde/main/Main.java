package br.com.tde.main;

import br.com.tde.lista_adjacências.ListaDeAdjacencias;
import br.com.tde.matriz_adjacências.MatrizDeAdjacencias;

public class Main {

	public static void main(String[] args) {
		ListaDeAdjacencias lista = new ListaDeAdjacencias(true, true);

	    // Adiciona alguns nós
	    lista.adicionarNode("A");
	    lista.adicionarNode("B");
	    lista.adicionarNode("C");

	    // Adiciona algumas relações
	    lista.adicionarRelacao("A", "B", 1);
	    lista.adicionarRelacao("B", "C", 2);
	    lista.adicionarRelacao("C", "A", 3);
	    if(lista.verificarRelacao("A", "B")) {
	    	System.out.println("OK");
	    }
//	    lista.printNodes();
//	    lista.printRelacoes();
//	    
//	    lista.deletarNode("A");
//	    lista.removerRelacao("B", "C");
//
//	    lista.printNodes();
//	    lista.printRelacoes();
	}

	
//	public boolean DefinirEstrutura() {
//		private boolean Direcionado;
//		private boolean Ponderado;
//		private boolean PossuiPeso;
//		
//		
//		return true;
//	}
}
