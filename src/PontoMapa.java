import java.awt.*; // Importa classes do Abstract Window Toolkit (AWT) para operações gráficas.
                    // Especificamente, precisamos de 'Graphics' e 'Color' aqui.

public class PontoMapa {
    // --- Variáveis de Membro ---
    // Estas são as propriedades que definem cada objeto PontoMapa.

    private int x;    // A coordenada X (posição horizontal) do ponto na imagem do mapa.
                      // 'private' significa que estas variáveis só podem ser acessadas diretamente dentro desta classe.
    private int y;    // A coordenada Y (posição vertical) do ponto na imagem do mapa.
    private String nome; // O nome do ponto (ex: "Rio Branco (AC)").

    // --- Construtor ---
    // Este é um método especial chamado quando você cria um novo objeto PontoMapa.
    public PontoMapa(int x, int y, String nome) {
        // 'this.x' refere-se à variável de membro 'x' da classe,
        // enquanto 'x' refere-se ao parâmetro 'x' passado para o construtor.
        
        this.x = x;       // Inicializa a coordenada X do ponto.
        this.y = y;       // Inicializa a coordenada Y do ponto.
        this.nome = nome; // Inicializa o nome do ponto.
    }

    // --- Métodos Getters ---
    // Estes métodos fornecem acesso público às variáveis de membro privadas.

    public int getX() {
        return x; // Retorna a coordenada X do ponto.
    }

    public int getY() {
        return y; // Retorna a coordenada Y do ponto.
    }

    public String getNome() {
        return nome; // Retorna o nome do ponto.
    }

    // --- Método de Desenho ---
    // Este método é responsável por desenhar o ponto em um determinado contexto Graphics.
    public void draw(Graphics g) {
        // Define a cor de desenho para azul. Isso afetará as operações de desenho subsequentes.
        g.setColor(Color.BLUE);
        // Desenha um oval preenchido (que aparece como um círculo) para representar o ponto.
        // 'x - 5' e 'y - 5' ajustam a posição para que o círculo seja centralizado em (x, y).
        // '10, 10' definem a largura e altura do oval, tornando-o um círculo de 10x10 pixels.
        g.fillOval(x - 5, y - 5, 10, 10); // Desenha o ponto em si

        // Define a cor de desenho para preto para o texto.
        g.setColor(Color.BLACK);
        // A linha abaixo está comentada, mas se descomentada, desenharia o nome do ponto
        // ligeiramente à direita do ponto.
        // g.drawString(nome, x + 8, y); // Desenha o nome do ponto perto de sua localização
    }
}
