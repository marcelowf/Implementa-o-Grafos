package br.com.tde.lista_adjacências;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Node {
    private String valorNode;
    private Map<String, Integer> relacoesComPeso;
    private List<String> relacoesSemPeso;

    public Node(String valorNode, boolean ponderado) {
        this.valorNode = valorNode;
        
        if (ponderado) {
            this.relacoesComPeso = new HashMap<>();
            this.relacoesSemPeso = null;
        } else {
            this.relacoesSemPeso = new ArrayList<>();
            this.relacoesComPeso = null;
        }
    }

    public String getValorNode() {
        return valorNode;
    }
    
    public Map<String, Integer> getRelacoesComPeso() {
        return relacoesComPeso;
    }

    public List<String> getRelacoesSemPeso() {
        return relacoesSemPeso;
    }

    public boolean setValorNode(String valorNode) {
        this.valorNode = valorNode;
        return true;
    }

    public boolean adicionarRelacao(String valorNode, int peso, boolean ponderado) {
        if (ponderado) {
            relacoesComPeso.put(valorNode, peso);
        } else {
            relacoesSemPeso.add(valorNode);
        }
        return true;
    }
}
