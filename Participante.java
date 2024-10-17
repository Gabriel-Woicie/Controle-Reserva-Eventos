
public class Participante {
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
