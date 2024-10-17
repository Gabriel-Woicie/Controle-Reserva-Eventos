import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Classe Participante
class Participante {
    private String nome;
    private String email;
    private boolean isVip;

    public Participante(String nome, String email, boolean isVip) {
        this.nome = nome;
        this.email = email;
        this.isVip = isVip;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVip() {
        return isVip;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Tipo: " + (isVip ? "VIP" : "Normal");
    }
}

// Classe Evento (classe base)
abstract class Evento {
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

    public boolean adicionarParticipante(Participante participante) {
        if (participantes.size() < capacidadeMaxima) {
            participantes.add(participante);
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void listarParticipantes() {
        System.out.println("Participantes do evento " + nome + ":");
        for (Participante p : participantes) {
            System.out.println(p);
        }
    }

    public abstract void detalhesEspecificos();
}

// Subclasse Palestra
class Palestra extends Evento {
    private String palestrante;
    private int duracao; // Em minutos
    private String temas;

    public Palestra(String nome, Date data, String local, int capacidadeMaxima, String palestrante, int duracao, String temas) {
        super(nome, data, local, capacidadeMaxima);
        this.palestrante = palestrante;
        this.duracao = duracao;
        this.temas = temas;
        // O palestrante também é um participante
        this.adicionarParticipante(new Participante(palestrante, palestrante + "@evento.com", true));
    }

    @Override
    public void detalhesEspecificos() {
        System.out.println("Palestrante: " + palestrante + ", Duração: " + duracao + " minutos, Temas: " + temas);
    }
}

// Subclasse Workshop
class Workshop extends Evento {
    private String instrutores;
    private String materiaisNecessarios;
    private int cargaHoraria; // Em horas

    public Workshop(String nome, Date data, String local, int capacidadeMaxima, String instrutores, String materiaisNecessarios, int cargaHoraria) {
        super(nome, data, local, capacidadeMaxima);
        this.instrutores = instrutores;
        this.materiaisNecessarios = materiaisNecessarios;
        this.cargaHoraria = cargaHoraria;
        // O instrutor também é um participante
        this.adicionarParticipante(new Participante(instrutores, instrutores + "@evento.com", true));
    }

    @Override
    public void detalhesEspecificos() {
        System.out.println("Instrutores: " + instrutores + ", Materiais: " + materiaisNecessarios + ", Carga Horária: " + cargaHoraria + " horas");
    }
}

// Classe principal para testes
public class SistemaEventos {
    public static void main(String[] args) {
        
        System.out.println("Digite os dados do Evento!:");
        
        //Pede ao usuário nome do evento
        System.out.print("Nome do evento: ");
        String evento = scanner.nextLine();
        
        //Pede ao usuário data do evento
        System.out.print("Data do evento: ");
        String data = scanner.nextLine();

        // Scanner para leitura de dados do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitando dados do participante 1
        System.out.println("Digite os dados do primeiro participante:");

        System.out.print("Nome: ");
        String nome1 = scanner.nextLine();

        System.out.print("Email: ");
        String email1 = scanner.nextLine();

        System.out.print("É VIP? (true/false): ");
        boolean isVip1 = scanner.nextBoolean();
        scanner.nextLine();  // Limpa o buffer

        // Criando o primeiro participante
        Participante participante1 = new Participante(nome1, email1, isVip1);

        // Solicitando dados do participante 2
        System.out.println("\nDigite os dados do segundo participante:");

        System.out.print("Nome: ");
        String nome2 = scanner.nextLine();

        System.out.print("Email: ");
        String email2 = scanner.nextLine();

        System.out.print("É VIP? (true/false): ");
        boolean isVip2 = scanner.nextBoolean();

        // Criando o segundo participante
        Participante participante2 = new Participante(nome2, email2, isVip2);

        // Criando uma palestra
        Palestra palestra = new Palestra("Palestra de Tecnologia", new Date(), "Auditório 1", 50, "Dr. João", 120, "Inovação, IA, Tecnologia");
        palestra.adicionarParticipante(participante1);

        // Criando um workshop
        Workshop workshop = new Workshop("Workshop de Programação", new Date(), "Sala 101", 30, "Prof. Silva", "Notebook, IDE", 8);
        workshop.adicionarParticipante(participante2);

        // Exibindo detalhes dos eventos
        System.out.println("\nDetalhes da Palestra:");
        palestra.detalhesEspecificos();
        palestra.listarParticipantes();

        System.out.println("\nDetalhes do Workshop:");
        workshop.detalhesEspecificos();
        workshop.listarParticipantes();

        // Fechando o scanner
        scanner.close();
    }
}
