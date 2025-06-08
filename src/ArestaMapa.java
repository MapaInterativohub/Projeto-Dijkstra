import java.awt.*;
import java.util.ArrayList;

public class ArestaMapa {
    private String pontoInicial;
    private String pontoFinal;
    
    public ArestaMapa(String pontoInicial, String pontoFinal) {
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
    }
    public String getPontoInicial() {
        return pontoInicial;
    }
    public void setPontoInicial(String pontoInicial) {
        this.pontoInicial = pontoInicial;
    }
    public String getPontoFinal() {
        return pontoFinal;
    }
    public void setPontoFinal(String pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

}