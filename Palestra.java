public class Palestra extends Evento {
    private String palestrante;
    private int duracao;
    private String temas;

    public Palestra(String nome, String data, String local, int capacidadeMaxima, String palestrante, int duracao, String temas) {
        super(nome, data, local, capacidadeMaxima);
        this.palestrante = palestrante;
        this.duracao = duracao;
        this.temas = temas;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getTemas() {
        return temas;
    }

    @Override
    public String toString() {
        return super.toString() + " - Palestrante: " + palestrante + " - Duração: " + duracao + " horas - Temas: " + temas;
    }
}
