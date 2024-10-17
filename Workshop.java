public class Workshop extends Evento {
    private String instrutor;
    private String materiais;
    private int cargaHoraria;

    public Workshop(String nome, String data, String local, int capacidadeMaxima, String instrutor, String materiais, int cargaHoraria) {
        super(nome, data, local, capacidadeMaxima);
        this.instrutor = instrutor;
        this.materiais = materiais;
        this.cargaHoraria = cargaHoraria;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public String getMateriais() {
        return materiais;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return super.toString() + " - Instrutor: " + instrutor + " - Materiais: " + materiais + " - Carga Horária: " + cargaHoraria + " horas";
    }
}
