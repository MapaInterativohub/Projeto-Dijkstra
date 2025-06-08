
import java.util.*; // Importa as classes utilitárias necessárias como Map, List, HashMap, ArrayList e Set.

public class Grafo {
    // Mapa que representa as conexões entre os vértices (cidades) e suas arestas (ligações com outras cidades).
    // A chave é o nome da cidade e o valor é a lista de arestas (destinos e pesos).
    private Map<String, List<Aresta>> adjacencias = new HashMap<>();

    // Método para adicionar um vértice (cidade) ao grafo.
    public void adicionarVertice(String nome) {
        // Só adiciona a cidade se ela ainda não estiver presente no grafo.
        adjacencias.putIfAbsent(nome, new ArrayList<>());
    }

    // Método para adicionar uma aresta entre duas cidades, com uma distância (peso).
    public void adicionarAresta(String origem, String destino, int distancia) {
        // Adiciona a aresta da origem para o destino.
        adjacencias.get(origem).add(new Aresta(destino, distancia));
        // Adiciona a aresta do destino para a origem, pois o grafo é não direcionado.
        adjacencias.get(destino).add(new Aresta(origem, distancia));
    }

    // Método que retorna a lista de cidades ligadas à cidade informada.
    public List<Aresta> getAdjacentes(String cidade) {
        // Retorna a lista de arestas da cidade ou uma lista vazia, caso a cidade não esteja no grafo.
        return adjacencias.getOrDefault(cidade, new ArrayList<>());
    }

    // Método que retorna o conjunto de todas as cidades (vértices) do grafo.
    public Set<String> getVertices() {
        return adjacencias.keySet();
    }

    // Classe interna que representa uma aresta do grafo.
    static class Aresta {
        String destino; // Cidade de destino dessa aresta.
        int peso;       // Distância (ou custo) da aresta.

        // Construtor da classe Aresta.
        Aresta(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}
