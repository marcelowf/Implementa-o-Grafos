package br.com.tde.node;

public class Node {
    private String valorNode;
    private boolean ponderado;
    private boolean direcionado;

    public Node(String valorNode, boolean ponderado, boolean direcionado) {
        this.valorNode = valorNode;
        this.ponderado = ponderado;
        this.direcionado = direcionado;
    }

    public String getValorNode() {
        return valorNode;
    }

    public boolean getPonderado() {
        return ponderado;
    }

    public boolean getDirecionado() {
        return direcionado;
    }

    public void setValorNode(String valorNode) {
        this.valorNode = valorNode;
    }
}