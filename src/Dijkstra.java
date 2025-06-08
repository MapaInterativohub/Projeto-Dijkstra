
import java.util.*; // Importa classes utilitárias necessárias: Map, List, HashMap, PriorityQueue, etc.

public class Dijkstra {
    private final Grafo grafo; // Grafo sobre o qual será executado o algoritmo de Dijkstra.

    // Construtor da classe Dijkstra que recebe o grafo a ser usado.
    public Dijkstra(Grafo grafo) {
        this.grafo = grafo;
    }

    // Método que calcula o menor caminho entre a cidade de origem e a cidade de destino.
    public Resultado calcularMenorCaminho(String origem, String destino) {
        Map<String, Integer> distancias = new HashMap<>(); // Armazena a menor distância conhecida até cada cidade.
        Map<String, String> anteriores = new HashMap<>(); // Armazena o caminho anterior de cada cidade.
        
        // Fila de prioridade que seleciona sempre a cidade com a menor distância.
        PriorityQueue<String> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        
        // Inicializa todas as distâncias com infinito (valor máximo).
        for (String cidade : grafo.getVertices()) {
            distancias.put(cidade, Integer.MAX_VALUE);
        }

        // A distância da cidade de origem para ela mesma é zero.
        distancias.put(origem, 0);
        fila.add(origem); // Adiciona a cidade de origem à fila.

        // Enquanto houver cidades para processar:
        while (!fila.isEmpty()) {
            String atual = fila.poll(); // Remove a cidade com menor distância da fila.

            // Percorre todas as cidades vizinhas (adjacentes) da cidade atual.
            for (Grafo.Aresta aresta : grafo.getAdjacentes(atual)) {
                // Calcula a nova distância somando a distância atual com o peso da aresta.
                int novaDist = distancias.get(atual) + aresta.peso;

                // Se a nova distância for menor que a anteriormente registrada:
                if (novaDist < distancias.get(aresta.destino)) {
                    // Atualiza a distância e o caminho anterior.
                    distancias.put(aresta.destino, novaDist);
                    anteriores.put(aresta.destino, atual);
                    fila.add(aresta.destino); // Adiciona o vizinho à fila para processamento.
                }
            }
       }

        // Reconstrói o caminho do destino até a origem.
        List<String> caminho = new ArrayList<>();
        for (String at = destino; at != null; at = anteriores.get(at)) {
            caminho.add(at); // Adiciona cada cidade ao caminho.
        }
        Collections.reverse(caminho); // Inverte a ordem para mostrar do início ao fim.

        // Retorna o resultado com o caminho e a distância total.
        return new Resultado(caminho, distancias.get(destino));
    }

    // Classe interna que representa o resultado do algoritmo de Dijkstra.
    public static class Resultado {
        List<String> caminho; // Lista com o menor caminho encontrado.
        int distanciaTotal;   // Distância total do caminho.

        // Construtor do resultado.
        public Resultado(List<String> caminho, int distanciaTotal) {
            this.caminho = caminho;
            this.distanciaTotal = distanciaTotal;

            System.out.println(caminho);
        }

        // Método que imprime o resultado de forma legível.
        public void imprimirResultado() {
            System.out.println("Menor caminho: " + String.join(" -> ", caminho));
            System.out.println("Distância total: " + distanciaTotal + " km");
        }
    }
}
