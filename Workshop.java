import java.util.Date;

public class Workshop extends Evento {
    private String instrutores;
    private String materiaisNecessarios;
    private int cargaHoraria; // Em horas

    public Workshop(String nome, Date data, String local, int capacidadeMaxima, String instrutores, String materiaisNecessarios, int cargaHoraria) {
        super(nome, data, local, capacidadeMaxima);
        this.instrutores = instrutores;
        this.materiaisNecessarios = materiaisNecessarios;
        this.cargaHoraria = cargaHoraria;
        // O instrutor também é um participante
        try {
            this.adicionarParticipante(new Participante(instrutores, instrutores + "@evento.com", true));
        } catch (ReservaException e) {
            System.out.println("Erro ao adicionar instrutor: " + e.getMessage());
        }
    }

    @Override
    public void detalhesEspecificos() {
        System.out.println("Instrutores: " + instrutores + ", Materiais: " + materiaisNecessarios + ", Carga Horária: " + cargaHoraria + " horas");
    }
}
