

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MapaComClique extends JPanel {
    int valor = 0;

    private Image mapa;
    private List<PontoMapa> vertices = new ArrayList<>();

    public MapaComClique(String caminhoImagem) {
        mapa = new ImageIcon(caminhoImagem).getImage();

        // Exemplo: pontos adicionados manualmente
        // vertices.add(new PontoMapa(100, 150, "Cidade A"));
        // vertices.add(new PontoMapa(200, 250, "Cidade B"));

        // Adiciona o listener de clique para mostrar coordenadas
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                valor++;
                System.out.println("Clique "+ valor +" em: " + x + "," + y);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha o mapa
        g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);

        // Desenha os pontos
        for (PontoMapa ponto : vertices) {
            ponto.draw(g);
        }

        // Desenha conexões entre pontos
        g.setColor(Color.BLUE);
        for (int i = 0; i < vertices.size() - 1; i++) {
            PontoMapa p1 = vertices.get(i);
            PontoMapa p2 = vertices.get(i + 1);
            g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mapa - Clique para Coordenadas");
        MapaComClique painel = new MapaComClique("src\\mapa.png");

        frame.setContentPane(painel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
