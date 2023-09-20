public class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private String cpf;

    public Pessoa(int id, String nome, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getNome() {
        return nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    String getTelefone() {
        return telefone;
    }

    void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    String getCpf() {
        return cpf;
    }

    void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
