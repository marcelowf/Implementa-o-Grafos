package br.com.tde.lista_adjacências;

public interface Grafo {
    boolean adicionarNode(String valorNode);
    boolean deletarNode(String valorNode);
    boolean adicionarRelacao(String valorOrigem, String valorDestino, int peso);
    boolean removerRelacao(String valorOrigem, String valorDestino);
    boolean verificarRelacao(String valorOrigem, String valorDestino);
    int calculoIndegree(String valorNode);
    int calculoOutdegree(String valorNode);
    int calculoDegree(String valorNode);
//    void definirPeso(String valorOrigem, String valorDestino, int peso);
//    double recuperarPeso(String valorOrigem, String valorDestino);
//    String toString();
    
//    void printNodes();
//    void printRelacoes();
}
