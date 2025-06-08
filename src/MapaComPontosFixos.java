import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MapaComPontosFixos extends JPanel {
    private Image mapa;
    private List<PontoMapa> vertices = new ArrayList<>();
    private static List<ArestaMapa> aresta = new ArrayList<>();

    public MapaComPontosFixos(String caminhoImagem) {
        mapa = new ImageIcon(caminhoImagem).getImage();

        // Adiciona os pontos manualmente
        vertices.add(new PontoMapa(137, 199, "Rio Branco (AC)"));
        vertices.add(new PontoMapa(321, 39, "Boa Vista (RR)"));
        vertices.add(new PontoMapa(308, 143, "Manaus (AM)"));
        vertices.add(new PontoMapa(297, 228, "Porto Velho (RO)"));
        vertices.add(new PontoMapa(490, 43, "Macapá (AP)"));
        vertices.add(new PontoMapa(463, 160, "Belém (PA)"));
        vertices.add(new PontoMapa(599, 156, "São Luís (MA)"));
        vertices.add(new PontoMapa(696, 157, "Fortaleza (CE)"));/////
        vertices.add(new PontoMapa(650, 192, "Teresina (PI)"));
        vertices.add(new PontoMapa(734, 158, "Natal (RN)"));
        vertices.add(new PontoMapa(723, 182, "João Pessoa (PB)"));
        vertices.add(new PontoMapa(704, 199, "Recife (PE)"));
        vertices.add(new PontoMapa(752, 223, "Maceió (AL)"));
        vertices.add(new PontoMapa(733, 232, "Aracaju (SE)"));
        vertices.add(new PontoMapa(670, 250, "Salvador (BA)"));
        vertices.add(new PontoMapa(543, 244, "Palmas (TO)"));
        vertices.add(new PontoMapa(439, 265, "Cuiabá (MT)"));
        vertices.add(new PontoMapa(508, 324, "Goiânia (GO)"));
        vertices.add(new PontoMapa(547, 297, "Brasília (DF)"));
        vertices.add(new PontoMapa(459, 359, "Campo Grande (MS)"));
        vertices.add(new PontoMapa(605, 329, "Belo Horizonte (MG)"));
        vertices.add(new PontoMapa(671, 367, "Vitória (ES)"));
        vertices.add(new PontoMapa(639, 401, "Rio de Janeiro (RJ)"));
        vertices.add(new PontoMapa(544, 405, "São Paulo (SP)"));
        vertices.add(new PontoMapa(486, 419, "Curitiba (PR)"));
        vertices.add(new PontoMapa(524, 469, "Florianópolis (SC)"));
        vertices.add(new PontoMapa(479, 490, "Porto Alegre (RS)"));
    }

    // ________________________________________________________________________________________________
    private static void initComponents(JPanel painel, MapaComPontosFixos painelLateralMapa) {
        // Simula grafo para exemplo
        Grafo grafo = new Grafo(); // Certifique-se de ter o grafo instanciado

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

        JComboBox<String> comboOrigem = new JComboBox<>(grafo.getVertices().toArray(new String[0]));
        JComboBox<String> comboDestino = new JComboBox<>(grafo.getVertices().toArray(new String[0]));

        JTextArea resultadoArea = new JTextArea(5, 20);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        JButton calcularBtn = new JButton("Calcular Menor Caminho");

        calcularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origem = (String) comboOrigem.getSelectedItem();
                String destino = (String) comboDestino.getSelectedItem();

                if (origem.equals(destino)) {
                    resultadoArea.setText("Origem e destino devem ser diferentes.");
                    return;
                }

                Dijkstra dijkstra = new Dijkstra(grafo);
                Dijkstra.Resultado resultado = dijkstra.calcularMenorCaminho(origem, destino);

                String cidadeAnterior = null;
                aresta.clear();
                for (int i = 0; i < resultado.caminho.size(); i++) {
                    String cidadeAtual = resultado.caminho.get(i);
                    if (cidadeAnterior != null) {
                        aresta.add(new ArestaMapa(cidadeAnterior, cidadeAtual));
                        painelLateralMapa.repaint();
                    }
                    cidadeAnterior = cidadeAtual;
                }

                resultadoArea.setText("Menor caminho: " + String.join(" -> ", resultado.caminho) +
                        "\nDistância total: " + resultado.distanciaTotal + " km");
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel("Origem:"), gbc);
        gbc.gridx = 1;
        painel.add(comboOrigem, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel("Destino:"), gbc);
        gbc.gridx = 1;
        painel.add(comboDestino, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        painel.add(calcularBtn, gbc);

        gbc.gridy = 3;
        painel.add(scrollPane, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a imagem do mapa
        g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);

        // Desenha os pontos e os nomes
        for (PontoMapa ponto : vertices) {
            ponto.draw(g);
        }
        
        Graphics2D g2d = (Graphics2D) g;
        // FAZ A SINALIZAÇÃO DA MELHOR ROTA
        for (int x = 0; x < aresta.size(); x++) {
            ArestaMapa arest = aresta.get(x);

            boolean encontrado = false;
            PontoMapa p1 = null;
            PontoMapa p2 = null;

            for (int i = 0; i < vertices.size() - 1; i++) {
                p1 = vertices.get(i);
                if (arest.getPontoInicial().equals(p1.getNome())) {
                    break;
                }

            }
            for (int i = 0; i < vertices.size() - 1; i++) {
                p2 = vertices.get(i);
                if (arest.getPontoFinal().equals(p2.getNome())) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(3.0f));
                g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            }
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mapa com Pontos Fixos");

        // Painel principal com layout
        JPanel painelLateralPrincipal = new JPanel(new BorderLayout());

        // Painel do mapa
        MapaComPontosFixos painelLateralMapa = new MapaComPontosFixos("src\\mapa.png");

        // Painel lateral para os componentes
        JPanel painelLateral = new JPanel();
        painelLateral.setPreferredSize(new Dimension(300, 600)); // Largura fixa
        painelLateral.setLayout(new GridBagLayout());

        // Inicializa os componentes no painel lateral
        initComponents(painelLateral, painelLateralMapa);

        // Monta a janela
        painelLateralPrincipal.add(painelLateralMapa, BorderLayout.CENTER);
        painelLateralPrincipal.add(painelLateral, BorderLayout.EAST);

        frame.setContentPane(painelLateralPrincipal);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
        frame.setVisible(true);
    }

}
