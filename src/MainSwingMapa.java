import javax.swing.*; // Importa classes do Swing para criar interfaces gráficas (janelas, botões, etc.)
import java.awt.*;    // Importa classes do AWT para desenho e manipulação de gráficos (Image, Graphics, Color, BasicStroke)
import java.awt.event.ActionEvent; // Classe para eventos de ação (ex: clique de botão)
import java.awt.event.ActionListener; // Interface para lidar com eventos de ação
import java.util.ArrayList; // Implementação de lista dinâmica (para vértices e arestas)
import java.util.List;      // Interface para coleções de dados (Listas)

public class MainSwingMapa extends JPanel {
    // Declaração de variáveis de instância da classe MapaComPontosFixos

    private Image mapa; // Objeto Image para armazenar a imagem do mapa que será exibida
    private List<PontoMapa> vertices = new ArrayList<>(); // Uma lista de objetos PontoMapa, representando as cidades no mapa
    private static List<ArestaMapa> aresta = new ArrayList<>(); // Uma lista estática de objetos ArestaMapa, usada para sinalizar a rota mais curta

    // Construtor da classe MapaComPontosFixos
    public MainSwingMapa(String caminhoImagem) {
        // Carrega a imagem do mapa a partir do caminho fornecido
        mapa = new ImageIcon(caminhoImagem).getImage();
        CapitaisMapaService service = new CapitaisMapaService();
        vertices.addAll(service.getLista());
    }

    // --- Seção para inicialização e configuração dos componentes da interface ---
    // Este método é estático, o que significa que ele pertence à classe e não a uma instância específica.
    // É responsável por configurar os JComboBoxes, botões, áreas de texto e layout.
    private static void initComponents(JPanel painel, MainSwingMapa painelLateralMapa) {
        // Cria uma instância do Grafo.
        Grafo grafo = new Grafo(); 

        CapitaisMapaService.criarListaCapitaisVerticesGrafo(grafo);     // Usa os Vertices criado no na classe  CapitaisMapaService
        CapitaisMapaService.criarListaCapitaisArestaGrafo(grafo);       // Usa os Aresta criado no na classe  CapitaisMapaService

        // Cria JComboBoxes (menus suspensos) para selecionar a cidade de origem e destino
        // O método getVertices() do grafo retorna todos os nomes dos vértices.
        JComboBox<String> comboOrigem = new JComboBox<>(grafo.getVertices().toArray(new String[0]));
        JComboBox<String> comboDestino = new JComboBox<>(grafo.getVertices().toArray(new String[0]));

        // Cria uma JTextArea para exibir o resultado do cálculo do menor caminho
        JTextArea resultadoArea = new JTextArea(5, 20); // 5 linhas, 20 colunas
        resultadoArea.setEditable(false); // Torna a área de texto somente leitura
        JScrollPane scrollPane = new JScrollPane(resultadoArea); // Adiciona uma barra de rolagem à área de texto

        // Cria um botão para iniciar o cálculo do menor caminho
        JButton calcularBtn = new JButton("Calcular Menor Caminho");

        // Adiciona um Listener (ouvinte) ao botão "Calcular Menor Caminho"
        // Este código será executado quando o botão for clicado
        calcularBtn.addActionListener(new ActionListener() {
            @Override // Sobrescreve o método actionPerformed da interface ActionListener
            public void actionPerformed(ActionEvent e) {
                // Obtém as cidades selecionadas nos JComboBoxes de origem e destino
                String origem = (String) comboOrigem.getSelectedItem();
                String destino = (String) comboDestino.getSelectedItem();

                // Verifica se a origem e o destino são iguais
                if (origem.equals(destino)) {
                    resultadoArea.setText("Origem e destino devem ser diferentes."); // Exibe mensagem de erro
                    return; // Sai do método
                }

                // Cria uma instância do algoritmo de Dijkstra, passando o grafo
                Dijkstra dijkstra = new Dijkstra(grafo);
                // Calcula o menor caminho entre a origem e o destino
                Dijkstra.Resultado resultado = dijkstra.calcularMenorCaminho(origem, destino);

                String cidadeAnterior = null; // Variável para armazenar a cidade anterior no caminho
                aresta.clear(); // Limpa a lista de arestas para sinalização da rota anterior
                // Itera sobre o caminho encontrado pelo Dijkstra para criar as arestas de sinalização
                for (int i = 0; i < resultado.caminho.size(); i++) {
                    String cidadeAtual = resultado.caminho.get(i); // Pega a cidade atual no caminho
                    if (cidadeAnterior != null) { // Se não for a primeira cidade do caminho
                        // Adiciona uma nova ArestaMapa à lista 'aresta'
                        // Esta aresta será usada para desenhar a linha vermelha no mapa
                        aresta.add(new ArestaMapa(cidadeAnterior, cidadeAtual));
                        painelLateralMapa.repaint(); // Solicita que o painel do mapa seja redesenhado
                    }
                    cidadeAnterior = cidadeAtual; // Atualiza a cidade anterior para a próxima iteração
                }

                // Exibe o resultado do menor caminho e a distância total na área de texto
                resultadoArea.setText("Menor caminho: " + String.join(" -> ", resultado.caminho) +
                                "\nDistância total: " + resultado.distanciaTotal + " km");
            }
        });

        // Configurações do GridBagLayout para organizar os componentes no painel lateral
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Define espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Faz os componentes preencherem o espaço horizontalmente

        // Adiciona o rótulo "Origem:"
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        painel.add(new JLabel("Origem:"), gbc);
        // Adiciona o JComboBox de origem
        gbc.gridx = 1; // Coluna 1
        painel.add(comboOrigem, gbc);

        // Adiciona o rótulo "Destino:"
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        painel.add(new JLabel("Destino:"), gbc);
        // Adiciona o JComboBox de destino
        gbc.gridx = 1; // Coluna 1
        painel.add(comboDestino, gbc);

        // Adiciona o botão "Calcular Menor Caminho"
        gbc.gridx = 0;     // Coluna 0
        gbc.gridy = 2;     // Linha 2
        gbc.gridwidth = 2; // Ocupa 2 colunas
        painel.add(calcularBtn, gbc);

        // Adiciona a área de texto com barra de rolagem
        gbc.gridy = 3; // Linha 3
        painel.add(scrollPane, gbc);
    }

    // --- Método de Pintura do Componente ---
    // Este método é chamado automaticamente pelo Swing sempre que o componente precisa ser redesenhado.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Chama o método paintComponent da superclasse (JPanel) para garantir o desenho correto.

        // Desenha a imagem do mapa preenchendo todo o painel
        g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);

        // Desenha todos os pontos (cidades) na tela
        for (PontoMapa ponto : vertices) {
            ponto.draw(g); // Chama o método draw() de cada PontoMapa para desenhá-lo
        }

        // Converte o objeto Graphics para Graphics2D para permitir controle de espessura da linha
        Graphics2D g2d = (Graphics2D) g;

        // FAZ A SINALIZAÇÃO DA MELHOR ROTA
        // Itera sobre a lista de arestas que representam o menor caminho (definidas no ActionListener)
        for (int x = 0; x < aresta.size(); x++) {
            ArestaMapa arest = aresta.get(x); // Pega a aresta atual do menor caminho

            boolean encontrado = false; // Flag para verificar se os pontos da aresta foram encontrados
            PontoMapa p1 = null;        // Ponto inicial da aresta no mapa
            PontoMapa p2 = null;        // Ponto final da aresta no mapa

            // Procura o PontoMapa correspondente ao ponto inicial da aresta
            for (int i = 0; i < vertices.size(); i++) { // Alterado para vertices.size() para evitar IndexOutOfBoundsException
                p1 = vertices.get(i);
                if (arest.getPontoInicial().equals(p1.getNome())) {
                    break; // Encontrou o ponto inicial, sai do loop
                }
            }
            // Procura o PontoMapa correspondente ao ponto final da aresta
            for (int i = 0; i < vertices.size(); i++) { // Alterado para vertices.size()
                p2 = vertices.get(i);
                if (arest.getPontoFinal().equals(p2.getNome())) {
                    encontrado = true; // Encontrou o ponto final
                    break; // Sai do loop
                }
            }

            // Se ambos os pontos (inicial e final) da aresta foram encontrados no mapa
            if (encontrado) {
                g2d.setColor(Color.RED); // Define a cor da linha para vermelho
                g2d.setStroke(new BasicStroke(3.0f)); // Define a espessura da linha para 3.0 pixels
                // Desenha a linha entre os dois pontos encontrados
                g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            }
        }
    }

    // --- Método Principal (main) ---
    // Ponto de entrada da aplicação Java.
    public static void main(String[] args) {
        // Cria a janela principal da aplicação (JFrame)
        JFrame frame = new JFrame("Mapa com Pontos Fixos");

        // Painel principal que usará BorderLayout para organizar o mapa e o painel lateral
        JPanel painelLateralPrincipal = new JPanel(new BorderLayout());

        // Cria uma instância do painel do mapa, passando o caminho da imagem
        // "src\\mapa.png" assume que a imagem "mapa.png" está na pasta "src" do seu projeto.
        MainSwingMapa painelLateralMapa = new MainSwingMapa("src\\mapa.png");

        // Cria o painel lateral que conterá os controles (ComboBoxes, botão, área de texto)
        JPanel painelLateral = new JPanel();
        painelLateral.setPreferredSize(new Dimension(300, 600)); // Define um tamanho preferencial para o painel lateral
        painelLateral.setLayout(new GridBagLayout()); // Define o layout para GridBagLayout para posicionamento flexível

        // Inicializa os componentes (ComboBoxes, botão, área de texto) no painel lateral
        initComponents(painelLateral, painelLateralMapa);

        // Monta a janela principal:
        // Adiciona o painel do mapa ao centro do painel principal
        painelLateralPrincipal.add(painelLateralMapa, BorderLayout.CENTER);
        // Adiciona o painel lateral à direita do painel principal
        painelLateralPrincipal.add(painelLateral, BorderLayout.EAST);

        // Define o conteúdo da janela principal como o painel principal
        frame.setContentPane(painelLateralPrincipal);
        frame.pack(); // Ajusta o tamanho da janela para acomodar seus componentes
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela (encerra a aplicação)
        frame.setSize(1100, 600); // Define o tamanho explícito da janela (largura, altura)
        frame.setVisible(true); // Torna a janela visível
    }
}