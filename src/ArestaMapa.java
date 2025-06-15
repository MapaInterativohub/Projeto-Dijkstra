public class ArestaMapa {
    // --- Variáveis de Membro ---
    // Essas variáveis privadas armazenam os nomes dos dois pontos que a aresta conecta.

    private String pontoInicial; // Armazena o nome do ponto de partida da aresta (ex: "Rio Branco (AC)").
    private String pontoFinal;   // Armazena o nome do ponto de chegada da aresta (ex: "Porto Velho (RO)").

    // --- Construtor ---
    // Este construtor é usado para criar uma nova instância de ArestaMapa.
    public ArestaMapa(String pontoInicial, String pontoFinal) {
        // 'this.pontoInicial' refere-se à variável de membro da classe,
        // enquanto 'pontoInicial' é o parâmetro passado para o construtor.
        this.pontoInicial = pontoInicial; // Inicializa o ponto inicial da aresta.
        this.pontoFinal = pontoFinal;     // Inicializa o ponto final da aresta.
    }

    // --- Métodos Getters e Setters ---
    // Esses métodos fornecem acesso público para ler (get) e, em alguns casos,
    // modificar (set) os valores das variáveis de membro privadas.

    public String getPontoInicial() {
        return pontoInicial; // Retorna o nome do ponto inicial da aresta.
    }

    public void setPontoInicial(String pontoInicial) {
        // Define (altera) o nome do ponto inicial da aresta.
        this.pontoInicial = pontoInicial;
    }

    public String getPontoFinal() {
        return pontoFinal; // Retorna o nome do ponto final da aresta.
    }

    public void setPontoFinal(String pontoFinal) {
        // Define (altera) o nome do ponto final da aresta.
        this.pontoFinal = pontoFinal;
    }
}