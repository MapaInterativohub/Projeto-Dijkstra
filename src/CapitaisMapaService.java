import java.util.ArrayList;
import java.util.List;

public class CapitaisMapaService {
    List<PontoMapa> lista;

    public CapitaisMapaService() {
        this.lista = new ArrayList<PontoMapa>();
        this.criarListaCapitaisMapa();
    }

    private void criarListaCapitaisMapa() {
        this.lista.add(new PontoMapa(137, 199, "Rio Branco (AC)"));
        this.lista.add(new PontoMapa(321, 39, "Boa Vista (RR)"));
        this.lista.add(new PontoMapa(308, 143, "Manaus (AM)"));
        this.lista.add(new PontoMapa(297, 228, "Porto Velho (RO)"));
        this.lista.add(new PontoMapa(490, 43, "Macapá (AP)"));
        this.lista.add(new PontoMapa(463, 160, "Belém (PA)"));
        this.lista.add(new PontoMapa(599, 156, "São Luís (MA)"));
        this.lista.add(new PontoMapa(696, 157, "Fortaleza (CE)"));/////
        this.lista.add(new PontoMapa(650, 192, "Teresina (PI)"));
        this.lista.add(new PontoMapa(734, 158, "Natal (RN)"));
        this.lista.add(new PontoMapa(723, 182, "João Pessoa (PB)"));
        this.lista.add(new PontoMapa(704, 199, "Recife (PE)"));
        this.lista.add(new PontoMapa(752, 223, "Maceió (AL)"));
        this.lista.add(new PontoMapa(733, 232, "Aracaju (SE)"));
        this.lista.add(new PontoMapa(670, 250, "Salvador (BA)"));
        this.lista.add(new PontoMapa(543, 244, "Palmas (TO)"));
        this.lista.add(new PontoMapa(439, 265, "Cuiabá (MT)"));
        this.lista.add(new PontoMapa(508, 324, "Goiânia (GO)"));
        this.lista.add(new PontoMapa(547, 297, "Brasília (DF)"));
        this.lista.add(new PontoMapa(459, 359, "Campo Grande (MS)"));
        this.lista.add(new PontoMapa(605, 329, "Belo Horizonte (MG)"));
        this.lista.add(new PontoMapa(671, 367, "Vitória (ES)"));
        this.lista.add(new PontoMapa(639, 401, "Rio de Janeiro (RJ)"));
        this.lista.add(new PontoMapa(544, 405, "São Paulo (SP)"));
        this.lista.add(new PontoMapa(486, 419, "Curitiba (PR)"));
        this.lista.add(new PontoMapa(524, 469, "Florianópolis (SC)"));
        this.lista.add(new PontoMapa(479, 490, "Porto Alegre (RS)"));
    }

    public static void criarListaCapitaisVerticesGrafo(Grafo grafo) {
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
    }
    public static void criarListaCapitaisArestaGrafo(Grafo grafo){
        // Adiciona as arestas (conexões entre cidades e suas distâncias) ao grafo.
        // Estas representam as rotas diretas entre as cidades vizinhas e suas
        // distâncias.
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
    }

    public List<PontoMapa> getLista() {
        return this.lista;
    }
}
