public class Participante {
    private String nome;
    private String email;
    private String tipo; // "Normal" ou "VIP"

    public Participante(String nome, String email, String tipo) {
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome + " - " + email + " - " + tipo;
    }
}
