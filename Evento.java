import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Evento {
    protected String nome;
    protected Date data;
    protected String local;
    protected int capacidadeMaxima;
    protected List<Participante> participantes;

    public Evento(String nome, Date data, String local, int capacidadeMaxima) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantes = new ArrayList<>();
    }

    public boolean adicionarParticipante(Participante participante) throws ReservaException {
        if (participantes.size() >= capacidadeMaxima) {
            throw new ReservaException("O evento já está lotado.");
        }
        if (participantes.contains(participante)) {
            throw new ReservaException("O participante já está registrado no evento.");
        }
        participantes.add(participante);
        return true;
    }

    public void listarParticipantes() {
        System.out.println("Participantes do evento " + nome + ":");
        for (Participante p : participantes) {
            System.out.println(p);
        }
    }

    public void listarParticipantesVIP() {
        System.out.println("Participantes VIP do evento " + nome + ":");
        for (Participante p : participantes) {
            if (p.isVip()) {
                System.out.println(p);
            }
        }
    }

    public int getNumeroParticipantes() {
        return participantes.size();
    }

    public abstract void detalhesEspecificos();
}
