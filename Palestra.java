import java.util.Date;

public class Palestra extends Evento {
    private String palestrante;
    private int duracao; // Em minutos
    private String temas;

    public Palestra(String nome, Date data, String local, int capacidadeMaxima, String palestrante, int duracao, String temas) {
        super(nome, data, local, capacidadeMaxima);
        this.palestrante = palestrante;
        this.duracao = duracao;
        this.temas = temas;
        // O palestrante também é um participante
        try {
            this.adicionarParticipante(new Participante(palestrante, palestrante + "@evento.com", true));
        } catch (ReservaException e) {
            System.out.println("Erro ao adicionar palestrante: " + e.getMessage());
        }
    }

    @Override
    public void detalhesEspecificos() {
        System.out.println("Palestrante: " + palestrante + ", Duração: " + duracao + " minutos, Temas: " + temas);
    }
}
