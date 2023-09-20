public class Conta {
    private int id;
    private int pessoaId;
    private String numero;
    private String digito;
    private double saldo;
    private TipoConta tipoConta;

    public Conta(int id, int pessoaId, String numero, String digito, double saldo, TipoConta tipoConta) {
        this.id = id;
        this.pessoaId = pessoaId;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getPessoaId() {
        return pessoaId;
    }

    void setPessoa(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    String getNumero() {
        return numero;
    }

    void setNumero(String numero) {
        this.numero = numero;
    }

    String getDigito() {
        return digito;
    }

    void setDigito(String digito) {
        this.digito = digito;
    }

    double getSaldo() {
        return saldo;
    }

    void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    TipoConta getTipoConta() {
        return tipoConta;
    }

    void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println(this.saldo);
            return true;
        }
        System.out.println(this.saldo);
        return false;
    }
}
