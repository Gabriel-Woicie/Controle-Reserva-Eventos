import java.util.ArrayList;
import java.util.List;

public abstract class Evento {
    protected String nome;
    protected String data;
    protected String local;
    protected int capacidadeMaxima;
    protected List<Participante> participantes;

    public Evento(String nome, String data, String local, int capacidadeMaxima) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public boolean adicionarParticipante(Participante p) {
        if (participantes.size() >= capacidadeMaxima) {
            System.out.println("Evento já está lotado!");
            return false;
        }
        for (Participante participante : participantes) {
            if (participante.getEmail().equals(p.getEmail())) {
                System.out.println("Participante já cadastrado no evento!");
                return false;
            }
        }
        participantes.add(p);
        return true;
    }

    public void listarParticipantes() {
        for (Participante p : participantes) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return nome + " - " + data + " - Capacidade: " + capacidadeMaxima + " - Inscritos: " + participantes.size();
    }
    }
