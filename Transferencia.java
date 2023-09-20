import java.util.Date;

public class Transferencia {
    private int id;
    private int contaOrigemId;
    private int contaDestinoId;
    private double valor;
    private Date date;

    public Transferencia(int id, int contaOrigemId, int contaDestinoId, double valor, Date date) {
        this.id = id;
        this.contaOrigemId = contaOrigemId;
        this.contaDestinoId = contaDestinoId;
        this.valor = valor;
        this.date = date;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getContaOrigem() {
        return contaOrigemId;
    }

    void setContaOrigem(int contaOrigemId) {
        this.contaOrigemId = contaOrigemId;
    }

    int getContaDestino() {
        return contaDestinoId;
    }

    void setContaDestino(int contaDestinoId) {
        this.contaDestinoId = contaDestinoId;
    }

    double getValor() {
        return valor;
    }

    void setValor(double valor) {
        this.valor = valor;
    }

    Date getDate() {
        return date;
    }

    void setDate(Date date) {
        this.date = date;
    }

}
