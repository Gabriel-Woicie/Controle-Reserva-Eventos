import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Evento> eventos = new ArrayList<>();
    private List<Participante> participantes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("========================================");
            System.out.println("       Sistema de Controle de Eventos       ");
            System.out.println("========================================");
            System.out.println("1. Criar Palestra");
            System.out.println("2. Criar Workshop");
            System.out.println("3. Criar Participante");
            System.out.println("4. Gerenciar Reservas");
            System.out.println("5. Relatórios");
            System.out.println("6. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            switch (opcao) {
                case 1:
                    criarPalestra();
                    break;
                case 2:
                    criarWorkshop();
                    break;
                case 3:
                    criarParticipante();
                    break;
                case 4:
                    gerenciarReservas();
                    break;
                case 5:
                    gerarRelatorios();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    private void criarPalestra() {
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Data (DD/MM/AAAA HH:MM): ");
        String data = scanner.nextLine();
        System.out.print("Local: ");
        String local = scanner.nextLine();
        System.out.print("Capacidade máxima: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Nome do palestrante: ");
        String palestrante = scanner.nextLine();
        System.out.print("Duração (em horas): ");
        int duracao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Temas abordados: ");
        String temas = scanner.nextLine();

        Palestra palestra = new Palestra(nome, data, local, capacidade, palestrante, duracao, temas);
        eventos.add(palestra);
        System.out.println("Palestra criada com sucesso!");
    }

    private void criarWorkshop() {
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Data (DD/MM/AAAA HH:MM): ");
        String data = scanner.nextLine();
        System.out.print("Local: ");
        String local = scanner.nextLine();
        System.out.print("Capacidade máxima: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Nome do instrutor: ");
        String instrutor = scanner.nextLine();
        System.out.print("Materiais necessários: ");
        String materiais = scanner.nextLine();
        System.out.print("Carga horária (em horas): ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Workshop workshop = new Workshop(nome, data, local, capacidade, instrutor, materiais, cargaHoraria);
        eventos.add(workshop);
        System.out.println("Workshop criado com sucesso!");
    }

    private void criarParticipante() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Tipo (Normal ou VIP): ");
        String tipo = scanner.nextLine();

        Participante participante = new Participante(nome, email, tipo);
        participantes.add(participante);
        System.out.println("Participante criado com sucesso!");
    }

    private void gerenciarReservas() {
        System.out.println("========================================");
        System.out.println("          Gerenciamento de Reservas");
        System.out.println("========================================");
        System.out.println("1. Adicionar Reserva");
        System.out.println("2. Cancelar Reserva");
        System.out.println("3. Listar Reservas");
        System.out.println("4. Voltar ao menu principal");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                adicionarReserva();
                break;
            case 2:
                cancelarReserva();
                break;
            case 3:
                listarReservas();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void adicionarReserva() {
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado!");
            return;
        }

        System.out.print("Digite o e-mail do participante: ");
        String emailParticipante = scanner.nextLine();
        Participante participante = buscarParticipantePorEmail(emailParticipante);
        if (participante == null) {
            System.out.println("Participante não encontrado!");
            return;
        }

        if (evento.adicionarParticipante(participante)) {
            System.out.println("Reserva adicionada com sucesso!");
        }
    }

    private void cancelarReserva() {
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado!");
            return;
        }

        System.out.print("Digite o e-mail do participante: ");
        String emailParticipante = scanner.nextLine();
        Participante participante = buscarParticipantePorEmail(emailParticipante);
        if (participante == null || !evento.getParticipantes().contains(participante)) {
            System.out.println("Participante não encontrado no evento!");
            return;
        }

        evento.getParticipantes().remove(participante);
        System.out.println("Reserva cancelada com sucesso!");
    }

    private void listarReservas() {
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado!");
            return;
        }

        System.out.println("Participantes inscritos:");
        evento.listarParticipantes();
    }

    private void gerarRelatorios() {
        System.out.println("========================================");
        System.out.println("               Relatórios");
        System.out.println("========================================");
        System.out.println("1. Lista de Eventos");
        System.out.println("2. Lista de Participantes de um Evento");
        System.out.println("3. Lista de Participantes VIP");
        System.out.println("4. Voltar ao menu principal");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                listarEventos();
                break;
            case 2:
                listarParticipantesDeEvento();
                break;
            case 3:
                listarParticipantesVIP();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    private void listarParticipantesDeEvento() {
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado!");
            return;
        }

        System.out.println("Participantes:");
        evento.listarParticipantes();
    }

    private void listarParticipantesVIP() {
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado!");
            return;
        }

        System.out.println("Participantes VIP:");
        for (Participante p : evento.getParticipantes()) {
            if (p.getTipo().equalsIgnoreCase("VIP")) {
                System.out.println(p);
            }
        }
    }

    private Evento buscarEventoPorNome(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nome)) {
                return evento;
            }
        }
        return null;
    }

    private Participante buscarParticipantePorEmail(String email) {
        for (Participante participante : participantes) {
            if (participante.getEmail().equalsIgnoreCase(email)) {
                return participante;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.menuPrincipal();
    }
}
