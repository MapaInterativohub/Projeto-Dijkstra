import javax.swing.*; // Importa classes do Swing para criar interfaces gráficas (janelas, botões, etc.)
import java.awt.*;    // Importa classes do AWT para desenho e manipulação de gráficos (Image, Graphics, Color, BasicStroke)
import java.awt.event.ActionEvent; // Classe para eventos de ação (ex: clique de botão)
import java.awt.event.ActionListener; // Interface para lidar com eventos de ação
import java.util.ArrayList; // Implementação de lista dinâmica (para vértices e arestas)
import java.util.List;      // Interface para coleções de dados (Listas)

public class MapaComPontosFixos extends JPanel {
    // Declaração de variáveis de instância da classe MapaComPontosFixos

    private Image mapa; // Objeto Image para armazenar a imagem do mapa que será exibida
    private List<PontoMapa> vertices = new ArrayList<>(); // Uma lista de objetos PontoMapa, representando as cidades no mapa
    private static List<ArestaMapa> aresta = new ArrayList<>(); // Uma lista estática de objetos ArestaMapa, usada para sinalizar a rota mais curta

    // Construtor da classe MapaComPontosFixos
    public MapaComPontosFixos(String caminhoImagem) {
        // Carrega a imagem do mapa a partir do caminho fornecido
        mapa = new ImageIcon(caminhoImagem).getImage();

        // Adiciona os pontos (cidades) manualmente à lista 'vertices'
        // Cada PontoMapa tem coordenadas X, Y e um nome (Cidade (SIGLA DO ESTADO))
        // vertices.add(new PontoMapa(137, 199, "Rio Branco (AC)"));
        // vertices.add(new PontoMapa(321, 39, "Boa Vista (RR)"));
        // vertices.add(new PontoMapa(308, 143, "Manaus (AM)"));
        // vertices.add(new PontoMapa(297, 228, "Porto Velho (RO)"));
        // vertices.add(new PontoMapa(490, 43, "Macapá (AP)"));
        // vertices.add(new PontoMapa(463, 160, "Belém (PA)"));
        // vertices.add(new PontoMapa(599, 156, "São Luís (MA)"));
        // vertices.add(new PontoMapa(696, 157, "Fortaleza (CE)"));/////
        // vertices.add(new PontoMapa(650, 192, "Teresina (PI)"));
        // vertices.add(new PontoMapa(734, 158, "Natal (RN)"));
        // vertices.add(new PontoMapa(723, 182, "João Pessoa (PB)"));
        // vertices.add(new PontoMapa(704, 199, "Recife (PE)"));
        // vertices.add(new PontoMapa(752, 223, "Maceió (AL)"));
        // vertices.add(new PontoMapa(733, 232, "Aracaju (SE)"));
        // vertices.add(new PontoMapa(670, 250, "Salvador (BA)"));
        // vertices.add(new PontoMapa(543, 244, "Palmas (TO)"));
        // vertices.add(new PontoMapa(439, 265, "Cuiabá (MT)"));
        // vertices.add(new PontoMapa(508, 324, "Goiânia (GO)"));
        // vertices.add(new PontoMapa(547, 297, "Brasília (DF)"));
        // vertices.add(new PontoMapa(459, 359, "Campo Grande (MS)"));
        // vertices.add(new PontoMapa(605, 329, "Belo Horizonte (MG)"));
        // vertices.add(new PontoMapa(671, 367, "Vitória (ES)"));
        // vertices.add(new PontoMapa(639, 401, "Rio de Janeiro (RJ)"));
        // vertices.add(new PontoMapa(544, 405, "São Paulo (SP)"));
        // vertices.add(new PontoMapa(486, 419, "Curitiba (PR)"));
        // vertices.add(new PontoMapa(524, 469, "Florianópolis (SC)"));
        // vertices.add(new PontoMapa(479, 490, "Porto Alegre (RS)"));
        CapitaisMapaService service = new CapitaisMapaService();
        vertices.addAll(service.getLista());
    }

    // --- Seção para inicialização e configuração dos componentes da interface ---
    // Este método é estático, o que significa que ele pertence à classe e não a uma instância específica.
    // É responsável por configurar os JComboBoxes, botões, áreas de texto e layout.
    private static void initComponents(JPanel painel, MapaComPontosFixos painelLateralMapa) {
        // Cria uma instância do Grafo.
        // O Grafo é onde os vértices (cidades) e arestas (conexões com distâncias) são armazenados.
        // CapitaisMapaService.criarListaCapitaisGrafo()
        Grafo grafo = new Grafo(); 

        // Adiciona todos os vértices (cidades com siglas) ao grafo.
        // Estes são os mesmos nomes usados na lista 'vertices' do MapaComPontosFixos.
        grafo.adicionarVertice("Aracajú (SE)");
        grafo.adicionarVertice("Belém (PA)");
        grafo.adicionarVertice("Belo Horizonte (MG)");
        grafo.adicionarVertice("Boa Vista (RR)");
        grafo.adicionarVertice("Brasília (DF)");
        grafo.adicionarVertice("Campo Grande (MS)");
        grafo.adicionarVertice("Cuiabá (MT)");
        grafo.adicionarVertice("Curitiba (PR)");
        grafo.adicionarVertice("Florianópolis (SC)");
        grafo.adicionarVertice("Fortaleza (CE)");
        grafo.adicionarVertice("Goiânia (GO)");
        grafo.adicionarVertice("João Pessoa (PB)");
        grafo.adicionarVertice("Macapá (AP)");
        grafo.adicionarVertice("Maceió (AL)");
        grafo.adicionarVertice("Manaus (AM)");
        grafo.adicionarVertice("Natal (RN)");
        grafo.adicionarVertice("Palmas (TO)");
        grafo.adicionarVertice("Porto Alegre (RS)");
        grafo.adicionarVertice("Porto Velho (RO)");
        grafo.adicionarVertice("Recife (PE)");
        grafo.adicionarVertice("Rio Branco (AC)");
        grafo.adicionarVertice("Rio de Janeiro (RJ)");
        grafo.adicionarVertice("Salvador (BA)");
        grafo.adicionarVertice("São Luís (MA)");
        grafo.adicionarVertice("São Paulo (SP)");
        grafo.adicionarVertice("Teresina (PI)");
        grafo.adicionarVertice("Vitória (ES)");

        // Adiciona as arestas (conexões entre cidades e suas distâncias) ao grafo.
        // Estas representam as rotas diretas entre as cidades vizinhas e suas distâncias.
        grafo.adicionarAresta("Rio Branco (AC)", "Porto Velho (RO)", 544);
        grafo.adicionarAresta("Macapá (AP)", "Belém (PA)", 306);
        grafo.adicionarAresta("Manaus (AM)", "Rio Branco (AC)", 1445);
        grafo.adicionarAresta("Manaus (AM)", "Boa Vista (RR)", 785);
        grafo.adicionarAresta("Manaus (AM)", "Porto Velho (RO)", 901);
        grafo.adicionarAresta("Manaus (AM)", "Belém (PA)", 5298);
        grafo.adicionarAresta("Manaus (AM)", "Cuiabá (MT)", 2357);
        grafo.adicionarAresta("Belém (PA)", "São Luís (MA)", 806);
        grafo.adicionarAresta("Belém (PA)", "Cuiabá (MT)", 2941);
        grafo.adicionarAresta("Belém (PA)", "Palmas (TO)", 1283);
        grafo.adicionarAresta("Belém (PA)", "Boa Vista (RR)", 6083);
        grafo.adicionarAresta("Porto Velho (RO)", "Cuiabá (MT)", 1456);
        grafo.adicionarAresta("Palmas (TO)", "São Luís (MA)", 1386);
        grafo.adicionarAresta("Palmas (TO)", "Teresina (PI)", 1401);
        grafo.adicionarAresta("Palmas (TO)", "Salvador (BA)", 1454);
        grafo.adicionarAresta("Palmas (TO)", "Goiânia (GO)", 874);
        grafo.adicionarAresta("Palmas (TO)", "Cuiabá (MT)", 1784);
        grafo.adicionarAresta("Maceió (AL)", "Recife (PE)", 285);
        grafo.adicionarAresta("Maceió (AL)", "Aracajú (SE)", 294);
        grafo.adicionarAresta("Maceió (AL)", "Salvador (BA)", 632);
        grafo.adicionarAresta("Salvador (BA)", "Aracajú (SE)", 356);
        grafo.adicionarAresta("Salvador (BA)", "Recife (PE)", 839);
        grafo.adicionarAresta("Salvador (BA)", "Teresina (PI)", 1163);
        grafo.adicionarAresta("Salvador (BA)", "Goiânia (GO)", 1643);
        grafo.adicionarAresta("Salvador (BA)", "Belo Horizonte (MG)", 1372);
        grafo.adicionarAresta("Salvador (BA)", "Vitória (ES)", 1202);
        grafo.adicionarAresta("Fortaleza (CE)", "Teresina (PI)", 634);
        grafo.adicionarAresta("Fortaleza (CE)", "Recife (PE)", 800);
        grafo.adicionarAresta("Fortaleza (CE)", "João Pessoa (PB)", 688);
        grafo.adicionarAresta("Fortaleza (CE)", "Natal (RN)", 537);
        grafo.adicionarAresta("São Luís (MA)", "Teresina (PI)", 446);
        grafo.adicionarAresta("João Pessoa (PB)", "Natal (RN)", 185);
        grafo.adicionarAresta("João Pessoa (PB)", "Recife (PE)", 120);
        grafo.adicionarAresta("Recife (PE)", "Teresina (PI)", 1137);
        grafo.adicionarAresta("Brasília (DF)", "Goiânia (GO)", 209);
        grafo.adicionarAresta("Brasília (DF)", "Belo Horizonte (MG)", 716);
        grafo.adicionarAresta("Goiânia (GO)", "Belo Horizonte (MG)", 906);
        grafo.adicionarAresta("Goiânia (GO)", "Cuiabá (MT)", 934);
        grafo.adicionarAresta("Cuiabá (MT)", "Campo Grande (MS)", 694);
        grafo.adicionarAresta("Campo Grande (MS)", "Belo Horizonte (MG)", 1453);
        grafo.adicionarAresta("Campo Grande (MS)", "São Paulo (SP)", 1014);
        grafo.adicionarAresta("Campo Grande (MS)", "Curitiba (PR)", 991);
        grafo.adicionarAresta("Vitória (ES)", "Belo Horizonte (MG)", 524);
        grafo.adicionarAresta("Vitória (ES)", "Rio de Janeiro (RJ)", 521);
        grafo.adicionarAresta("Belo Horizonte (MG)", "São Paulo (SP)", 586);
        grafo.adicionarAresta("Belo Horizonte (MG)", "Rio de Janeiro (RJ)", 434);
        grafo.adicionarAresta("Rio de Janeiro (RJ)", "São Paulo (SP)", 429);
        grafo.adicionarAresta("Curitiba (PR)", "São Paulo (SP)", 408);
        grafo.adicionarAresta("Curitiba (PR)", "Florianópolis (SC)", 300);
        grafo.adicionarAresta("Porto Alegre (RS)", "Florianópolis (SC)", 476);

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
        MapaComPontosFixos painelLateralMapa = new MapaComPontosFixos("src\\mapa.png");

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