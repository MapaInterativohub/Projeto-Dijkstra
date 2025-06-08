import java.awt.*;

public class PontoMapa {
    private int x;
    private int y;
    private String nome;

    public PontoMapa(int x, int y, String nome) {
        this.x = x;
        this.y = y;
        this.nome = nome;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNome() {
        return nome;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x - 5, y - 5, 10, 10); // ponto
        g.setColor(Color.BLACK);
        // g.drawString(nome, x + 8, y);
    }
}
